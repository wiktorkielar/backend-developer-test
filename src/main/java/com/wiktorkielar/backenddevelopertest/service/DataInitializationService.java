package com.wiktorkielar.backenddevelopertest.service;

import com.wiktorkielar.backenddevelopertest.model.Country;
import net.minidev.json.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface DataInitializationService {
    List<Country> initializeData() throws IOException, ParseException;
}
