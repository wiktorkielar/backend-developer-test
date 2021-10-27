package com.wiktorkielar.backenddevelopertest.service;

import com.wiktorkielar.backenddevelopertest.model.Country;
import net.minidev.json.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface CountryDataInitializationService {
    List<Country> initializeData() throws IOException, ParseException;
}
