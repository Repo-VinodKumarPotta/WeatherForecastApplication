package com.weatherforecast.model.response.helper;

import lombok.*;

/**
 * @author Vinod Kumar Potta
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherForecastStatus {
    private String category;
    private String detailedDescription;
}
