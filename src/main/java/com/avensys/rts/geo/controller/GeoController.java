package com.avensys.rts.geo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avensys.rts.constants.Constants;
import com.avensys.rts.geo.service.CityService;
import com.avensys.rts.geo.service.CountriesService;
import com.avensys.rts.geo.service.StateService;
import com.avensys.rts.geo.util.ResponseUtil;

/**
 * 
 * @author Pranay.Patadiya
 */
@ResponseBody
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/geo")
public class GeoController {

	private static final Logger log = LogManager.getLogger(GeoController.class);

	@Autowired
	private CountriesService countriesService;

	@Autowired
	private StateService stateService;

	@Autowired
	private CityService cityService;

	@Autowired
	MessageSource messageSource;

	@GetMapping("/country")
	public ResponseEntity<Object> getCountries() {
		log.info("Get List of all countries : Controller ");
		return ResponseUtil.generateSuccessResponse(countriesService.getAllCountries(), HttpStatus.OK,
				messageSource.getMessage(Constants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
	}

	@GetMapping("/states/{countryid}")
	public ResponseEntity<Object> getStatesFromCountry(@PathVariable Integer countryid) {
		log.info("Get List of all states by country : Controller ");

		if (countryid == null) {
			return ResponseUtil.generateSuccessResponse(null, HttpStatus.BAD_REQUEST,
					messageSource.getMessage(Constants.MESSAGE_PARAMS_MISSING, null, LocaleContextHolder.getLocale()));
		} else if (countryid <= 0) {
			return ResponseUtil.generateSuccessResponse(null, HttpStatus.BAD_REQUEST, messageSource
					.getMessage(Constants.MESSAGE_WRONG_PARAMS_VALUE, null, LocaleContextHolder.getLocale()));
		}

		return ResponseUtil.generateSuccessResponse(stateService.getStateByCountryId(countryid), HttpStatus.OK,
				messageSource.getMessage(Constants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
	}

	@GetMapping("/cities/state/{stateid}")
	public ResponseEntity<Object> getCitiesFromState(@PathVariable Integer stateid) {
		log.info("Get List of all cities by state : Controller ");

		if (stateid == null) {
			return ResponseUtil.generateSuccessResponse(null, HttpStatus.BAD_REQUEST,
					messageSource.getMessage(Constants.MESSAGE_PARAMS_MISSING, null, LocaleContextHolder.getLocale()));
		} else if (stateid <= 0) {
			return ResponseUtil.generateSuccessResponse(null, HttpStatus.BAD_REQUEST, messageSource
					.getMessage(Constants.MESSAGE_WRONG_PARAMS_VALUE, null, LocaleContextHolder.getLocale()));
		}

		return ResponseUtil.generateSuccessResponse(cityService.getCitiesByStateId(stateid), HttpStatus.OK,
				messageSource.getMessage(Constants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
	}

	@GetMapping("/cities/country/{countryid}")
	public ResponseEntity<Object> getCitiesFromCountry(@PathVariable Integer countryid) {
		log.info("Get List of all cities by country : Controller ");

		if (countryid == null) {
			return ResponseUtil.generateSuccessResponse(null, HttpStatus.BAD_REQUEST,
					messageSource.getMessage(Constants.MESSAGE_PARAMS_MISSING, null, LocaleContextHolder.getLocale()));
		} else if (countryid <= 0) {
			return ResponseUtil.generateSuccessResponse(null, HttpStatus.BAD_REQUEST, messageSource
					.getMessage(Constants.MESSAGE_WRONG_PARAMS_VALUE, null, LocaleContextHolder.getLocale()));
		}

		return ResponseUtil.generateSuccessResponse(cityService.getCitiesByCountryId(countryid), HttpStatus.OK,
				messageSource.getMessage(Constants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
	}

	@GetMapping("/country-currency")
	public ResponseEntity<Object> getCountriesAndCurrency() {
		log.info("Get List of all countries : Controller ");
		return ResponseUtil.generateSuccessResponse(countriesService.getAllCountriesCurrency(), HttpStatus.OK,
				messageSource.getMessage(Constants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
	}

	@GetMapping("/country-currency/{countryId}")
	public ResponseEntity<Object> getCountryCurrencyById(@PathVariable Integer countryId) {
		log.info("Get country and currency by id : Controller ");
		return ResponseUtil.generateSuccessResponse(countriesService.getCountryCurrencyById(countryId), HttpStatus.OK,
				messageSource.getMessage(Constants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
	}

	@GetMapping("/cities")
	public ResponseEntity<Object> getAllCities() {
		log.info("Get List of all cities : Controller ");
		return ResponseUtil.generateSuccessResponse(cityService.getAllCities(), HttpStatus.OK,
				messageSource.getMessage(Constants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
	}

	/*
	 * @GetMapping("/cities/order") public ResponseEntity<Object> getAllCities1() {
	 * log.info("Get List of all cities : Controller "); return
	 * ResponseUtil.generateSuccessResponse(cityService.getAllCitiesWithOrder(),
	 * HttpStatus.OK, messageSource.getMessage(Constants.MESSAGE_SUCCESS, null,
	 * LocaleContextHolder.getLocale())); }
	 */

	@GetMapping("/offer-country")
	public ResponseEntity<Object> getBusinessCountries() {
		log.info("Get List of all cities : Controller ");
		return ResponseUtil.generateSuccessResponse(countriesService.getOfferedCountries(), HttpStatus.OK,
				messageSource.getMessage(Constants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
	}
	
	@GetMapping("/country/phonecode")
	public ResponseEntity<Object> getPhonecode() {
		log.info("Get List of all countries : Controller ");
		return ResponseUtil.generateSuccessResponse(countriesService.getAllCountriesPhonecode(), HttpStatus.OK,
				messageSource.getMessage(Constants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
	}

}
