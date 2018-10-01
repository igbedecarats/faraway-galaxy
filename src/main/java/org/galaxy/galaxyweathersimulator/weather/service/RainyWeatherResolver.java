package org.galaxy.galaxyweathersimulator.weather.service;

import java.awt.geom.Point2D;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.Validate;
import org.galaxy.galaxyweathersimulator.planet.domain.Planet;
import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;
import org.galaxy.galaxyweathersimulator.weather.domain.Weather;
import org.galaxy.galaxyweathersimulator.weather.domain.WeatherFactory;

/**
 * Resolves the Galaxy's solar system weather
 * when it's in {@link org.galaxy.galaxyweathersimulator.weather.domain.WeatherType#RAIN} day.
 */
public class RainyWeatherResolver implements WeatherResolver {

  /**
   * The given {@link SolarSystem} will be in {@link org.galaxy.galaxyweathersimulator.weather.domain.WeatherType#RAIN}
   * weather condition if its 3 planets form a triangle and the solar system center is inside it.
   *
   * To know if the center is inside the triangle, <a href="https://en.wikipedia.org/wiki/Barycentric_coordinate_system">Barycentric
   * Coordinates</a> are used.
   *
   * @param solarSystem The solar system to the determine if it's in rain weather condition. It cannot be null.
   * @return <b>true</b> if the weather of the solar system is in rain weather condition, i.e., ts 3 planets form a
   * triangle and the solar system center is inside it.; otherwise, returns <b>false</b>.
   */
  @Override
  public boolean canResolve(SolarSystem solarSystem) {
    Validate.notNull(solarSystem, "The solar system cannot be null.");
    Point2D center = solarSystem.getCenter();
    Planet betasoide = solarSystem.getBetasoide();
    Planet ferengi = solarSystem.getFerengi();
    Planet vulcano = solarSystem.getVulcano();
    if (!doPlanetsFormATriangle(betasoide, ferengi, vulcano)) {
      return false;
    }
    return isCenterInsidePlanetsTriangle(center, betasoide, ferengi, vulcano);
  }

  private boolean isCenterInsidePlanetsTriangle(Point2D center, Planet betasoide, Planet ferengi, Planet vulcano) {
    BarycentricCoordinate barycentricCoordinate = getBarycentricCoordinate(betasoide.getPosition(),
        ferengi.getPosition(), vulcano.getPosition(), center);
    return (0 <= barycentricCoordinate.getA() && barycentricCoordinate.getA() <= 1)
        && (0 <= barycentricCoordinate.getB() && barycentricCoordinate.getB() <= 1)
        && (0 <= barycentricCoordinate.getC() && barycentricCoordinate.getC() <= 1);
  }

  /**
   * Resolves the rainy weather for the solar system in its current day, calculating its precipitation as the perimeter
   * of the triangle formed by the solar system planets.
   * @param solarSystem The solar system to resolve the rainy weather. It cannot be null.
   * @return
   */
  @Override
  public Weather resolve(SolarSystem solarSystem) {
    Validate.notNull(solarSystem, "The solar system cannot be null.");
    Planet betasoide = solarSystem.getBetasoide();
    Planet ferengi = solarSystem.getFerengi();
    Planet vulcano = solarSystem.getVulcano();
    double precipitation = MathCalculationUtils
        .trianglePerimeter(betasoide.getPosition(), ferengi.getPosition(), vulcano.getPosition());
    return WeatherFactory.createRainyWeather(solarSystem.getDay(), precipitation);
  }

  private boolean doPlanetsFormATriangle(Planet betasoide, Planet ferengi, Planet vulcano) {
    return
        MathCalculationUtils.triangleArea(betasoide.getPosition(), ferengi.getPosition(), vulcano.getPosition()) != 0;
  }

  private BarycentricCoordinate getBarycentricCoordinate(final Point2D point1, final Point2D point2,
      final Point2D point3, final Point2D p) {
    double denominator = ((point2.getY() - point3.getY())
        * (point1.getX() - point3.getX())
        + (point3.getX() - point2.getX())
        * (point1.getY() - point3.getY()));

    double a = ((point2.getY() - point3.getY()) * (p.getX() - point3.getX())
        + (point3.getX() - point2.getX()) * (p.getY() - point3.getY()))
        / denominator;

    double b = ((point3.getY() - point1.getY()) * (p.getX() - point3.getX())
        + (point1.getX() - point3.getX()) * (p.getY() - point3.getY()))
        / denominator;

    double c = 1 - a - b;
    return new BarycentricCoordinate(a, b, c);
  }


  @AllArgsConstructor
  @Getter
  private class BarycentricCoordinate {

    double a, b, c;
  }

}
