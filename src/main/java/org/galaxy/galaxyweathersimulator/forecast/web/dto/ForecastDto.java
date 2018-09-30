package org.galaxy.galaxyweathersimulator.forecast.web.dto;

import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.galaxy.galaxyweathersimulator.forecast.domain.Forecast;
import org.galaxy.galaxyweathersimulator.weather.web.dto.WeatherDto;

@Getter
@AllArgsConstructor
public class ForecastDto {

  private long numberOfOptimalDays;

  private long numberOfRainyDays;

  private long numberOfDroughtDays;

  private List<WeatherDto> mostRainyDays;

  public static ForecastDto toDto(Forecast forecast) {
    return new ForecastDto(
        forecast.numberOfOptimalDays(),
        forecast.numberOfRainyDays(),
        forecast.numberDroughtDays(),
        Collections.emptyList()
    );
  }
}


