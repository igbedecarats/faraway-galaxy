package org.galaxy.galaxyweathersimulator.weather.service;

import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;
import org.galaxy.galaxyweathersimulator.weather.domain.WeatherFactory;

/**
 * Resolves the Galaxy's solar system weather
 * when it's in {@link org.galaxy.galaxyweathersimulator.weather.domain.WeatherType#UNDEFINED} day, i.e., it's weather
 * doesn't fit any of the conditions for the other weather type rules.
 */
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
