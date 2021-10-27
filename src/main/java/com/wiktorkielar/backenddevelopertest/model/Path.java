package com.wiktorkielar.backenddevelopertest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Path {
    private List<String> route;
}
