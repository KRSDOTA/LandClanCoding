package com.landclan.codetest.landparcel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LandParcelControllerTest {

    @InjectMocks private LandParcelController landParcelController;

    @Mock private LandParcelService landParcelService;

    private final LandParcelDto mockLandParcelDto = LandParcelDto
            .builder()
            .objectId(1L)
            .landParcelStatus(LandParcelStatus.UNDER_CONSIDERATION)
            .area(1000d)
            .constraints(true)
            .name("Very cool parcel")
            .build();

    @Test
    public void shouldDelegateToLandParcelServiceToCreateDto() {
        landParcelController.createLandParcel(mockLandParcelDto);

        verify(landParcelService).createNewLandParcel(mockLandParcelDto);
    }

    @Test
    public void shouldGetAllLandParcels() {
        landParcelController.getAllLandParcels();

        verify(landParcelController).getAllLandParcels();
    }


    @Test
    public void shouldGetLandParcelForValidId() {
        final Long landParcelId = 1L;
        when(landParcelService.getLandParcel(landParcelId)).thenReturn(mockLandParcelDto);

        final ResponseEntity<LandParcelDto> actualLandParcelDto = landParcelController.getLandParcel(landParcelId);

        assertThat(actualLandParcelDto.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualLandParcelDto.getBody()).isEqualTo(mockLandParcelDto);
    }

    @Test
    public void shouldUpdateExistingLandParcel() {

    }

    @Test
    public void shouldDeleteLandParcel() {

    }

}
