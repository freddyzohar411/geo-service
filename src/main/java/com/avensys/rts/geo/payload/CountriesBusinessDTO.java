package com.avensys.rts.geo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * author: Pranay Patadiya This is the DTO class for the country information
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountriesBusinessDTO {

	private int id;

	private String name;

	private String iso3;

	private boolean business;

}
