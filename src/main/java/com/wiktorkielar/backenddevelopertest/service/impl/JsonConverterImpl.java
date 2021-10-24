package com.wiktorkielar.backenddevelopertest.service.impl;

import com.wiktorkielar.backenddevelopertest.model.Country;
import com.wiktorkielar.backenddevelopertest.service.JsonConverter;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonConverterImpl implements JsonConverter<Country> {
    @Override
    public List<Country> covertJSON(String httpEntity) throws ParseException {
        List<Country> countryList = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) new JSONParser(JSONParser.MODE_PERMISSIVE).parse(httpEntity);
        jsonArray.forEach(countryJSONObject -> {
            String name = (((JSONObject) countryJSONObject).get("cca3").toString());
            List<String> borders = new ArrayList<>();
            ((JSONArray) ((JSONObject) countryJSONObject).get("borders")).forEach(borderJSONObject -> borders.add(borderJSONObject.toString()));
            Country country = Country.builder()
                    .name(name)
                    .borders(borders)
                    .build();
            countryList.add(country);
        });
        return countryList;
    }
}
