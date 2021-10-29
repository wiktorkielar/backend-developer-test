package com.wiktorkielar.backenddevelopertest.service.impl;

import com.wiktorkielar.backenddevelopertest.converter.CountryToVertexConverter;
import com.wiktorkielar.backenddevelopertest.converter.VertexToPathConverter;
import com.wiktorkielar.backenddevelopertest.exception.InvalidCountryCodeException;
import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.model.Path;
import com.wiktorkielar.backenddevelopertest.model.Vertex;
import com.wiktorkielar.backenddevelopertest.service.BreadthFirstSearchService;
import com.wiktorkielar.backenddevelopertest.service.CountryDataInitializationService;
import com.wiktorkielar.backenddevelopertest.service.RoutingService;
import com.wiktorkielar.backenddevelopertest.validator.CountryValidator;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RoutingServiceImpl implements RoutingService {

    private final CountryValidator countryValidator;
    private final CountryDataInitializationService countryDataInitializationService;
    private final BreadthFirstSearchService breadthFirstSearchService;
    private final CountryToVertexConverter countryToVertexConverter;
    private final VertexToPathConverter vertexToPathConverter;

    public RoutingServiceImpl(CountryValidator countryValidator,
                              CountryDataInitializationService countryDataInitializationService,
                              BreadthFirstSearchService breadthFirstSearchService,
                              CountryToVertexConverter countryToVertexConverter,
                              VertexToPathConverter vertexToPathConverter) {
        this.countryValidator = countryValidator;
        this.countryDataInitializationService = countryDataInitializationService;
        this.breadthFirstSearchService = breadthFirstSearchService;
        this.countryToVertexConverter = countryToVertexConverter;
        this.vertexToPathConverter = vertexToPathConverter;
    }

    @Override
    public Path getPath(String sourceCountry, String destinationCountry) throws IOException, ParseException {
        if (!countryValidator.isValid(sourceCountry) || !countryValidator.isValid(destinationCountry)) {
            throw new InvalidCountryCodeException("One of provided country codes is invalid");
        }
        List<Country> countries = countryDataInitializationService.initializeData();
        List<Vertex> vertices = countryToVertexConverter.convert(countries);
        Integer sourceVertex = findVertex(countries, vertices, sourceCountry);
        Integer destinationVertex = findVertex(countries, vertices, destinationCountry);
        List<Integer> chosenVertices = breadthFirstSearchService.getShortestPath(sourceVertex, destinationVertex, vertices);
        return vertexToPathConverter.convert(chosenVertices, countries);
    }

    private int findVertex(List<Country> countries, List<Vertex> vertices, String countryName) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCode().equals(countryName)) {
                return vertices.get(i).getIndex();
            }
        }
        return -1;
    }
}
