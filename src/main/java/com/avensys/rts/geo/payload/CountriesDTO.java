package com.avensys.rts.geo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: Pranay Patadiya This is the DTO class for the country information
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountriesDTO {

	private int id;

	private String name;

	private String iso3;

	private String phonecode;

}
