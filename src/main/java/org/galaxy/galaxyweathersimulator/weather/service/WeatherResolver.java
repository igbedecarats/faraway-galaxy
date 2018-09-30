package org.galaxy.galaxyweathersimulator.weather.service;

import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;

public interface WeatherResolver {

  boolean canResolve(final SolarSystem solarSystem);

  Weather resolve(final SolarSystem solarSystem);

}
