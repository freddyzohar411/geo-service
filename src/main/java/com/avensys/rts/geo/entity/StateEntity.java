package com.avensys.rts.geo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Pranay.Patadiya
 */

@Entity
@Table(name = "states")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", length = 80, nullable = false)
	private String name;

	@Column(name = "country_id")
	private Integer countryid;

	@Column(name = "country_code")
	private String country_code;
	
	@Column(name = "country_name")
	private String countryname;

	@Column(name = "state_code")
	private String statecode;

	@Column(name = "type", nullable = true)
	private String type;

}
