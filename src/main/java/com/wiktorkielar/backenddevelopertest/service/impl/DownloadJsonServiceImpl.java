package com.wiktorkielar.backenddevelopertest.service.impl;

import com.wiktorkielar.backenddevelopertest.service.DownloadJsonService;
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
public class DownloadJsonServiceImpl implements DownloadJsonService {

    public String downloadJSON(String jsonUri, String jsonType) throws IOException {
        log.info("Attempting to download " + jsonType + " JSON...");
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(jsonUri);
        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
        log.info(jsonType + "Countries JSON downloaded.");
        return EntityUtils.toString(closeableHttpResponse.getEntity());
    }
}
