package com.landclan.codetest.landparcel.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class LandParcel {

    @Id
    @GeneratedValue
    private Long objectId;

    private String name;

    private LandParcelStatus landParcelStatus;

    private Double area;

    private Boolean constraints;

}
