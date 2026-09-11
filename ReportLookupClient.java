package com.example.temporal.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/** Calls the report API exposed by bitoarch-qa-repo3. */
public class ReportLookupClient {

    private final HttpClient http = HttpClient.newHttpClient();

    /** GET /api/reports/{id} — served by ReportController in bitoarch-qa-repo3 */
    public String fetchReport(Long id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://bitoarch-qa-repo3/api/reports/" + id))
                .GET()
                .build();
        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
