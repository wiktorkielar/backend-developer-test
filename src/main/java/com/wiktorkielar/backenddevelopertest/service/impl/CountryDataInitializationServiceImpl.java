package com.wiktorkielar.backenddevelopertest.service.impl;

import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.converter.JsonToCountryConverter;
import com.wiktorkielar.backenddevelopertest.service.CountryDataInitializationService;
import com.wiktorkielar.backenddevelopertest.service.JsonDataProvider;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CountryDataInitializationServiceImpl implements CountryDataInitializationService {

    @Value("${app-data.json-uri}")
    private String jsonUri;

    private final JsonDataProvider jsonDataProvider;
    private final JsonToCountryConverter jsonConverter;

    public CountryDataInitializationServiceImpl(JsonDataProvider jsonDataProvider,
                                                JsonToCountryConverter jsonConverter) {
        this.jsonDataProvider = jsonDataProvider;
        this.jsonConverter = jsonConverter;
    }

    @Override
    public List<Country> initializeData() throws IOException, ParseException {
        String httpEntity = jsonDataProvider.getJsonData(jsonUri);
        return jsonConverter.convert(httpEntity);
    }
}
