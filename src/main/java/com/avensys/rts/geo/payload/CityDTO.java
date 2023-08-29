package com.avensys.rts.geo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: Pranay Patadiya
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {


	private int id;

	private String name;
	
	private Integer countryid;
	
	private Integer stateid;
	
	private String countrycode;
	
	private String statecode;
	
}
