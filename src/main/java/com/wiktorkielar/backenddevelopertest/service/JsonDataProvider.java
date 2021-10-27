package com.wiktorkielar.backenddevelopertest.service;

import java.io.IOException;

public interface JsonDataProvider {
    String getJsonData(String jsonUri) throws IOException;
}
