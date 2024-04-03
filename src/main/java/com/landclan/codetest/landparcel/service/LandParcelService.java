package com.landclan.codetest.landparcel.service;

import com.landclan.codetest.landparcel.domain.LandParcelDto;

import java.util.List;

public interface LandParcelService {

    List<LandParcelDto> getAllLandParcels();

    LandParcelDto getLandParcel(Long id);

    LandParcelDto createNewLandParcel(LandParcelDto landParcelToCreate);

    LandParcelDto updateNewLandParcel(LandParcelDto landParcelToUpdate);

    LandParcelDto deleteLandParcel(Long id);
}
