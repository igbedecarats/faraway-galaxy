package org.galaxy.galaxyweathersimulator.planet.web.dto;

import java.awt.geom.Point2D;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.galaxy.galaxyweathersimulator.planet.domain.Planet;

@Getter
@AllArgsConstructor
public class PlanetDto {

  private String name;

  private Point2D position;

  public static PlanetDto toDto(final Planet planet) {
    return new PlanetDto(planet.getName(), planet.getPosition());
  }
}
