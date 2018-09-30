package org.galaxy.galaxyweathersimulator.weather.service;

import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;
import org.galaxy.galaxyweathersimulator.weather.domain.WeatherFactory;

public class UndefinedWeatherResolver implements WeatherResolver {

  @Override
  public boolean canResolve(SolarSystem solarSystem) {
    return false;
  }

  @Override
  public Weather resolve(SolarSystem solarSystem) {
    return WeatherFactory.createUndefinedWeather(solarSystem.getDay());
  }
}
