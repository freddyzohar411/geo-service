package com.avensys.rts.geo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: Pranay Patadiya
 * This is the DTO class for the country information
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    
	private int id;
	
    private String name;

    private String nicename;
    
    private String iso;

    private String iso3;

    private int phonecode;
}
