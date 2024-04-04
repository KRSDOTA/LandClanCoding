package com.landclan.codetest.landparcel.domain;


import jakarta.annotation.Nonnull;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LandParcelDto {

    private Long objectId;

    @Nonnull
    private String name;

    @Nonnull
    @Enumerated(EnumType.STRING)
    private LandParcelStatus landParcelStatus;

    @Nonnull
    private Double area;

    @Nonnull
    private Boolean constraints;

}
