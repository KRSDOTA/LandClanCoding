package com.landclan.codetest.landparcel.domain;

import com.landclan.codetest.DomainMapper;
import org.springframework.stereotype.Component;

/**
 * Separate out the landParcel business/entity from request entity
 */
@Component
public class LandParcelMapper implements DomainMapper<LandParcelDto, LandParcel> {

    @Override
    public LandParcelDto convertFromSourceToTarget(LandParcel source) {
        return LandParcelDto
                .builder()
                .landParcelStatus(source.getLandParcelStatus())
                .area(source.getArea())
                .constraints(source.getConstraints())
                .name(source.getName())
                .objectId(source.getObjectId())
                .build();
    }

    @Override
    public LandParcel convertFromTargetToSource(LandParcelDto target) {
        return LandParcel
                .builder()
                .landParcelStatus(target.getLandParcelStatus())
                .area(target.getArea())
                .constraints(target.getConstraints())
                .name(target.getName())
                .objectId(target.getObjectId())
                .build();
    }
}
