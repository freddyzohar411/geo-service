package com.avensys.rts.geo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountriesCurrencyDTO {
	private int id;

	private String name;

	private String iso2;

	private String iso3;

	private String phoneCode;

	private String currency;

	private String currencySymbol;
}
