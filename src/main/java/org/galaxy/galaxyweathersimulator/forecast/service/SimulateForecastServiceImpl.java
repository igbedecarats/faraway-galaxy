package org.galaxy.galaxyweathersimulator.forecast.service;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.galaxy.galaxyweathersimulator.forecast.domain.Forecast;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;
import org.galaxy.galaxyweathersimulator.weather.service.FindWeatherService;

@AllArgsConstructor
public class SimulateForecastServiceImpl implements SimulateForecastService {

  private FindWeatherService findWeatherService;

  @Override
  public Forecast simulate(int day) {
    Validate.isTrue(day >= 0, "The day must be positive.");
    Forecast forecast = new Forecast();
    for (int i = 1; i <= day; i++) {
      Weather weatherForDay = findWeatherService.findWeather(i);
      forecast.addWeatherForDay(i, weatherForDay);
    }
    return forecast;
  }
}
