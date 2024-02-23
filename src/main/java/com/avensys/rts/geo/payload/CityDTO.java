package com.avensys.rts.geo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * author: Pranay Patadiya
 */
@Setter
@Getter
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
