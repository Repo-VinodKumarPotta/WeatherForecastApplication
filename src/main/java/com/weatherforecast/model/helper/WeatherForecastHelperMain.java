
package com.weatherforecast.model.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherForecastHelperMain {

    @JsonProperty("cod")
    private String cod;
    @JsonProperty("message")
    private Integer message;
    @JsonProperty("cnt")
    private Integer cnt;
    @JsonProperty("list")
    private java.util.List<List> list = new ArrayList<>();
    @JsonProperty("city")
    private City city;

}
