package com.wiktorkielar.backenddevelopertest.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Country {
    private String name;
    private List<String> borders;
}
