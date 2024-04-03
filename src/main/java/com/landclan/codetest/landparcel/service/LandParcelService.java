package com.landclan.codetest.landparcel.service;

import com.landclan.codetest.landparcel.domain.LandParcelDto;

import java.util.List;

/**
 * CRUD abstraction for clients to depend on for LandParcel operations
 */
public interface LandParcelService {

    List<LandParcelDto> getAllLandParcels();

    LandParcelDto getLandParcel(Long id);

    LandParcelDto createNewLandParcel(LandParcelDto landParcelToCreate);

    LandParcelDto updateNewLandParcel(LandParcelDto landParcelToUpdate);

    LandParcelDto deleteLandParcel(Long id);
}
