package com.avensys.rts.geo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avensys.rts.geo.entity.CountriesEntity;
import com.avensys.rts.geo.payload.CountriesDTO;
import com.avensys.rts.geo.repository.CountriesRepository;

/**
 * 
 * @author Pranay.Patadiya
 */

@Component
public class CountriesServiceImpl implements CountriesService{

	private static final Logger log = LogManager.getLogger(CountriesServiceImpl.class);
	
	@Autowired
	CountriesRepository countriesRepo;
	
	@Override
	public List<CountriesDTO> getAllCountries() {
		log.info("Get all countries");
		return this.toDTO(countriesRepo.findAll());
	}
	
	
	/***
	 * 
	 * @param coutnriesEntityList
	 * @return
	 */
	private List<CountriesDTO> toDTO(List<CountriesEntity> coutnriesEntityList){
		List<CountriesDTO> list = new ArrayList<>();
		
		for(CountriesEntity e : coutnriesEntityList) {
			CountriesDTO c = new CountriesDTO();
			c.setId(e.getId());
			c.setName(e.getName());
			c.setIso3(e.getIso3());
			c.setPhonecode(e.getPhonecode());
			
			list.add(c);
		}
		
		return list;
	}

}
