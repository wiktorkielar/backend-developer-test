package com.wiktorkielar.backenddevelopertest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class Country {
    private String code;
    private List<String> borders;
}
