package com.avensys.rts.geo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avensys.rts.geo.entity.CityEntity;
import java.util.List;


/**
 * 
 * @author Pranay.Patadiya
 */
@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {

	List<CityEntity> findByCountryid(Integer countryid);
	
	List<CityEntity> findByStateid(Integer stateid);
}