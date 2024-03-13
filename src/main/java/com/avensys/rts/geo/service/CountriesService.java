package com.avensys.rts.geo.service;

import java.util.List;

import com.avensys.rts.geo.payload.CountriesBusinessDTO;
import com.avensys.rts.geo.payload.CountriesCurrencyDTO;
import org.springframework.stereotype.Service;

import com.avensys.rts.geo.payload.CountriesDTO;

/**
 * 
 * @author Pranay.Patadiya
 */
@Service
public interface CountriesService {

	List<CountriesDTO> getAllCountries();
	
	List<CountriesDTO> getAllCountriesPhonecode();

	List<CountriesCurrencyDTO> getAllCountriesCurrency();

	List<CountriesBusinessDTO> getOfferedCountries();
	
	CountriesCurrencyDTO getCountryCurrencyById(Integer countryId);
	
}
