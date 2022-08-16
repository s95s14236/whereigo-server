package com.whereigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttractionXmlHead {

    @JsonProperty(value = "Listname")
    private String listname;

    @JsonProperty(value = "Language")
    private String language;

    @JsonProperty(value = "Orgname")
    private String orgname;

    @JsonProperty(value = "Updatetime")
    private String updatetime;

    @JsonProperty(value = "Infos")
    private AttractionInfo infos;

}
