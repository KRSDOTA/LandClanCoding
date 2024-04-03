package com.landclan.codetest.landparcel;

import java.util.List;

public class LandParcelInMemoryService implements LandParcelService{
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
    public boolean deleteLandParcel(Long id) {
        return false;
    }
}
