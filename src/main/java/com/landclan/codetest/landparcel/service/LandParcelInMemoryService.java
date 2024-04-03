package com.landclan.codetest.landparcel.service;

import com.landclan.codetest.DomainMapper;
import com.landclan.codetest.landparcel.domain.LandParcel;
import com.landclan.codetest.landparcel.domain.LandParcelDto;
import com.landclan.codetest.landparcel.persistence.LandParcelRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class LandParcelInMemoryService implements LandParcelService {

    private LandParcelRepository landParcelRepository;

    private DomainMapper<LandParcelDto, LandParcel> landParcelMapper;

    @Override
    public List<LandParcelDto> getAllLandParcels() {
        return landParcelMapper.convertFromTargetToSource(landParcelRepository.findAll());
    }

    @Override
    public LandParcelDto getLandParcel(Long id) {
        return landParcelMapper.convertFromTargetToSource(landParcelRepository.getReferenceById(id));
    }

    @Override
    public LandParcelDto createNewLandParcel(LandParcelDto landParcelToCreate) {
        final LandParcel landParcelToSave = landParcelMapper.convertFromSourceToTarget(landParcelToCreate);
        return landParcelMapper.convertFromTargetToSource(landParcelRepository.save(landParcelToSave));
    }

    @Override
    public LandParcelDto updateNewLandParcel(LandParcelDto landParcelToUpdate) {
        final LandParcel landParcelUpdateToSave = landParcelMapper.convertFromSourceToTarget(landParcelToUpdate);
        return landParcelMapper.convertFromTargetToSource(landParcelRepository.save(landParcelUpdateToSave));
    }

    @Override
    public LandParcelDto deleteLandParcel(Long id) {
        final LandParcel landParcelToDelete = landParcelRepository.getReferenceById(id);
        landParcelRepository.delete(landParcelToDelete);
        return landParcelMapper.convertFromTargetToSource(landParcelToDelete);
    }
}
