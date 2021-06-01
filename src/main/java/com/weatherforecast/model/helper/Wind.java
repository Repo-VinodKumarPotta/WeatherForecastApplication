
package com.weatherforecast.model.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wind {

    @JsonProperty("speed")
    private Double speed;
    @JsonProperty("deg")
    private Integer deg;
    @JsonProperty("gust")
    private Double gust;

}
