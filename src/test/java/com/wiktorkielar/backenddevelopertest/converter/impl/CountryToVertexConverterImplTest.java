package com.wiktorkielar.backenddevelopertest.converter.impl;

import com.wiktorkielar.backenddevelopertest.converter.CountryToVertexConverter;
import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.model.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryToVertexConverterImplTest {

    private CountryToVertexConverter countryToVertexConverter;

    @BeforeEach
    void setup() {
        countryToVertexConverter = new CountryToVertexConverterImpl();
    }

    @Test
    void shouldReturnCorrectVertices() {
        //given
        List<Country> countries = List.of(
                new Country("CAN", List.of("USA")),
                new Country("USA", List.of("CAN", "MEX")),
                new Country("MEX", List.of("USA"))
        );
        List<Vertex> expectedVertices = List.of(
                new Vertex(0, List.of(1)),
                new Vertex(1, List.of(0, 2)),
                new Vertex(2, List.of(1))
        );

        //when
        List<Vertex> vertices = countryToVertexConverter.convert(countries);

        //then
        assertEquals(expectedVertices, vertices);
    }

}