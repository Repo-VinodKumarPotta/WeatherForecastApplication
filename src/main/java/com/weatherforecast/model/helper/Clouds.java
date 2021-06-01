
package com.weatherforecast.model.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Clouds {

    @JsonProperty("all")
    private Integer all;

}
