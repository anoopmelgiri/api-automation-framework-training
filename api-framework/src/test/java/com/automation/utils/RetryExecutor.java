package com.automation.utils;

import io.restassured.response.Response;

import java.util.function.Supplier;

public class RetryExecutor {

    public static Response executeWithRetry(Supplier<Response> apiCall, int maxRetries) {

        int attempt = 0;
        Response response = null;

        while (attempt < maxRetries) {
            attempt++;
            response = apiCall.get();

            if (response.statusCode() < 500) {
                return response;
            }

            System.out.println("Retry attempt: " + attempt);
        }

        return response;
    }
}

