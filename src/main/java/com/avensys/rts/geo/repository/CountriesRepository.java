package com.avensys.rts.geo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avensys.rts.geo.entity.CountriesEntity;

/**
 * 
 * @author Pranay.Patadiya
 */

@Repository
public interface CountriesRepository extends JpaRepository<CountriesEntity, Integer>{

}
