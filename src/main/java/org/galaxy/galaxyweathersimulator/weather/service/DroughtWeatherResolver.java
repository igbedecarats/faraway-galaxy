package org.galaxy.galaxyweathersimulator.weather.service;

import java.awt.geom.Point2D;
import org.apache.commons.lang3.Validate;
import org.galaxy.galaxyweathersimulator.planet.domain.Planet;
import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;
import org.galaxy.galaxyweathersimulator.weather.domain.WeatherFactory;

/**
 * Resolves the Galaxy's solar system weather when it's in {@link org.galaxy.galaxyweathersimulator.weather.domain.WeatherType#DROUGHT}
 * day.
 */
public class DroughtWeatherResolver implements WeatherResolver {

  /**
   * The given {@link SolarSystem} will be in {@link org.galaxy.galaxyweathersimulator.weather.domain.WeatherType#DROUGHT}
   * weather condition if its 3 planets and its center are <a href="http://mathworld.wolfram.com/Collinear.html">collinear</a>.
   *
   * @param solarSystem The solar system to the determine if it's in drought weather condition. It cannot be null.
   * @return <b>true</b> if the weather of the solar system is drought weather condition, i.e., the slopes of the
   * planet pairs are equal and are also equal to the slope of any of those planets with center of * the Solar System;
   * otherwise, returns <b>false</b>.
   */
  @Override
  public boolean canResolve(SolarSystem solarSystem) {
    Validate.notNull(solarSystem, "The solar system cannot be null.");
    Point2D center = solarSystem.getCenter();
    Planet betasoide = solarSystem.getBetasoide();
    Planet ferengi = solarSystem.getFerengi();
    Planet vulcano = solarSystem.getVulcano();
    return arePlanetsAndCenterCollinear(center, betasoide, ferengi, vulcano);
  }

  private boolean arePlanetsAndCenterCollinear(Point2D center, Planet betasoide, Planet ferengi, Planet vulcano) {
    double slopeCenterAndBetasoide = MathCalculationUtils.getLineSlope(center, betasoide.getPosition());
    double slopeBetasoideAndFerengi = MathCalculationUtils.getLineSlope(betasoide.getPosition(), ferengi.getPosition());
    double slopeFerengiAndVulcano = MathCalculationUtils.getLineSlope(ferengi.getPosition(), vulcano.getPosition());
    return (slopeCenterAndBetasoide == slopeBetasoideAndFerengi)
        && (slopeBetasoideAndFerengi == slopeFerengiAndVulcano)
        && (slopeCenterAndBetasoide == slopeFerengiAndVulcano);
  }

  /**
   * Resolves the galaxy's solar system weather by returning a weather of the type drought.
   *
   * @param solarSystem The solar system for the weather to be resolved. It cannot be null.
   * @return the galaxy's solar system weather of the type drought. It's never null.
   */
  @Override
  public Weather resolve(SolarSystem solarSystem) {
    Validate.notNull(solarSystem, "The solar system cannot be null.");
    return WeatherFactory.createDroughtWeather(solarSystem.getDay());
  }
}
