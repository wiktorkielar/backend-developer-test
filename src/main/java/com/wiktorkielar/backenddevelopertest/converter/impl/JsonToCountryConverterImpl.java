package com.wiktorkielar.backenddevelopertest.converter.impl;

import com.wiktorkielar.backenddevelopertest.converter.JsonToCountryConverter;
import com.wiktorkielar.backenddevelopertest.model.Country;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonToCountryConverterImpl implements JsonToCountryConverter {
    @Override
    public List<Country> convert(String httpEntity) throws ParseException {
        List<Country> countryList = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) new JSONParser(JSONParser.MODE_PERMISSIVE).parse(httpEntity);
        jsonArray.forEach(countryJSONObject -> {
            String code = (((JSONObject) countryJSONObject).get("cca3").toString());
            List<String> borders = new ArrayList<>();
            ((JSONArray) ((JSONObject) countryJSONObject).get("borders")).forEach(borderJSONObject ->
                    borders.add(borderJSONObject.toString()));
            Country country = Country.builder()
                    .code(code)
                    .borders(borders)
                    .build();
            countryList.add(country);
        });
        return countryList;
    }
}
