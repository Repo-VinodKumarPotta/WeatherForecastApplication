
package com.weatherforecast.model.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class List {

    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("weather")
    private java.util.List<Weather> weather = new ArrayList<Weather>();
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("pop")
    private Integer pop;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("dt_txt")
    private String dtTxt;

}
