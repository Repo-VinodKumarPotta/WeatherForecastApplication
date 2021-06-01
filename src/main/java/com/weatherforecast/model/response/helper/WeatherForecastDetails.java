package com.weatherforecast.model.response.helper;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Vinod Kumar Potta
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherForecastDetails {

    private LocalDateTime date;
    private double temperature;
    private double feelsLike;
    private double temperatureMin;
    private double temperatureMax;
    private double humidity;
    private double windSpeed;
    private java.util.List<WeatherForecastStatus> weatherForecastStatuses = new ArrayList<>();

}
