package com.wiktorkielar.backenddevelopertest.service.impl;

import com.wiktorkielar.backenddevelopertest.converter.CountryToVertexConverter;
import com.wiktorkielar.backenddevelopertest.converter.VertexToPathConverter;
import com.wiktorkielar.backenddevelopertest.converter.impl.CountryToVertexConverterImpl;
import com.wiktorkielar.backenddevelopertest.converter.impl.VertexToPathConverterImpl;
import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.model.Path;
import com.wiktorkielar.backenddevelopertest.service.BreadthFirstSearchService;
import com.wiktorkielar.backenddevelopertest.service.CountryDataInitializationService;
import com.wiktorkielar.backenddevelopertest.service.RoutingService;
import com.wiktorkielar.backenddevelopertest.validator.CountryValidator;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoutingServiceImplTest {
    @Mock
    private CountryDataInitializationService countryDataInitializationService;
    private CountryValidator countryValidator;
    private BreadthFirstSearchService breadthFirstSearchService;
    private CountryToVertexConverter countryToVertexConverter;
    private VertexToPathConverter vertexToPathConverter;

    private RoutingService routingService;

    @BeforeEach
    void setup() {
        countryValidator = new CountryValidator(countryDataInitializationService);
        breadthFirstSearchService = new BreadthFirstSearchServiceImpl();
        countryToVertexConverter = new CountryToVertexConverterImpl();
        vertexToPathConverter = new VertexToPathConverterImpl();
        routingService = new RoutingServiceImpl(countryValidator,
                countryDataInitializationService,
                breadthFirstSearchService,
                countryToVertexConverter,
                vertexToPathConverter);
    }

    @Test
    void shouldGetPath() throws IOException, ParseException {
        //given
        String sourceCountry = "CZE";
        String destinationCountry = "ITA";
        Path expectedPath = new Path(List.of("POL", "DEU", "FRA"));

        //when
        when(countryDataInitializationService.initializeData()).thenReturn(List.of(
                new Country("POL", List.of("BLR", "CZE", "DEU", "LTU", "RUS", "SVK", "UKR")),
                new Country("DEU", List.of("AUT", "BEL", "CZE", "DNK", "FRA", "LUX", "NLD", "POL", "CHE")),
                new Country("FRA", List.of("AND", "BEL", "DEU", "ITA", "LUX", "MCO", "ESP", "CHE"))
        ));
        //then
        assertEquals(expectedPath, routingService.getPath("POL", "FRA"));
    }


}