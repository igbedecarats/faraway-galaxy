package org.galaxy.galaxyweathersimulator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This class handles exceptions raised in any part of the external
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  private static final Log logger = LogFactory.getLog(GlobalExceptionHandler.class);

  /**
   * Catch and log Spring MVC specific exceptions
   */
  @NotNull
  @Override
  protected ResponseEntity<Object> handleExceptionInternal(
      @NotNull final Exception ex, final Object body, final HttpHeaders headers, final HttpStatus status,
      @NotNull final WebRequest request) {
    logger.error("Spring MVC exception occurred", ex);
    return super.handleExceptionInternal(ex, body, headers, status, request);
  }

  @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
  @ResponseBody
  public ResponseEntity<?> handleBadRequests(final Exception ex) {
    return toResponseEntity(ex, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(IllegalStateException.class)
  @ResponseBody
  public ResponseEntity<?> handleIllegalStateRequests(final Exception ex) {
    return toResponseEntity(ex, HttpStatus.CONFLICT);
  }

  private ResponseEntity<HttpApiError> toResponseEntity(
      final Throwable throwable,
      final HttpStatus httpStatus) {
    log(throwable);
    HttpApiError error = HttpApiError.create(httpStatus, throwable.getMessage());
    return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
  }

  private void log(final Throwable throwable) {
    String errorMessage = throwable.getMessage();
    logger.error(errorMessage, throwable);
  }

  @Getter
  @AllArgsConstructor
  public static class HttpApiError {

    private HttpStatus status;

    @JsonInclude(Include.NON_EMPTY)
    private String message;

    static HttpApiError create(final HttpStatus status, final String message) {
      return new HttpApiError(status, message);
    }
  }
}
