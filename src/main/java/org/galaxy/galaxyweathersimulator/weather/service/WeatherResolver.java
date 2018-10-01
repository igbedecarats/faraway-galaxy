package org.galaxy.galaxyweathersimulator.weather.service;

import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;

/**
 * Resolves the weather for the galaxy's solar system in it current day applying the rule for the corresponding weather
 * type.
 */
public interface WeatherResolver {

  /**
   * Checks if it can resolve the weather for the galaxy's solar system in it current day applying the rule for the
   * corresponding weather type.
   *
   * @param solarSystem The solary system to be checked. It cannot be null.
   * @return <b><true</b> if it can resolve weather for galaxy's solar system in its current day; otherwise, it returns
   * <b>false</b>.
   */
  boolean canResolve(final SolarSystem solarSystem);

  /**
   * Resolves the weather of the galaxy's current day of the corresponding weather type.
   *
   * @param solarSystem The solar system whose weather must be resolved. It cannot be null.
   * @return The weather of the galaxy's current day of the corresponding weather type. It's never null.
   */
  Weather resolve(final SolarSystem solarSystem);

}
