package com.landclan.codetest.landparcel.domain;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LandParcelDto {

    private Long objectId;

    private String name;

    @Enumerated(EnumType.STRING)
    private LandParcelStatus landParcelStatus;

    private Double area;

    private Boolean constraints;

}
