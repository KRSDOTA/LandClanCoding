package com.landclan.codetest.landparcel.persistence;

import com.landclan.codetest.landparcel.domain.LandParcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandParcelRepository extends JpaRepository<LandParcel, Long> {

}
