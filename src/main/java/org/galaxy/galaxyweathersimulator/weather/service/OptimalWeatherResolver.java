package org.galaxy.galaxyweathersimulator.weather.service;

import java.awt.geom.Point2D;
import org.apache.commons.lang3.Validate;
import org.galaxy.galaxyweathersimulator.planet.domain.Planet;
import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;
import org.galaxy.galaxyweathersimulator.weather.domain.WeatherFactory;

/**
 * Resolves the Galaxy's solar system weather
 * when it's in {@link org.galaxy.galaxyweathersimulator.weather.domain.WeatherType#OPTIMAL} day.
 */
public class OptimalWeatherResolver implements WeatherResolver {

  /**
   * The given {@link SolarSystem} will be in {@link org.galaxy.galaxyweathersimulator.weather.domain.WeatherType#OPTIMAL}
   * weather condition if its 3 planets are <a href="http://mathworld.wolfram.com/Collinear.html">collinear</a> with
   * each other, but not its center.
   *
   * @param solarSystem The solar system to the determine if it's in optimal weather condition. It cannot be null.
   * @return <b>true</b> if the weather of the solar system is in optimal weather condition, i.e., the slopes of the
   * planet pairs are equal between them but not with the sollary system center; otherwise, returns <b>false</b>.
   */
  @Override
  public boolean canResolve(SolarSystem solarSystem) {
    Validate.notNull(solarSystem, "The solar system cannot be null.");
    Point2D center = solarSystem.getCenter();
    Planet betasoide = solarSystem.getBetasoide();
    Planet ferengi = solarSystem.getFerengi();
    Planet vulcano = solarSystem.getVulcano();
    return arePlanetsNotAllinedWithCenter(center, betasoide, ferengi, vulcano);

  }

  private boolean arePlanetsNotAllinedWithCenter(Point2D center, Planet betasoide, Planet ferengi, Planet vulcano) {
    double slopeCenterAndBetasoide = MathCalculationUtils.getLineSlope(center, betasoide.getPosition());
    double slopeBetasoideAndFerengi = MathCalculationUtils.getLineSlope(betasoide.getPosition(), ferengi.getPosition());
    double slopeFerengiAndVulcano = MathCalculationUtils.getLineSlope(ferengi.getPosition(), vulcano.getPosition());
    return (slopeCenterAndBetasoide != slopeBetasoideAndFerengi)
        && (slopeBetasoideAndFerengi == slopeFerengiAndVulcano)
        && (slopeCenterAndBetasoide == slopeFerengiAndVulcano);
  }

  /**
   * Resolves the galaxy's solar system weather by returning a weather of the type optimal.
   *
   * @param solarSystem The solar system for the weather to be resolved. It cannot be null.
   * @return the galaxy's solar system weather of the type optimal. It's never null.
   */
  @Override
  public Weather resolve(SolarSystem solarSystem) {
    Validate.notNull(solarSystem, "The solar system cannot be null.");
    return WeatherFactory.createOptimaltWeather(solarSystem.getDay());
  }
}
