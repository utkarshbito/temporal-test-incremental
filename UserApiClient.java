package com.example.temporal.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Calls the user service exposed by the testing-bito repository.
 *
 * The endpoints below are declared by UserController in that repository
 * (@RequestMapping("/api/users")), so these calls are cross-repository
 * references rather than local ones.
 */
public class UserApiClient {

    private static final String USER_SERVICE_BASE_URL = "http://testing-bito/api/users";

    private final HttpClient http = HttpClient.newHttpClient();

    /** GET /api/users/{id} — served by UserController.getUserById */
    public String getUserById(Long id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USER_SERVICE_BASE_URL + "/" + id))
                .GET()
                .build();
        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    /** GET /api/users — served by UserController.getAllUsers */
    public String getAllUsers() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USER_SERVICE_BASE_URL))
                .GET()
                .build();
        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    /** POST /api/users — served by UserController.createUser */
    public String createUser(String userJson) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USER_SERVICE_BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(userJson))
                .build();
        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    /** DELETE /api/users/{id} — served by UserController.deleteUser */
    public int deleteUser(Long id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USER_SERVICE_BASE_URL + "/" + id))
                .DELETE()
                .build();
        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }
}
