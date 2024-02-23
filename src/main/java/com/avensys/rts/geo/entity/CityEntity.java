package com.avensys.rts.geo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cities")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CityEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "state_id")
	private Integer stateid;

	@Column(name = "state_name")
	private String statename;

	@Column(name = "state_code")
	private String statecode;

	@Column(name = "country_id")
	private Integer countryid;

	@Column(name = "country_name")
	private String countryname;

	@Column(name = "country_code")
	private String countrycode;
}
