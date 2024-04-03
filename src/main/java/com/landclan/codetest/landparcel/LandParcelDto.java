package com.landclan.codetest.landparcel;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LandParcelDto {

    private Long objectId;

    private String name;

    private LandParcelStatus landParcelStatus;

    private Double area;

    private Boolean constraints;

}
