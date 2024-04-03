package com.landclan.codetest.landparcel;

import com.landclan.codetest.landparcel.domain.LandParcel;
import com.landclan.codetest.landparcel.domain.LandParcelDto;
import com.landclan.codetest.landparcel.domain.LandParcelStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Static class for creating test data
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LandParcelTestHelper {

    public static LandParcel createLandParcel() {
        final LandParcel landParcel = new LandParcel();
        landParcel.setObjectId(1L);
        landParcel.setLandParcelStatus(LandParcelStatus.UNDER_CONSIDERATION);
        landParcel.setArea(1000d);
        landParcel.setConstraints(true);
        landParcel.setName("Very cool parcel");
        return landParcel;
    }

    public static LandParcelDto createLandParcelDto() {
       return LandParcelDto
                .builder()
                .objectId(1L)
                .landParcelStatus(LandParcelStatus.UNDER_CONSIDERATION)
                .area(1000d)
                .constraints(true)
                .name("Very cool parcel")
                .build();
    }

}
