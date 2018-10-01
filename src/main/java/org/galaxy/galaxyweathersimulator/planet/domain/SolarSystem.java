package org.galaxy.galaxyweathersimulator.planet.domain;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import lombok.Getter;
import org.apache.commons.lang3.Validate;

/**
 * Solar system containing the planets for simulating the weather and forecast.
 */
@Getter
public class SolarSystem {

  /**
   * The solar system current day. It's always greater than zero.
   */
  private int day;

  /**
   * The Ferengi's planet. It's never null.
   */
  private Planet ferengi;


  /**
   * The Betasoide's planet. It's never null.
   */
  private Planet betasoide;


  /**
   * The Vulcano's planet. It's never null.
   */
  private Planet vulcano;

  /**
   * The solar system's center, a.k.a, its sun. It's never null.
   */
  private Point2D center;

  /**
   * Makes a new instance of the solar system with the given planets, setting its current day in 0 and its center in
   * (0,0).
   *
   * @param ferengi The Ferengi's planet. It's cannot be null.
   * @param betasoide The Betasoide's planet. It's cannot be null.
   * @param vulcano The Vulcano's planet. It's cannot be null.
   */
  public SolarSystem(final Planet ferengi, final Planet betasoide, final Planet vulcano) {
    Validate.notNull(ferengi, "The planet Ferengi cannot be null");
    Validate.notNull(betasoide, "The planet Betasoide cannot be null");
    Validate.notNull(vulcano, "The planet Vulcano cannot be null");
    this.day = 0;
    this.center = new Double(0.0d, 0.0d);
    this.ferengi = ferengi;
    this.betasoide = betasoide;
    this.vulcano = vulcano;
  }

  /**
   * Simulates the position of all of the solar system planets in the 2D space for the given day.
   *
   * @param day The day for planets position simulation. It must be positive.
   */
  public void simulatePlanetsPositionForDay(final int day) {
    Validate.isTrue(day >= 0, "The day must be positive");
    this.day = day;
    ferengi.simulatetPositionForDay(day);
    betasoide.simulatetPositionForDay(day);
    vulcano.simulatetPositionForDay(day);
  }
}
