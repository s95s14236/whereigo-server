package com.whereigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttractionInfo {
    @JsonProperty(value = "Info")
    private Attraction[] info;
}
