package com.landclan.codetest.landparcel;

import com.landclan.codetest.landparcel.domain.LandParcelDto;
import com.landclan.codetest.landparcel.service.LandParcelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Entry point from upstream client request, called by servlet architecture (container) to handle incoming requests
 */
@AllArgsConstructor
@RequestMapping("/land-parcel")
@RestController
public class LandParcelController {

    private final LandParcelService landParcelService;

    @PostMapping("/create")
    public ResponseEntity<LandParcelDto> createLandParcel(@RequestBody LandParcelDto landParcelDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(landParcelService.createNewLandParcel(landParcelDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<LandParcelDto>> getAllLandParcels() {
        return ResponseEntity.ok(landParcelService.getAllLandParcels());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<LandParcelDto> getLandParcel(@PathVariable Long id) {
        return ResponseEntity.ok(landParcelService.getLandParcel(id));
    }

    @PutMapping("/update")
    public ResponseEntity<LandParcelDto> updateExistingLandParcel(@RequestBody LandParcelDto landParcelDto) {
        return ResponseEntity.ok(landParcelService.updateNewLandParcel(landParcelDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<LandParcelDto> deleteLandParcel(@PathVariable Long id) {
        return ResponseEntity.ok(landParcelService.deleteLandParcel(id));
    }

}
