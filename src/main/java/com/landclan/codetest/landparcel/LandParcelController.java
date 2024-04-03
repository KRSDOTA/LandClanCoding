package com.landclan.codetest.landparcel;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Entry point for client applications.
 */
@AllArgsConstructor
@RequestMapping("/land-parcel")
@RestController
public class LandParcelController {

    private final LandParcelService landParcelService;

    @PostMapping("/create")
    public ResponseEntity<LandParcelDto> createLandParcel(@RequestBody LandParcelDto landParcelDto) {
        return ResponseEntity.ok(landParcelService.createNewLandParcel(landParcelDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<LandParcelDto>> getAllLandParcels() {
        return ResponseEntity.ok(landParcelService.getAllLandParcels());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<LandParcelDto> getAllLandParcel(@PathVariable Long id) {
        return ResponseEntity.ok(landParcelService.getLandParcel(id));
    }

    @PostMapping("/update")
    public ResponseEntity<LandParcelDto> updateExistingLandParcel(@RequestBody LandParcelDto landParcelDto) {
        return ResponseEntity.ok(landParcelService.updateNewLandParcel(landParcelDto));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteLandParcel(@PathVariable Long id) {
        return ResponseEntity.ok(landParcelService.deleteLandParcel(id));
    }

}
