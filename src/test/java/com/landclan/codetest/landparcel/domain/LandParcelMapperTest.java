package com.landclan.codetest.landparcel.domain;

import com.landclan.codetest.landparcel.LandParcelTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class LandParcelMapperTest {

    @InjectMocks private LandParcelMapper landParcelMapper;

    private List<LandParcel> landParcels;

    private List<LandParcelDto> landParcelDtos;

    @BeforeEach
    void setUp() {
        landParcels = Collections.singletonList(
                LandParcelTestHelper.createLandParcel()
        );

        landParcelDtos = Collections.singletonList(
                LandParcelTestHelper.createLandParcelDto()
        );
    }

    @Test
    void shouldSuccessfullyMapLandParcelToDto() {
        final LandParcel inputLandParcel = landParcels.get(0);

        final LandParcelDto outputLandParcelDto = landParcelMapper.convertFromTargetToSource(inputLandParcel);

        assertLandParcelInputFieldsMapCorrectlyToOutput(inputLandParcel, outputLandParcelDto);
    }

    @Test
    void shouldSuccessfullyMapRequestDtoToDomain() {
        final LandParcelDto inputLandParcelDto = landParcelDtos.get(0);

        final LandParcel outputLandParcel = landParcelMapper.convertFromSourceToTarget(inputLandParcelDto);

        assertLandParcelInputDtoFieldsMapCorrectlyToOutput(inputLandParcelDto, outputLandParcel);
    }

    private void assertLandParcelInputFieldsMapCorrectlyToOutput(LandParcel inputLandParcel, LandParcelDto outputLandParcelDto) {
        assertThat(outputLandParcelDto.getName()).isEqualTo(inputLandParcel.getName());
        assertThat(outputLandParcelDto.getLandParcelStatus()).isEqualTo(inputLandParcel.getLandParcelStatus());
        assertThat(outputLandParcelDto.getObjectId()).isEqualTo(inputLandParcel.getObjectId());
        assertThat(outputLandParcelDto.getArea()).isEqualTo(inputLandParcel.getArea());
        assertThat(outputLandParcelDto.getConstraints()).isEqualTo(inputLandParcel.getConstraints());
    }

    private void assertLandParcelInputDtoFieldsMapCorrectlyToOutput(LandParcelDto inputLandParcelDto, LandParcel outputLandParcel) {
        assertThat(inputLandParcelDto.getName()).isEqualTo(outputLandParcel.getName());
        assertThat(inputLandParcelDto.getLandParcelStatus()).isEqualTo(outputLandParcel.getLandParcelStatus());
        assertThat(inputLandParcelDto.getObjectId()).isEqualTo(outputLandParcel.getObjectId());
        assertThat(inputLandParcelDto.getArea()).isEqualTo(outputLandParcel.getArea());
        assertThat(inputLandParcelDto.getConstraints()).isEqualTo(outputLandParcel.getConstraints());
    }
}
