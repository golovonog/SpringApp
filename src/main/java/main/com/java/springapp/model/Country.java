package main.com.java.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "countries", schema = "ref")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
    
    @Column(name = "codecountr")
    @JsonProperty("codecountr")
    private int code;
    
    @Column(name = "alpha3countr", length = 3)
    private String alpha3countr;

    @Column(name = "alpha2countr", length = 2)
    private String alpha2countr;

    @Column(name = "namecountr")
    @JsonProperty("namecountr")
    private String name;

    @Column(name = "namecountrfull", length = 500)
    private String namecountrfull;

    @Column(name = "namecountrlat")
    private String namecountrlat;

    @Column(name = "flagcountr")
    private byte[] flagcountr;

    @Column(name = "namealt")
    private String namealt;

    @Column(name = "eublack")
    private Boolean eublack;

    @Column(name = "eugray")
    private Boolean eugray;

    @Column(name = "fatfblack")
    private Boolean fatfblack;

    @Column(name = "fatfgray")
    private Boolean fatfgray;

    @Column(name = "oecdblack")
    private Boolean oecdblack;

    @Column(name = "oecdgray")
    private Boolean oecdgray;

    @Column(name = "kmu1045")
    private Boolean kmu1045;

    @Column(name = "kmu143")
    private Boolean kmu143;

    @Column(name = "terrorism")
    private Boolean terrorism;

    @Column(name = "coruption")
    private Boolean coruption;

    @Column(name = "haven")
    private Boolean haven;

    @Column(name = "global")
    private Double global;

    @Column(name = "doubletax")
    private Boolean doubletax;

    @Column(name = "thirdcountries")
    private Boolean thirdcountries;

    @Column(name = "moneylaundering")
    private Float moneylaundering;

    @Column(name = "terrorismindex")
    private Double terrorismindex;

    @Column(name = "processed")
    private Boolean processed;

    @Column(name = "cyrillicnamed")
    private Boolean cyrillicnamed;

    @Column(name = "sectoral")
    private Boolean sectoral;

    @Column(name = "dangerous")
    private Boolean dangerous;

    @Column(name = "eresident")
    private Boolean eresident;
    
    @OneToOne(mappedBy = "country")
    private CountryInfo countryinfo;

}
