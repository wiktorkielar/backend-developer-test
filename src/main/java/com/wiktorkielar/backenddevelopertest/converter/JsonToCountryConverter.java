package com.wiktorkielar.backenddevelopertest.converter;

import com.wiktorkielar.backenddevelopertest.model.Country;
import net.minidev.json.parser.ParseException;

import java.util.List;

public interface JsonToCountryConverter {
    List<Country> convert(String httpEntity) throws ParseException;
}
