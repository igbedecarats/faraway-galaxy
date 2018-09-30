package org.galaxy.galaxyweathersimulator.weather.web;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.galaxy.galaxyweathersimulator.forecast.web.dto.ForecastDto;
import org.galaxy.galaxyweathersimulator.weather.service.FindWeatherService;
import org.galaxy.galaxyweathersimulator.weather.web.dto.WeatherDto;
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
@RequestMapping("/api/weather")
public class WeatherController {

  @Autowired
  private FindWeatherService service;

  @ApiOperation(
      value = "Finds the weather for the Solar System for a given day",
      notes = "If a specific weather cannot be found, then unknown weather will be returned")
  @ApiResponses({
      @ApiResponse(code = 200, message = "A weather could be returned", response = ForecastDto.class),
  })
  @GetMapping(value = "/{day}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<WeatherDto> doForecast(
      @ApiParam(value = "The day of the weather to be returned", allowableValues = "range[1,infinity]", required = true)
      @PathVariable("day") Integer day) {
    return ResponseEntity.ok(WeatherDto.toDto(service.findWeather(day)));
  }
}
