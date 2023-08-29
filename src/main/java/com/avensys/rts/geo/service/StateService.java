package com.avensys.rts.geo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avensys.rts.geo.payload.StateDTO;

/**
 * 
 * @author Pranay.Patadiya
 */
@Service
public interface StateService {

	List<StateDTO> getStateByCountryId(Integer countryid);
	
}
