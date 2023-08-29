package com.avensys.rts.geo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Pranay.Patadiya
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.avensys.rts.geo.*"})
public class GeoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoServiceApplication.class, args);
	}

}
