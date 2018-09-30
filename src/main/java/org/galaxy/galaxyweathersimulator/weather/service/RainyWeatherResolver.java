package org.galaxy.galaxyweathersimulator.weather.service;

import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;

public class RainyWeatherResolver implements WeatherResolver {

  @Override
  public boolean canResolve(SolarSystem solarSystem) {
    return false;
  }

  @Override
  public Weather resolve(SolarSystem solarSystem) {
    return null;
  }
}
