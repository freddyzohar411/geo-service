package com.avensys.rts.geo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avensys.rts.geo.entity.CountriesEntity;

/**
 * 
 * @author Pranay.Patadiya
 */

@Repository
public interface CountriesRepository extends JpaRepository<CountriesEntity, Integer>{
	List<CountriesEntity> findByBusiness(boolean business);
}
