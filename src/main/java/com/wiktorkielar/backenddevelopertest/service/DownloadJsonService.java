package com.wiktorkielar.backenddevelopertest.service;

import java.io.IOException;

public interface DownloadJsonService {
    String downloadJSON(String jsonUri, String jsonType) throws IOException;
}
