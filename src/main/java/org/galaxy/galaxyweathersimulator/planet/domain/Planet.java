package org.galaxy.galaxyweathersimulator.planet.domain;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.Validate;
import org.apache.commons.math3.util.Precision;

@Getter
@ToString(of = {"name", "radius", "angularVelocity", "position"})
public class Planet {

  private String name;
  private double radius;
  private int angularVelocity;
  private Point2D position;

  public Planet(String name, double radius, int angularVelocity) {
    Validate.notBlank(name, "The name cannot be blank.");
    Validate.isTrue(radius > 0, "The radius must be positive.");
    Validate.isTrue(angularVelocity != 0, "The angular velocity cannot be zero.");
    this.name = name;
    this.radius = radius;
    this.angularVelocity = angularVelocity;
    this.position = new Double(radius, 0.0);
  }

  public void simulatetPositionForDay(final int day) {
    Validate.isTrue(day > 0, "The day must be positive");
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
