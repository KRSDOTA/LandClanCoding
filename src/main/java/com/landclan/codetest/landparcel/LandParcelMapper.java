package com.landclan.codetest.landparcel;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Separate out the landParcel business/entity from request entity
 */
@Component
public class LandParcelMapper implements Converter<LandParcelDto, LandParcel> {

    @Override
    public LandParcel convert(LandParcelDto requestObject) {
        return new LandParcel();
    }
}
