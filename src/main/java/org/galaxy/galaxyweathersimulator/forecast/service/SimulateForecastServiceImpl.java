package org.galaxy.galaxyweathersimulator.forecast.service;

import java.util.List;
import org.apache.commons.lang3.Validate;
import org.galaxy.galaxyweathersimulator.forecast.domain.Forecast;
import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;
import org.galaxy.galaxyweathersimulator.weather.service.UndefinedWeatherResolver;
import org.galaxy.galaxyweathersimulator.weather.service.WeatherResolver;

public class SimulateForecastServiceImpl implements SimulateForecastService {

  private SolarSystem solarSystem;

  private List<WeatherResolver> weatherResolvers;

  private UndefinedWeatherResolver undefinedWeatherResolver;

  public SimulateForecastServiceImpl(SolarSystem solarSystem,
      List<WeatherResolver> weatherResolvers) {
    this.solarSystem = solarSystem;
    this.weatherResolvers = weatherResolvers;
    this.undefinedWeatherResolver = new UndefinedWeatherResolver();
  }

  @Override
  public Forecast simulate(int day) {
    Validate.isTrue(day > 1, "The day must be greater than 1");
    Forecast forecast = new Forecast();
    for (int i = 1; i < day; i++) {
      Weather weatherForDay = getWeatherForDay(i);
      forecast.addWeatherForDay(i, weatherForDay);
    }
    return forecast;
  }

  private Weather getWeatherForDay(int day) {
    solarSystem.simulatePlanetsPositionForDay(day);
    return weatherResolvers.stream().filter(
        weatherResolver -> weatherResolver.canResolve(solarSystem)
    ).findFirst().orElse(undefinedWeatherResolver).resolve(solarSystem);
  }
}
