package org.galaxy.galaxyweathersimulator.weather.service;

import org.galaxy.galaxyweathersimulator.weather.domain.Weather;

public interface FindWeatherService {

  Weather findWeather(final int day);

}
