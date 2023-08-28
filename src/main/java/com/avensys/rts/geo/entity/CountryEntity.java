package com.avensys.rts.geo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *
 * @author Pranay Patadiya
 * This is the entity class for the Geo/Country table in the database
 *
 */

@Entity
@Table(name = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 80, nullable = false)
    private String name;
    
    @Column(name = "nicename", length = 80, nullable = false)
    private String nicename;

    @Column(name = "iso", length = 2)
    private String iso;

    @Column(name = "iso3", length = 3)
    private String iso3;

    @Column(name = "phonecode")
    private Integer phonecode;
    
    @Column(name = "numcode", nullable = true)
    private Integer numcode;

}
