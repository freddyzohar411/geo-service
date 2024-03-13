package com.avensys.rts.geo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avensys.rts.geo.entity.CityEntity;
import com.avensys.rts.geo.payload.CityDTO;
import com.avensys.rts.geo.repository.CityRepository;

/**
 * 
 * @author Pranay.Patadiya
 */
@Component
public class CityServiceImpl implements CityService {

	private static final Logger log = LogManager.getLogger(CityServiceImpl.class);

	@Autowired
	CityRepository cityRepo;

	@Override
	public List<CityDTO> getCitiesByCountryId(Integer countryId) {
		log.info("Get Cities by Country Id : {}", countryId);
		return toDTO(cityRepo.findByCountryid(countryId));
	}

	@Override
	public List<CityDTO> getCitiesByStateId(Integer stateId) {
		log.info("Get Cities by state Id : {}", stateId);
		return toDTO(cityRepo.findByStateid(stateId));
	}

	@Override
	public List<CityDTO> getAllCities() {
		log.info("Get All Cities");
		return toDTO(cityRepo.findAll());
	}
	

	/*
	 * @Override public List<CityDTO> getAllCitiesWithOrder() {
	 * log.info("Get All Cities"); return toDTO(cityRepo.getAllCitiesWithSorting());
	 * 
	 * }
	 */

	private List<CityDTO> toDTO(List<CityEntity> entities) {

		List<CityDTO> l = new ArrayList<CityDTO>();
		List<CityDTO> sortedList = new ArrayList<CityDTO>();
		for (CityEntity c : entities) {

			CityDTO dto = new CityDTO();
			dto.setCountrycode(c.getCountrycode());
			dto.setName(c.getName());
			dto.setId(c.getId());
			dto.setStatecode(c.getStatecode());
			dto.setCountryid(c.getCountryid());
			dto.setStateid(c.getStateid());

			l.add(dto);

		}
		
		  sortedList = l.stream() .sorted(Comparator.comparing(CityDTO::getName))
		  .collect(Collectors.toList());
		 

		return sortedList;
	}


}
