package com.wiktorkielar.backenddevelopertest.converter.impl;

import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.model.Path;
import com.wiktorkielar.backenddevelopertest.converter.VertexToPathConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VertexToPathConverterImpl implements VertexToPathConverter {
    @Override
    public Path convert(List<Integer> vertices, List<Country> countries) {
        List<String> route = new ArrayList<>();
        vertices.forEach(integer -> route.add(countries.get(integer).getCode()));
        return new Path(route);
    }
}
