package com.landclan.codetest.landparcel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class responsible for Declaring how spring application context (dependency container)
 * should standup LandParcelService.
 */
@Configuration
public class LandParcelServiceConfig {

    @Bean
    public LandParcelService createLandParcelServiceBean() {
        return new LandParcelInMemoryService();
    }

}
