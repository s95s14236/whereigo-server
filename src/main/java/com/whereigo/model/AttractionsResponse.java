package com.whereigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttractionsResponse {

    @JsonProperty(value = "XML_Head")
    private AttractionXmlHead xml_head;
}
