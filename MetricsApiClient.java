package com.example.demo.client;

import java.net.URI;
import java.net.http.*;

/** Added for BITO-14304 index-delta validation. Calls the metrics endpoints in utkarshbito/testing-bito. */
public class MetricsApiClient {
    private final HttpClient http = HttpClient.newHttpClient();

    /** GET http://testing-bito/api/metrics/uptime */
    public String fetchUptime() throws Exception {
        HttpRequest r = HttpRequest.newBuilder()
                .uri(URI.create("http://testing-bito/api/metrics/uptime")).GET().build();
        return http.send(r, HttpResponse.BodyHandlers.ofString()).body();
    }

    /** GET http://testing-bito/api/metrics/requests */
    public String fetchRequestCount() throws Exception {
        HttpRequest r = HttpRequest.newBuilder()
                .uri(URI.create("http://testing-bito/api/metrics/requests")).GET().build();
        return http.send(r, HttpResponse.BodyHandlers.ofString()).body();
    }
}
