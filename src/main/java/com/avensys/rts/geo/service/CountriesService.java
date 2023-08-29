package com.avensys.rts.geo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avensys.rts.geo.payload.CountriesDTO;

/**
 * 
 * @author Pranay.Patadiya
 */
@Service
public interface CountriesService {

	List<CountriesDTO> getAllCountries();
}
