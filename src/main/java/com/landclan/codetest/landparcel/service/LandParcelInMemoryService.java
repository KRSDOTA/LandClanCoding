package com.landclan.codetest.landparcel.service;

import com.landclan.codetest.landparcel.domain.LandParcelDto;
import com.landclan.codetest.landparcel.domain.LandParcelMapper;
import com.landclan.codetest.landparcel.persistence.LandParcelRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class LandParcelInMemoryService implements LandParcelService {

    private LandParcelRepository landParcelRepository;

    private LandParcelMapper landParcelMapper;

    @Override
    public List<LandParcelDto> getAllLandParcels() {
        return null;
    }

    @Override
    public LandParcelDto getLandParcel(Long id) {
        return null;
    }

    @Override
    public LandParcelDto createNewLandParcel(LandParcelDto landParcelToCreate) {
        return null;
    }

    @Override
    public LandParcelDto updateNewLandParcel(LandParcelDto landParcelToUpdate) {
        return null;
    }

    @Override
    public LandParcelDto deleteLandParcel(Long id) {
        return null;
    }
}
