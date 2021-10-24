package com.wiktorkielar.backenddevelopertest.service;

import com.wiktorkielar.backenddevelopertest.model.Route;
import net.minidev.json.parser.ParseException;

import java.io.IOException;

public interface RoutingService {
    Route getRoute(String sourceCountry, String destinationCountry) throws IOException, ParseException;
}
