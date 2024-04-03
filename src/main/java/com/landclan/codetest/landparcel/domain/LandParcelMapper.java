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

    public List<LandParcelDto> convertFromSourceToTarget(List<LandParcel> sources) {
        return sources
                .stream()
                .map(this::convertFromSourceToTarget)
                .toList();
    }

    public LandParcel convertFromTargetToSource(LandParcelDto target) {
        final LandParcel landParcel = new LandParcel();
                landParcel.setLandParcelStatus(target.getLandParcelStatus());
                landParcel.setArea(target.getArea());
                landParcel.setConstraints(target.getConstraints());
                landParcel.setName(target.getName());
                landParcel.setObjectId(target.getObjectId());
        return landParcel;
    }

    public List<LandParcel> convertFromTargetToSource(List<LandParcelDto> targets) {
        return targets
                .stream()
                .map(this::convertFromTargetToSource)
                .toList();
    }
}
