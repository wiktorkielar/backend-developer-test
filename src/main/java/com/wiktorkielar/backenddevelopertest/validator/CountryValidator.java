package com.wiktorkielar.backenddevelopertest.validator;

import com.wiktorkielar.backenddevelopertest.service.CountryDataInitializationService;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CountryValidator {

    private final CountryDataInitializationService countryDataInitializationService;

    public CountryValidator(CountryDataInitializationService countryDataInitializationService) {
        this.countryDataInitializationService = countryDataInitializationService;
    }

    public boolean isValid(String countryCode) throws IOException, ParseException {
        return countryDataInitializationService.initializeData().stream().anyMatch(country ->
                country.getCode().equals(countryCode)
        );
    }
}
