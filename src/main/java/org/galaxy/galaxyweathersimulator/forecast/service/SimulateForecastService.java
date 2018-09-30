package org.galaxy.galaxyweathersimulator.forecast.service;

import org.galaxy.galaxyweathersimulator.forecast.domain.Forecast;

public interface SimulateForecastService {

  Forecast simulate(final int day);

}
