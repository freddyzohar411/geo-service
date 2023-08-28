package com.avensys.rts.geo.service;

import com.avensys.rts.geo.payload.Countries;

/**
 * @author Pranay Patadiya
 * This interface is used to declare methods for AccountService
 */
public interface CountryService {

    /**
     * This method is used to get country list
     * @param getCountryList
     * @return
     */

   	Countries getCountryList();

}
