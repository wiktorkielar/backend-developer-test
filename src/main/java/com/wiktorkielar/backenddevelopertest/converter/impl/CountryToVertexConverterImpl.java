package com.wiktorkielar.backenddevelopertest.converter.impl;

import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.model.Vertex;
import com.wiktorkielar.backenddevelopertest.converter.CountryToVertexConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryToVertexConverterImpl implements CountryToVertexConverter {

    @Override
    public List<Vertex> convert(List<Country> countries) {
        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < countries.size(); i++) {
            vertices.add(new Vertex(i));
            List<String> borders = countries.get(i).getBorders();
            List<Integer> adjacentVertices = new ArrayList<>();
            for (String border : borders) {
                for (int k = 0; k < countries.size(); k++) {
                    if (border.equals(countries.get(k).getCode())) {
                        adjacentVertices.add(k);
                    }
                }
            }
            vertices.get(i).setAdjacentVertices(adjacentVertices);
        }
        return vertices;
    }
}
