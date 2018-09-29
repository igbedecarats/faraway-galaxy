package org.galaxy.galaxyweathersimulator.planet.domain;

public class SolarSystemFactory {

  public static SolarSystem create() {
    return new SolarSystem(
        PlanetFactory.createFerengi(),
        PlanetFactory.createBetasoide(),
        PlanetFactory.createVulcano()
    );
  }
}
