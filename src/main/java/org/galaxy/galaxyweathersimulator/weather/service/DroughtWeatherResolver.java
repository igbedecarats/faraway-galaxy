package org.galaxy.galaxyweathersimulator.weather.service;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import org.apache.commons.lang3.Validate;
import org.galaxy.galaxyweathersimulator.planet.domain.Planet;
import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;
import org.galaxy.galaxyweathersimulator.weather.domain.WeatherFactory;

public class DroughtWeatherResolver implements WeatherResolver {

  /**
   * The given {@link SolarSystem} will be in {@link org.galaxy.galaxyweathersimulator.weather.domain.WeatherType#DROUGHT}
   * if the slopes of the planet pairs are equal and are also equal to the slope of any of those planets with center of
   * the Solar System.
   * <br>
   * <a href="http://mathworld.wolfram.com/Collinear.html">Logic for collinear points in a line</a>
   *
   * @param solarSystem The solar system to the determine if it's in drought weather. It cannot be null.
   * @return <b>true</b> if the weather of the solar system is drought, i.e., the combination of the slopes of every
   * planet pair with center are equal; otherwise, returns false.
   */
  @Override
  public boolean canResolve(SolarSystem solarSystem) {
    Validate.notNull(solarSystem, "The solar system cannot be null.");
    Point2D center = new Double(0.0d, 0.0d);
    Planet betasoide = solarSystem.getBetasoide();
    Planet ferengi = solarSystem.getFerengi();
    Planet vulcano = solarSystem.getVulcano();
    double slope1 =
        (betasoide.getPosition().getY() - center.getY())
            / (betasoide.getPosition().getX() - center.getX());
    double slope2 =
        (betasoide.getPosition().getY() - ferengi.getPosition().getY())
            / (betasoide.getPosition().getX() - ferengi.getPosition().getX());
    double slope3 =
        (ferengi.getPosition().getY() - vulcano.getPosition().getY())
            / (ferengi.getPosition().getX() - vulcano.getPosition().getX());
    return slope1 == slope2 && slope2 == slope3 && slope1 == slope3;
  }

  @Override
  public Weather resolve(SolarSystem solarSystem) {
    return WeatherFactory.createDroughtWeather(solarSystem.getDay());
  }
}
