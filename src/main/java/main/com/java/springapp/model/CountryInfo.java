/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.com.java.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

    
@Entity
@Data
@Table(name = "country_info", schema = "ref")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryInfo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @Column(name = "area")
        private Integer area;

        @Column(name = "cca2")
        private String cca2;

        @Column(name = "cca3")
        private String cca3;

        @Column(name = "ccn3")
        private Short ccn3;

        @Column(name = "coa_png")
        private String coaPng;

        @Column(name = "coa_svg")
        private String coaSvg;

        @Column(name = "common")
        private String common;

        @Column(name = "flag")
        private String flag;

        @Column(name = "flag_alt")
        private String flagAlt;

        @Column(name = "flag_png")
        private String flagPng;

        @Column(name = "flag_svg")
        private String flagSvg;

        @Column(name = "format")
        private String format;

        @Column(name = "googlemaps")
        private String googlemaps;

        @Column(name = "idd_root")
        private String iddRoot;

        @Column(name = "independent")
        private Boolean independent;

        @Column(name = "landlocked")
        private Boolean landlocked;

        @Column(name = "official")
        private String official;

        @Column(name = "openstreetmaps")
        private String openstreetmaps;

        @Column(name = "population")
        private Integer population;

        @Column(name = "regex")
        private String regex;

        @Column(name = "region")
        private String region;

        @Column(name = "startofweek")
        private String startofweek;

        @Column(name = "status")
        private String status;

        @Column(name = "subregion")
        private String subregion;

        @Column(name = "unmember")
        private Boolean unmember;

        @Column(name = "altspellings")
        private String altspellings;

        @Column(name = "borders")
        private String borders;

        @Column(name = "capital")
        private String capital;

        @Column(name = "continents")
        private String continents;

        @Column(name = "currencies")
        private String currencies;

        @Column(name = "idd_suffixes")
        private String iddSuffixes;

        @Column(name = "languages")
        private String languages;

        @Column(name = "latlng", length = 150000)
        private String latlng;

        @Column(name = "nativename", length = 150000)
        private String nativename;

        @Column(name = "timezones")
        private String timezones;

        @Column(name = "translations", length = 150000)
        private String translations;

        @Column(name = "tld")
        private String tld;

        @OneToOne
        @JoinColumn(name = "id")
        @JsonIgnore 
        private Country country;
}
