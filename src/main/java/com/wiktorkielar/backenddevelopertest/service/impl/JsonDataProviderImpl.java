package com.wiktorkielar.backenddevelopertest.service.impl;

import com.wiktorkielar.backenddevelopertest.service.JsonDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class JsonDataProviderImpl implements JsonDataProvider {

    public String getJsonData(String jsonUri) throws IOException {
        log.info("Attempting to download countries JSON...");
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(jsonUri);
        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
        log.info("Countries JSON downloaded.");
        return EntityUtils.toString(closeableHttpResponse.getEntity());
    }
}
