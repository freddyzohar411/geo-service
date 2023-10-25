package com.avensys.rts.geo.service;

import java.util.ArrayList;
import java.util.List;

import com.avensys.rts.geo.payload.CountriesBusinessDTO;
import com.avensys.rts.geo.payload.CountriesCurrencyDTO;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avensys.rts.geo.entity.CountriesEntity;
import com.avensys.rts.geo.payload.CountriesDTO;
import com.avensys.rts.geo.repository.CountriesRepository;

/**
 * @author Pranay.Patadiya
 */

@Component
public class CountriesServiceImpl implements CountriesService {

    private static final Logger log = LogManager.getLogger(CountriesServiceImpl.class);

    @Autowired
    CountriesRepository countriesRepo;

    @Override
    public List<CountriesDTO> getAllCountries() {
        log.info("Get all countries");
        return this.toDTO(countriesRepo.findAll());
    }

    @Override
    public List<CountriesCurrencyDTO> getAllCountriesCurrency() {
        log.info("Get all countries and currency");
        return countriesRepo.findAll().stream().map(this::toCountriesCurrencyDTO).toList();
    }

    @Override
    public CountriesCurrencyDTO getCountryCurrencyById(Integer countryId) {
        log.info("Get country and currency by id");
        CountriesEntity countriesEntity = countriesRepo.findById(countryId).orElseThrow(
                () -> new EntityNotFoundException("Country not found with id: " + countryId)
        );
        return this.toCountriesCurrencyDTO(countriesEntity);
    }


    /***
     *
     * @param coutnriesEntityList
     * @return
     */
    private List<CountriesDTO> toDTO(List<CountriesEntity> coutnriesEntityList) {
        List<CountriesDTO> list = new ArrayList<>();

        for (CountriesEntity e : coutnriesEntityList) {
            CountriesDTO c = new CountriesDTO();
            c.setId(e.getId());
            c.setName(e.getName());
            c.setIso3(e.getIso3());
            c.setPhonecode(e.getPhonecode());

            list.add(c);
        }

        return list;
    }

    private CountriesCurrencyDTO toCountriesCurrencyDTO(CountriesEntity e) {
        CountriesCurrencyDTO c = new CountriesCurrencyDTO();
        c.setId(e.getId());
        c.setName(e.getName());
        c.setIso2(e.getIso2());
        c.setIso3(e.getIso3());
        c.setPhoneCode(e.getPhonecode());
        c.setCurrency(e.getCurrency());
        c.setCurrencySymbol(e.getCurrencysymbol());
        return c;
    }
    
    private CountriesBusinessDTO toCountriesBusinessDTO(CountriesEntity e) {
    	CountriesBusinessDTO c = new CountriesBusinessDTO();
        c.setId(e.getId());
        c.setName(e.getName());
        c.setIso3(e.getIso3());
        c.setBusiness(e.isBusiness());
        return c;
    }

	@Override
	public List<CountriesBusinessDTO> getOfferedCountries() {
		log.info("Get country by business offered places");
        return countriesRepo.findByBusiness(true).stream().map(this::toCountriesBusinessDTO).toList();
	}

}
