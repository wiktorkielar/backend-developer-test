package com.wiktorkielar.backenddevelopertest.service.impl;

import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.model.Route;
import com.wiktorkielar.backenddevelopertest.service.VertexToRouteConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VertexToRouteConverterImpl implements VertexToRouteConverter {
    @Override
    public Route convert(List<Integer> vertices, List<Country> countries) {
        List<String> route = new ArrayList<>();
        vertices.forEach(integer -> route.add(countries.get(integer).getName()));
        return Route.builder()
                .route(route)
                .build();
    }
}
