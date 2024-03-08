package com.avensys.rts.geo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avensys.rts.geo.entity.CityEntity;


/**
 * 
 * @author Pranay.Patadiya
 */
@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer>, JpaSpecificationExecutor<CityEntity> {

	List<CityEntity> findByCountryid(Integer countryid);
	
	List<CityEntity> findByStateid(Integer stateid);
	
	//@Query("SELECT * FROM public.cities ORDER BY name ASC")
	//List<CityEntity> getAllCitiesWithSorting();
}