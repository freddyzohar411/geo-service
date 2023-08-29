package com.avensys.rts.geo.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avensys.rts.geo.entity.StateEntity;
import com.avensys.rts.geo.payload.StateDTO;
import com.avensys.rts.geo.repository.StateRepository;

/**
 * 
 * @author Pranay.Patadiya
 */

@Component
public class StateServiceImpl implements StateService {

	private static final Logger log = LogManager.getLogger(StateServiceImpl.class);

	@Autowired
	StateRepository stateRepo;

	@Override
	public List<StateDTO> getStateByCountryId(Integer countryid) {
		log.info("Get state by country Id");
		return toDTO(stateRepo.findByCountryid(countryid));
	}

	/***
	 * 
	 * @param entities
	 * @return
	 */
	private List<StateDTO> toDTO(List<StateEntity> entities) {

		List<StateDTO> l = new ArrayList<>();

		for (StateEntity s : entities) {
			StateDTO dto = new StateDTO();
			dto.setId(s.getId());
			dto.setName(s.getName());
			dto.setCountryid(s.getCountryid());
			dto.setStatecode(s.getStatecode());
			dto.setCountrycode(s.getCountry_code());

			l.add(dto);
		}

		return l;
	}

}
