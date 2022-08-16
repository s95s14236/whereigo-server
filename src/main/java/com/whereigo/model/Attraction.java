package com.whereigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "attraction")
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonProperty(value = "Id")
    @Column(name = "attractionid")
    private String attractionId;

    @JsonProperty(value = "Name")
    @Column(name = "name")
    private String name;

    @JsonProperty(value = "Zone")
    @Column(name = "zone")
    private String zone;

    @JsonProperty(value = "Toldescribe")
    @Column(name = "toldescribe", length = 2048)
    private String toldescribe;

    @JsonProperty(value = "Description")
    @Column(name = "description", length = 512)
    private String description;

    @JsonProperty(value = "Tel")
    @Column(name = "tel")
    private String tel;

    @JsonProperty(value = "Add")
    @Column(name = "add")
    private String add;

    @JsonProperty(value = "Zipcode")
    @Column(name = "zipcode")
    private String zipcode;

    @JsonProperty(value = "Region")
    @Column(name = "region")
    private String region;

    @JsonProperty(value = "Town")
    @Column(name = "town")
    private String town;

    @JsonProperty(value = "Travellinginfo")
    @Column(name = "travellinginfo", length = 512)
    private String travellinginfo;

    @JsonProperty(value = "Opentime")
    @Column(name = "opentime")
    private String opentime;

    @JsonProperty(value = "Picture1")
    @Column(name = "picture1")
    private String picture1;

    @JsonProperty(value = "Picdescribe1")
    @Column(name = "picdescribe1")
    private String picdescribe1;

    @JsonProperty(value = "Picture2")
    @Column(name = "picture2")
    private String Picture2;

    @JsonProperty(value = "Picdescribe2")
    @Column(name = "picdescribe2")
    private String picdescribe2;

    @JsonProperty(value = "Picture3")
    @Column(name = "picture3")
    private String picture3;

    @JsonProperty(value = "Picdescribe3")
    @Column(name = "picdescribe3")
    private String picdescribe3;

    @JsonProperty(value = "Map")
    @Column(name = "map")
    private String map;

    @JsonProperty(value = "Gov")
    @Column(name = "gov")
    private String gov;

    @JsonProperty(value = "Px")
    @Column(name = "px")
    private float px;

    @JsonProperty(value = "Py")
    @Column(name = "py")
    private float py;

    @JsonProperty(value = "Orgclass")
    @Column(name = "orgclass")
    private String orgclass;

    @JsonProperty(value = "Class1")
    @Column(name = "class1")
    private String class1;

    @JsonProperty(value = "Class2")
    @Column(name = "class2")
    private String class2;

    @JsonProperty(value = "Class3")
    @Column(name = "class3")
    private String class3;

    @JsonProperty(value = "Level")
    @Column(name = "level")
    private String level;

    @JsonProperty(value = "Website")
    @Column(name = "website")
    private String website;

    @JsonProperty(value = "Parkinginfo")
    @Column(name = "parkinginfo")
    private String parkinginfo;

    @JsonProperty(value = "Parkinginfo_Px")
    @Column(name = "parkinginfo_Px")
    private Float parkinginfo_Px;

    @JsonProperty(value = "Parkinginfo_Py")
    @Column(name = "parkinginfo_Py")
    private Float parkinginfo_Py;

    @JsonProperty(value = "Ticketinfo")
    @Column(name = "ticketinfo")
    private String ticketinfo;

    @JsonProperty(value = "Remarks")
    @Column(name = "remarks")
    private String remarks;

    @JsonProperty(value = "Keyword")
    @Column(name = "keyword")
    private String keyword;

    @JsonProperty(value = "Changetime")
    @Column(name = "changetime")
    private String changetime;
}
