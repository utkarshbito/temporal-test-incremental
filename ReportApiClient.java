package com.example.temporal.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/** Reporting client. Calls the user service in testing-bito. */
public class ReportApiClient {

    private final HttpClient http = HttpClient.newHttpClient();

    /** GET /api/users — served by UserController.getAllUsers */
    public String listUsersForReport() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://testing-bito/api/users"))
                .GET()
                .build();
        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
