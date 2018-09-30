package org.galaxy.galaxyweathersimulator.forecast.web;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.galaxy.galaxyweathersimulator.forecast.service.SimulateForecastService;
import org.galaxy.galaxyweathersimulator.forecast.web.dto.ForecastDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/forecast")
public class ForecastController {

  @Autowired
  private SimulateForecastService service;

  @ApiOperation(
      value = "Calculates the forecast for the planet of the solar system up to a given day",
      notes = "The forecast calculation includes: number of drought days, number of rainy days, "
          + "day with maximum amount of rain and days with optimum weather conditions")
  @ApiResponses({
      @ApiResponse(code = 200, message = "The forecast was calculated successfully", response = ForecastDto.class),
  })
  @GetMapping(value = "/forecast/{day}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ForecastDto> doForecast(
      @ApiParam(value = "Day up until when the forecast will be calculated", allowableValues = "range[1,infinity]", required = true)
      @PathVariable("day") Integer day) {
    return ResponseEntity.ok(ForecastDto.toDto(service.simulate(day)));
  }

}
