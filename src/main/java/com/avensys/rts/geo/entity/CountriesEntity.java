package com.avensys.rts.geo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Pranay.Patadiya
 */

@Entity
@Table(name = "countries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountriesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", length = 80, nullable = false)
	private String name;

	@Column(name = "iso2", length = 2)
	private String iso2;

	@Column(name = "iso3", length = 3)
	private String iso3;
	
	@Column(name = "capital", length = 20)
	private String capital;

	@Column(name = "phone_code")
	private String phonecode;

	@Column(name = "numeric_code", nullable = true)
	private Integer numcode;

	@Column(name = "currency", length = 3)
	private String currency;

	@Column(name = "currency_name")
	private String currencyname;

	@Column(name = "currency_symbol", nullable = true)
	private String currencysymbol;

	@Column(name = "tld", nullable = true)
	private String tld;

	@Column(name = "native", nullable = true)
	private String nativestr;
	
	@Column(name = "region", nullable = true)
	private String region;

	@Column(name = "subregion", nullable = true)
	private String subregion;

	@Column(name = "nationality", nullable = true)
	private String nationality;

	@Column(name = "timezones", nullable = true, columnDefinition = "TEXT")
	private String timezones;

	@Column(name = "latitude", nullable = true)
	private Long latitude;

	@Column(name = "longitude", nullable = true)
	private Long longitude;

	@Column(name = "emoji", nullable = true)
	private String emoji;

	@Column(name = "emojiu", nullable = true)
	private String emojiu;

	@Column(name = "business", nullable = true)
	private boolean business;
}
