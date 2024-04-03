package com.landclan.codetest.landparcel.domain;

import com.landclan.codetest.DomainConverter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Separate out the landParcel business/entity from transport form of LandParcel entity,
 * any custom logic for mapping between transport and domain objects go here!
 */
@Component
public class LandParcelMapper implements DomainConverter<LandParcelDto, LandParcel> {

    public void convertFromSourceToTarget(LandParcelDto source, LandParcel target) {
        target.setArea(source.getArea());
        target.setName(source.getName());
        target.setConstraints(source.getConstraints());
        target.setLandParcelStatus(source.getLandParcelStatus());
        target.setLandParcelStatus(source.getLandParcelStatus());
    }

    public LandParcel convertFromSourceToTarget(LandParcelDto source) {
        final LandParcel landParcel = new LandParcel();
        landParcel.setLandParcelStatus(source.getLandParcelStatus());
        landParcel.setArea(source.getArea());
        landParcel.setConstraints(source.getConstraints());
        landParcel.setName(source.getName());
        landParcel.setObjectId(source.getObjectId());
        return landParcel;
    }

    public LandParcelDto convertFromTargetToSource(LandParcel target) {
        return LandParcelDto
                .builder()
                .landParcelStatus(target.getLandParcelStatus())
                .area(target.getArea())
                .constraints(target.getConstraints())
                .name(target.getName())
                .objectId(target.getObjectId())
                .build();
    }

    public List<LandParcelDto> convertFromTargetToSource(List<LandParcel> sources) {

        return sources
                .stream()
                .map(this::convertFromTargetToSource)
                .toList();
    }
}
