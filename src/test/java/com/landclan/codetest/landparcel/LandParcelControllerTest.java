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
    public void shouldReturnCreatedHttpStatusCode() {
        when(landParcelService.createNewLandParcel(mockLandParcelDto)).thenReturn(mockLandParcelDto);

        ResponseEntity<LandParcelDto> actualLandParcelResponse = landParcelController.createLandParcel(mockLandParcelDto);

        assertThat(actualLandParcelResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(actualLandParcelResponse.getBody()).isEqualTo(mockLandParcelDto);
    }


    @Test
    public void shouldGetAllLandParcels() {
        landParcelController.getAllLandParcels();

        verify(landParcelService).getAllLandParcels();
    }


    @Test
    public void shouldGetLandParcelForValidId() {
        when(landParcelService.getLandParcel(mockLandParcelDto.getObjectId())).thenReturn(mockLandParcelDto);

        final ResponseEntity<LandParcelDto> actualLandParcelResponse = landParcelController.getLandParcel(mockLandParcelDto.getObjectId());

        assertThat(actualLandParcelResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualLandParcelResponse.getBody()).isEqualTo(mockLandParcelDto);
    }

    @Test
    public void shouldUpdateExistingLandParcel() {
        mockLandParcelDto.setName("some cool new name");

        when(landParcelService.updateNewLandParcel(mockLandParcelDto)).thenReturn(mockLandParcelDto);

        final ResponseEntity<LandParcelDto> actualLandParcelDto = landParcelController.updateExistingLandParcel(mockLandParcelDto);

        assertThat(actualLandParcelDto.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualLandParcelDto.getBody()).isEqualTo(mockLandParcelDto);
    }

    @Test
    public void shouldDeleteLandParcel() {
        when(landParcelService.deleteLandParcel(mockLandParcelDto.getObjectId())).thenReturn(mockLandParcelDto);

        final ResponseEntity<LandParcelDto> deletedLandParcelDto = landParcelController.deleteLandParcel(mockLandParcelDto.getObjectId());

        assertThat(deletedLandParcelDto.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(deletedLandParcelDto.getBody()).isEqualTo(mockLandParcelDto);
    }

}
