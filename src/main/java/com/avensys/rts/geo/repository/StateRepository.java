package com.avensys.rts.geo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avensys.rts.geo.entity.StateEntity;
import java.util.List;


/**
 * 
 * @author Pranay.Patadiya
 */

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Integer>{

	List<StateEntity> findByCountryid(Integer countryid);
	
}
