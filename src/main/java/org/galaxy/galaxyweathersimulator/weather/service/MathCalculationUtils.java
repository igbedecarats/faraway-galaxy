package org.galaxy.galaxyweathersimulator.weather.service;

import java.awt.geom.Point2D;
import org.apache.commons.lang3.Validate;

class MathCalculationUtils {

  static double getSlope(final Point2D point1, final Point2D point2) {
    Validate.notNull(point1, "The point1 cannot be null.");
    Validate.notNull(point2, "The point2 cannot be null.");
    return (point1.getY() - point2.getY()) / (point1.getX() - point2.getX());
  }

  static double triangleArea(final Point2D point1, final Point2D point2, final Point2D point3) {
    Validate.notNull(point1, "The point1 cannot be null.");
    Validate.notNull(point2, "The point2 cannot be null.");
    Validate.notNull(point3, "The point3 cannot be null.");
    return Math.abs(
        (point1.getX() * (point2.getY() - point3.getY())
            + point2.getX() * (point3.getY() - point1.getY())
            + point3.getX() * (point1.getY() - point2.getY())
        ) / 2.0d
    );
  }

  static double trianglePerimeter(final Point2D point1, final Point2D point2, final Point2D point3) {
    Validate.notNull(point1, "The point1 cannot be null.");
    Validate.notNull(point2, "The point2 cannot be null.");
    Validate.notNull(point3, "The point3 cannot be null.");
    return point1.distance(point2) + point2.distance(point3) + point3.distance(point1);
  }
}
