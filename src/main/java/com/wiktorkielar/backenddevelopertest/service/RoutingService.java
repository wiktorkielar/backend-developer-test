package com.wiktorkielar.backenddevelopertest.service;

import com.wiktorkielar.backenddevelopertest.model.Path;
import net.minidev.json.parser.ParseException;

import java.io.IOException;

public interface RoutingService {
    Path getPath(String sourceCountry, String destinationCountry) throws IOException, ParseException;
}
