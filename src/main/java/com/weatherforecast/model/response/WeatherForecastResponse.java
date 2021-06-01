package com.weatherforecast.model.response;

import com.weatherforecast.model.response.helper.WeatherForecastDetails;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vinod Kumar Potta
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherForecastResponse {

    private String country;
    private String city;
    private List<WeatherForecastDetails> weatherForecastDetails = new ArrayList<>();

}
