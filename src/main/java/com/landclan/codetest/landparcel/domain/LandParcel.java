package com.landclan.codetest.landparcel.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class LandParcel {

    @Id
    @GeneratedValue
    private Long objectId;

    private String name;

    private LandParcelStatus landParcelStatus;

    private Double area;

    private Boolean constraints;

}
