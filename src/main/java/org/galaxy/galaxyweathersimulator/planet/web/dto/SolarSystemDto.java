package org.galaxy.galaxyweathersimulator.planet.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.galaxy.galaxyweathersimulator.planet.domain.SolarSystem;

@Getter
@AllArgsConstructor
public class SolarSystemDto {

  private PlanetDto ferengi;
  private PlanetDto betasoide;
  private PlanetDto vulcano;

  public static SolarSystemDto toDto(final SolarSystem solarSystem) {
    return new SolarSystemDto(
        PlanetDto.toDto(solarSystem.getFerengi()),
        PlanetDto.toDto(solarSystem.getBetasoide()),
        PlanetDto.toDto(solarSystem.getVulcano())
    );
  }

}
