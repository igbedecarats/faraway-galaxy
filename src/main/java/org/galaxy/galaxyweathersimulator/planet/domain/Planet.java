package org.galaxy.galaxyweathersimulator.planet.domain;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import lombok.Getter;
import org.apache.commons.lang3.Validate;
import org.apache.commons.math3.util.Precision;

/**
 * Planet for the solar system of the galaxy.
 */
@Getter
public class Planet {

  /**
   * The planet's name. It's never null nor blank.
   */
  private String name;

  /**
   * The planet's radius in kilometers. It's always positive.
   */
  private double radius;


  /**
   * The planet's angular velocity in degrees by day. It's always positive.
   */
  private int angularVelocity;


  /**
   * The planet's current position in the 2D space (it's calculated using polar coordinates with the planet's radius and
   * angular velocity). It's never null.
   */
  private Point2D position;

  /**
   * Makes a new instance of a planet with the given parameters.
   *
   * @param name The planet's name. It cannot be null nor blank.
   * @param radius The planet's radius in kilometers. It must be positive.
   * @param angularVelocity The planet's angular velocity in degrees by day. It must be positive.
   */
  Planet(String name, double radius, int angularVelocity) {
    Validate.notBlank(name, "The name cannot be blank.");
    Validate.isTrue(radius > 0, "The radius must be positive.");
    Validate.isTrue(angularVelocity != 0, "The angular velocity cannot be zero.");
    this.name = name;
    this.radius = radius;
    this.angularVelocity = angularVelocity;
    this.position = new Double(radius, 0.0);
  }

  /**
   * Simulates the planet's position in the 2D space for the given day using polar coordinates with the planet's radius
   * and angular velocity.
   *
   * @param day The day to simulate the planet's position, It must be positive.
   */
  void simulatetPositionForDay(final int day) {
    Validate.isTrue(day >= 0, "The day must be positive.");
    double angleInDegrees = (angularVelocity * day) % 360;
    if (angularVelocity < 0) {
      angleInDegrees = 360 + angleInDegrees;
    }
    double radianAngle = Math.toRadians(angleInDegrees);

    double x = Precision.round(Math.cos(radianAngle) * radius, 10);
    double y = Precision.round(Math.sin(radianAngle) * radius, 10);

    position = new Double(x, y);
  }
}
