package com.wiktorkielar.backenddevelopertest.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Route {
    private List<String> route;
}
