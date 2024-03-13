package com.avensys.rts.geo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avensys.rts.geo.payload.CityDTO;



/**
 * 
 * @author Pranay.Patadiya
 */
@Service
public interface CityService {
	List<CityDTO> getCitiesByCountryId(Integer countryId);

	List<CityDTO> getCitiesByStateId(Integer stateId);

	List<CityDTO> getAllCities();
	
	//List<CityDTO> getAllCitiesWithOrder();
}
