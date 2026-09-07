package com.example.demo.client;

import java.net.URI;
import java.net.http.*;

/** Added 164526. Calls the audit endpoint in utkarshbito/testing-bito. */
public class AuditApiClient {
    private final HttpClient http = HttpClient.newHttpClient();

    /** GET http://testing-bito/api/audit/{id} */
    public String fetchAudit(Long id) throws Exception {
        HttpRequest r = HttpRequest.newBuilder()
                .uri(URI.create("http://testing-bito/api/audit/" + id)).GET().build();
        return http.send(r, HttpResponse.BodyHandlers.ofString()).body();
    }
}
