package com.avensys.rts.geo.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avensys.rts.geo.entity.CountryEntity;
import com.avensys.rts.geo.payload.Countries;
import com.avensys.rts.geo.payload.CountryDTO;
import com.avensys.rts.geo.repository.CountryRepository;

/**
 * @author Pranay Patadiya
 * This class is used to implement the CountryService interface
 */
@Component
public class CountryServiceImpl implements CountryService {

	private static final Logger log = LogManager.getLogger(CountryServiceImpl.class);
	
	@Autowired
	CountryRepository countryRepo;
	
	/**
	 * Get all country list
	 */
	@Override
	public Countries getCountryList() {
		Countries res =toDTO(countryRepo.findAll());
		log.info("Get List of all countries : TOTAL : {} ", res.getCountries().size());
		return res;
	}

	/***
	 * Internal method to convert Entity to DTO
	 * @param entities
	 * @return
	 */
	private Countries toDTO(List<CountryEntity> entities){
	
		List<CountryDTO> countries = new ArrayList<>();
		
		for(CountryEntity e : entities) {
			CountryDTO c = new CountryDTO();
			c.setId(e.getId());
			c.setName(e.getName());
			c.setNicename(e.getNicename());
			c.setIso(e.getIso() != null ?e.getIso():"");
			c.setIso3(e.getIso3() != null ?e.getIso3():"");
			c.setPhonecode(e.getPhonecode());
			countries.add(c);
		}
		Countries countriesList = new Countries();
		countriesList.setCountries(countries);
		return countriesList;
		
	}
    
}