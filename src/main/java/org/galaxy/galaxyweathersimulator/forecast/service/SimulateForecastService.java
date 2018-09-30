package org.galaxy.galaxyweathersimulator.forecast.service;

import org.galaxy.galaxyweathersimulator.forecast.domain.Forecast;

/**
 * Forecast Simulator for the galaxy's solar system.
 */
public interface SimulateForecastService {

  /**
   * Simulates the forecast of the galaxy's solar system up to the given day.
   * @param day The day up until the forecast will be simulated. It must be positive.
   * @return The forecast of the galaxy's solar system up to the given day. It's never null.
   */
  Forecast simulate(final int day);

}
