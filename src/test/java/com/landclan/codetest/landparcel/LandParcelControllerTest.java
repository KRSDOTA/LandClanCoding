package com.landclan.codetest.landparcel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LandParcelControllerTest {

    @InjectMocks private LandParcelController landParcelController;

    @Mock private LandParcelService landParcelService;

    @Test
    public void shouldCreateLandParcel() {
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
