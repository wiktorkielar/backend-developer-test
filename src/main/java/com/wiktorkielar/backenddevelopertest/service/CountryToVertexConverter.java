package com.wiktorkielar.backenddevelopertest.service;

import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.model.Vertex;

import java.util.List;

public interface CountryToVertexConverter {
    List<Vertex> convert(List<Country> countries);
}
