package org.galaxy.galaxyweathersimulator.weather.service;

import org.galaxy.galaxyweathersimulator.weather.domain.Weather;

/**
 * Finds the {@link Weather} for a given day.
 */
public interface FindWeatherService {

  /**
   * Finds the {@link Weather} for the given day.
   *
   * @param day The day for weather. It must be positive.
   * @return The weather for the given day. It's never null.
   */
  Weather findWeather(final int day);

}
