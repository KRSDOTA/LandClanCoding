package com.landclan.codetest.landparcel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LandParcelControllerTest {

    @InjectMocks private LandParcelController landParcelController;

    @Mock private LandParcelService landParcelService;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void shouldDelegateToLandParcelService() {
        final LandParcelDto landParcelDto = LandParcelDto
                .builder()
                .objectId(1L)
                .landParcelStatus(LandParcelStatus.UNDER_CONSIDERATION)
                .area(1000d)
                .constraints(true)
                .name("Very cool parcel")
                .build();

        landParcelController.createLandParcel(landParcelDto);

        verify(landParcelService).createNewLandParcel(landParcelDto);
    }

    @Test
    public void shouldGetAllLandParcels() {
    }


    @Test
    public void shouldGetAllLandParcelForValidId() {
    }

    @Test
    public void shouldUpdateExistingLandParcel() {

    }

    @Test
    public void shouldDeleteLandParcel() {

    }

}
