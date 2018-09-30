package org.galaxy.galaxyweathersimulator.weather.service;

import java.util.List;
import org.apache.commons.lang3.Validate;
import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;

public class FindWeatherServiceImpl implements FindWeatherService {

  private SolarSystem solarSystem;

  private List<WeatherResolver> weatherResolvers;

  private UndefinedWeatherResolver undefinedWeatherResolver;

  public FindWeatherServiceImpl(final SolarSystem solarSystem, final List<WeatherResolver> weatherResolvers) {
    this.solarSystem = solarSystem;
    this.weatherResolvers = weatherResolvers;
    this.undefinedWeatherResolver = new UndefinedWeatherResolver();
  }

  @Override
  public Weather findWeather(int day) {
    Validate.isTrue(day > 1, "The day must be greater than 1");
    solarSystem.simulatePlanetsPositionForDay(day);
    return weatherResolvers.stream().filter(
        weatherResolver -> weatherResolver.canResolve(solarSystem)
    ).findFirst().orElse(undefinedWeatherResolver).resolve(solarSystem);
  }
}
