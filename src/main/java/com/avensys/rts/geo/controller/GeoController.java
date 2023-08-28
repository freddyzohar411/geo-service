package com.avensys.rts.geo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.avensys.rts.constants.Constants;
import com.avensys.rts.geo.service.CountryService;
import com.avensys.rts.geo.util.ResponseUtil;

/**
 * 
 * @author Pranay.Patadiya
 */
@ResponseBody
@RestController
@RequestMapping(value = "/geo/country")
public class GeoController {

	private static final Logger log = LogManager.getLogger(GeoController.class);
	
	@Autowired
	private CountryService countryService;

	@Autowired
	MessageSource messageSource;

	@GetMapping("/")
	public  ResponseEntity<Object> getCountries() {
		log.info("Get List of all countries : Controller ");
		return ResponseUtil.generateSuccessResponse(countryService.getCountryList(), HttpStatus.OK,
				messageSource.getMessage(Constants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
	}
}
