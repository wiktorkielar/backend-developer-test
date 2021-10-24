package com.wiktorkielar.backenddevelopertest.service.impl;

import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.service.JsonConverter;
import com.wiktorkielar.backenddevelopertest.service.DataInitializationService;
import com.wiktorkielar.backenddevelopertest.service.DownloadJsonService;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DataInitializationServiceImpl implements DataInitializationService {

    @Value("${app-data.json-uri}")
    private String jsonUri;

    private final DownloadJsonService downloadJSONService;
    private final JsonConverter<Country> jsonConverter;

    public DataInitializationServiceImpl(DownloadJsonService downloadJSONService,
                                         JsonConverter<Country> jsonConverter) {
        this.downloadJSONService = downloadJSONService;
        this.jsonConverter = jsonConverter;
    }

    @Override
    public List<Country> initializeData() throws IOException, ParseException {
        String httpEntity = downloadJSONService.downloadJSON(jsonUri, "Countries");
        return jsonConverter.covertJSON(httpEntity);
    }
}
