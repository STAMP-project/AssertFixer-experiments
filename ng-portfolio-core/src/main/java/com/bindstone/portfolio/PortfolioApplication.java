package com.bindstone.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Application Root
 *
 * Keep it as small as possible. All configurations should be done in the
 * package config.
 */

@SpringBootApplication
public class PortfolioApplication {

    /**
     * Main methode to be executed.
     * @param args List of arguments started from command line.
     */
    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

}
