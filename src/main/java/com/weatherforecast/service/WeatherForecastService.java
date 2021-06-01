package com.weatherforecast.service;

import com.weatherforecast.model.request.WeatherForecastRequest;
import com.weatherforecast.model.response.WeatherForecastResponse;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

/**
 * @author Vinod Kumar Potta
 */

public interface WeatherForecastService {

    ResponseEntity<WeatherForecastResponse> getWeatherForecastData(WeatherForecastRequest weatherForecastRequest) throws ParseException;
}
