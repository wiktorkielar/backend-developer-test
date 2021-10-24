package com.wiktorkielar.backenddevelopertest.service;

import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.model.Route;

import java.util.List;

public interface VertexToRouteConverter {
    Route convert(List<Integer> vertices, List<Country> countries);
}
