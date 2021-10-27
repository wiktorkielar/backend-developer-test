package com.wiktorkielar.backenddevelopertest.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Country {
    private String code;
    private List<String> borders;
}
