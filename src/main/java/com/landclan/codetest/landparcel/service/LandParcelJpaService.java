package com.landclan.codetest.landparcel.service;

import com.landclan.codetest.DomainConverter;
import com.landclan.codetest.landparcel.domain.LandParcel;
import com.landclan.codetest.landparcel.domain.LandParcelDto;
import com.landclan.codetest.landparcel.persistence.LandParcelRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class LandParcelJpaService implements LandParcelService {

    private LandParcelRepository landParcelRepository;

    private DomainConverter<LandParcelDto, LandParcel> landParcelMapper;

    public List<LandParcelDto> getAllLandParcels() {
        return landParcelMapper.convertFromTargetToSource(landParcelRepository.findAll());
    }

    public LandParcelDto getLandParcel(Long id) {
        return landParcelMapper.convertFromTargetToSource(landParcelRepository.getReferenceById(id));
    }

    public LandParcelDto createNewLandParcel(LandParcelDto landParcelToCreate) {
        final LandParcel landParcelToSave = landParcelMapper.convertFromSourceToTarget(landParcelToCreate);
        return landParcelMapper.convertFromTargetToSource(landParcelRepository.save(landParcelToSave));
    }

    public LandParcelDto updateNewLandParcel(LandParcelDto landParcelToUpdate) {
        final LandParcel landParcelUpdateToSave = landParcelRepository.getReferenceById(landParcelToUpdate.getObjectId());
        landParcelMapper.convertFromSourceToTarget(landParcelToUpdate, landParcelUpdateToSave);
        return landParcelMapper.convertFromTargetToSource(landParcelRepository.save(landParcelUpdateToSave));
    }

    public LandParcelDto deleteLandParcel(Long id) {
        final LandParcel landParcelToDelete = landParcelRepository.getReferenceById(id);
        landParcelRepository.delete(landParcelToDelete);
        return landParcelMapper.convertFromTargetToSource(landParcelToDelete);
    }
}
