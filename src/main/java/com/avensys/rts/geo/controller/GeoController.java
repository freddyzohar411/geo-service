package com.avensys.rts.geo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

	@Autowired
	private CountryService countryService;

	@Autowired
	MessageSource messageSource;

	@GetMapping("/")
	public  ResponseEntity<Object> getCountries() {
		
		return ResponseUtil.generateSuccessResponse(countryService.getCountryList(), HttpStatus.OK,
				messageSource.getMessage("geo.success", null, LocaleContextHolder.getLocale()));
	}
}
