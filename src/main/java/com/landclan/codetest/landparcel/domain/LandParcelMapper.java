package com.landclan.codetest.landparcel.domain;

import com.landclan.codetest.DomainMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Separate out the landParcel business/entity from transport form of LandParcel entity,
 * any custom logic for mapping between transport and domain objects go here
 *
 */
@Component
public class LandParcelMapper implements DomainMapper<LandParcelDto, LandParcel> {

    public LandParcel convertFromSourceToTarget(LandParcelDto source) {
        final LandParcel landParcel = new LandParcel();
        landParcel.setLandParcelStatus(source.getLandParcelStatus());
        landParcel.setArea(source.getArea());
        landParcel.setConstraints(source.getConstraints());
        landParcel.setName(source.getName());
        landParcel.setObjectId(source.getObjectId());
        return landParcel;
    }

    public List<LandParcel> convertFromSourceToTarget(List<LandParcelDto> sources) {
        return sources
                .stream()
                .map(this::convertFromSourceToTarget)
                .toList();
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
