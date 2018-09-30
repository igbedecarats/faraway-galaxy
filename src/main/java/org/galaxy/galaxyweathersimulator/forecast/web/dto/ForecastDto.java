package org.galaxy.galaxyweathersimulator.forecast.web.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.galaxy.galaxyweathersimulator.forecast.domain.Forecast;
import org.galaxy.galaxyweathersimulator.weather.web.dto.WeatherDto;

@NoArgsConstructor
@Getter
public class ForecastDto {

  private long numberOfSunnyDays;

  private long numberOfRainyDays;

  private long numberOfDroughtDays;

  private List<WeatherDto> mostRainyDays;

  public static ForecastDto toDto(Forecast forecast) {
    return null;
  }
}
