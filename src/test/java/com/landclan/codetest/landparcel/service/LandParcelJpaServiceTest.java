package com.landclan.codetest.landparcel.service;

import com.landclan.codetest.DomainConverter;
import com.landclan.codetest.landparcel.LandParcelTestHelper;
import com.landclan.codetest.landparcel.domain.LandParcel;
import com.landclan.codetest.landparcel.domain.LandParcelDto;
import com.landclan.codetest.landparcel.persistence.LandParcelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LandParcelJpaServiceTest {
    @InjectMocks private LandParcelJpaService landParcelInMemoryService;

    @Mock private LandParcelRepository landParcelRepository;

    @Mock private DomainConverter<LandParcelDto, LandParcel> landParcelMapper;

    private final LandParcel landParcel = LandParcelTestHelper.createLandParcel();

    private final LandParcelDto landParcelDto = LandParcelTestHelper.createLandParcelDto();

    @Test
    void shouldGetAllLandParcels() {
        when(landParcelRepository.findAll()).thenReturn(Collections.singletonList(landParcel));
        when(landParcelMapper.convertFromTargetToSource(Collections.singletonList(landParcel))).thenReturn(Collections.singletonList(landParcelDto));

        final List<LandParcelDto> landParcelDtos = landParcelInMemoryService.getAllLandParcels();

        assertThat(landParcelDtos).hasSize(1);
        assertThat(landParcelDtos.contains(landParcelDto)).isTrue();
    }

    @Test
    void shouldGetByReferenceId() {
        when(landParcelRepository.getReferenceById(landParcelDto.getObjectId())).thenReturn(landParcel);
        when(landParcelMapper.convertFromTargetToSource(landParcel)).thenReturn(landParcelDto);

        final LandParcelDto actualLandPassDto = landParcelInMemoryService.getLandParcel(landParcelDto.getObjectId());

        assertThat(actualLandPassDto).isEqualTo(landParcelDto);
    }

    @Test
    void shouldCreateNewParcelAndReturnCorrectDto() {
        when(landParcelMapper.convertFromSourceToTarget(landParcelDto)).thenReturn(landParcel);
        when(landParcelRepository.save(landParcel)).thenReturn(landParcel);
        when(landParcelMapper.convertFromTargetToSource(landParcel)).thenReturn(landParcelDto);

        final LandParcelDto actualLandParcel = landParcelInMemoryService.createNewLandParcel(landParcelDto);

        assertThat(actualLandParcel).isEqualTo(landParcelDto);
    }

    @Test
    void shouldUpdateExistingParcelAndReturnCorrectDto() {
        when(landParcelRepository.getReferenceById(landParcelDto.getObjectId())).thenReturn(landParcel);
        when(landParcelRepository.save(landParcel)).thenReturn(landParcel);
        when(landParcelMapper.convertFromTargetToSource(landParcel)).thenReturn(landParcelDto);

        final LandParcelDto savedLandParcelDto = landParcelInMemoryService.updateNewLandParcel(landParcelDto);

        assertThat(savedLandParcelDto).isEqualTo(landParcelDto);
    }

    @Test
    void shouldNotCallUpdateMethodIfEntityDoesNotExist() {
        when(landParcelRepository.getReferenceById(landParcelDto.getObjectId())).thenThrow(new EntityNotFoundException("test"));

        assertThrows(EntityNotFoundException.class, () ->
            landParcelInMemoryService.updateNewLandParcel(landParcelDto)
        );

        verify(landParcelRepository, never()).save(any());
    }


    @Test
    void shouldDeleteExistingParcelIfExists() {
        when(landParcelRepository.getReferenceById(landParcelDto.getObjectId())).thenReturn(landParcel);
        when(landParcelMapper.convertFromTargetToSource(landParcel)).thenReturn(landParcelDto);

        final LandParcelDto savedLandParcelDto = landParcelInMemoryService.deleteLandParcel(landParcelDto.getObjectId());

        assertThat(savedLandParcelDto).isEqualTo(landParcelDto);
    }
}
