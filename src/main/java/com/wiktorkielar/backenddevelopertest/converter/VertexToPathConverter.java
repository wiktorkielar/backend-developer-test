package com.wiktorkielar.backenddevelopertest.converter;

import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.model.Path;

import java.util.List;

public interface VertexToPathConverter {
    Path convert(List<Integer> vertices, List<Country> countries);
}
