package com.wiktorkielar.backenddevelopertest.service.impl;

import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.model.Route;
import com.wiktorkielar.backenddevelopertest.model.Vertex;
import com.wiktorkielar.backenddevelopertest.service.*;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RoutingServiceImpl implements RoutingService {

    private final DataInitializationService dataInitializationService;
    private final BreadthFirstSearchService breadthFirstSearchService;
    private final CountryToVertexConverter countryToVertexConverter;
    private final VertexToRouteConverter vertexToRouteConverter;

    public RoutingServiceImpl(DataInitializationService dataInitializationService,
                              BreadthFirstSearchService breadthFirstSearchService,
                              CountryToVertexConverter countryToVertexConverter,
                              VertexToRouteConverter vertexToRouteConverter) {
        this.dataInitializationService = dataInitializationService;
        this.breadthFirstSearchService = breadthFirstSearchService;
        this.countryToVertexConverter = countryToVertexConverter;
        this.vertexToRouteConverter = vertexToRouteConverter;
    }

    @Override
    public Route getRoute(String sourceCountry, String destinationCountry) throws IOException, ParseException {
        List<Country> countries = dataInitializationService.initializeData();
        List<Vertex> vertices = countryToVertexConverter.convert(countries);
        Integer sourceVertex = findVertex(countries, vertices, sourceCountry);
        Integer destinationVertex = findVertex(countries, vertices, destinationCountry);
        List<Integer> chosenVertices = breadthFirstSearchService.getShortestPath(sourceVertex, destinationVertex, vertices);
        return vertexToRouteConverter.convert(chosenVertices, countries);
    }

    private Integer findVertex(List<Country> countries, List<Vertex> vertices, String countryName) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getName().equals(countryName)) {
                return vertices.get(i).getIndex();
            }
        }
        return -1;
    }
}
