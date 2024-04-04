package com.landclan.codetest.landparcel;

import com.landclan.codetest.landparcel.domain.LandParcel;
import com.landclan.codetest.landparcel.domain.LandParcelDto;
import com.landclan.codetest.landparcel.exception.ErrorExceptionMessage;
import com.landclan.codetest.landparcel.service.LandParcelService;
import jakarta.annotation.Nonnull;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
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

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorExceptionMessage> handleEntityNotFoundResponse(EntityNotFoundException entityNotFoundException) {
        final ErrorExceptionMessage errorExceptionMessage = new ErrorExceptionMessage("Requested land parcel was not found", entityNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorExceptionMessage);
    }

    @ExceptionHandler({IllegalArgumentException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorExceptionMessage> handleIllegalArgumentException(Exception exception) {
        final ErrorExceptionMessage errorExceptionMessage = new ErrorExceptionMessage("Can't make a request with invalid or null arguments", exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorExceptionMessage);
    }

    @PostMapping()
    public ResponseEntity<LandParcelDto> createLandParcel(@Validated @RequestBody LandParcelDto landParcelDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(landParcelService.createNewLandParcel(landParcelDto));
    }

    @GetMapping()
    public ResponseEntity<List<LandParcelDto>> getAllLandParcels() {
        return ResponseEntity.ok(landParcelService.getAllLandParcels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LandParcelDto> getLandParcel(@PathVariable Long id) {
        return ResponseEntity.ok(landParcelService.getLandParcel(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LandParcelDto> updateExistingLandParcel(@Validated @RequestBody LandParcelDto landParcelDto) {
        return ResponseEntity.ok(landParcelService.updateNewLandParcel(landParcelDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LandParcelDto> deleteLandParcel(@PathVariable @Nonnull @Validated Long id) {
        return ResponseEntity.ok(landParcelService.deleteLandParcel(id));
    }

}
