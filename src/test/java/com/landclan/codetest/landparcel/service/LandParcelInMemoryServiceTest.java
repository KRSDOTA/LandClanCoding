package com.landclan.codetest.landparcel.service;

import com.landclan.codetest.DomainMapper;
import com.landclan.codetest.landparcel.LandParcelTestHelper;
import com.landclan.codetest.landparcel.domain.LandParcel;
import com.landclan.codetest.landparcel.domain.LandParcelDto;
import com.landclan.codetest.landparcel.persistence.LandParcelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LandParcelInMemoryServiceTest {
    @InjectMocks private LandParcelInMemoryService landParcelInMemoryService;

    @Mock private LandParcelRepository landParcelRepository;

    @Mock private DomainMapper<LandParcelDto, LandParcel> landParcelMapper;

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

    }


}
