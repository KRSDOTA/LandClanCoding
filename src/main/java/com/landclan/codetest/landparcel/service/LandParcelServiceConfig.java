package com.landclan.codetest.landparcel.service;

import com.landclan.codetest.landparcel.domain.LandParcelMapper;
import com.landclan.codetest.landparcel.persistence.LandParcelRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class responsible for Declaring how spring application context (dependency container)
 * should standup LandParcelService.
 */
@Configuration
public class LandParcelServiceConfig {

    @Bean
    public LandParcelService createLandParcelServiceBean(LandParcelRepository landParcelRepository,
                                                         LandParcelMapper landParcelMapper) {
        return new LandParcelInMemoryService(landParcelRepository, landParcelMapper);
    }

}
