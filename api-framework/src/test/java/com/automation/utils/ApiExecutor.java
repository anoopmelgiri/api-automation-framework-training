package com.automation.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.function.Supplier;

public class ApiExecutor {

    public static Response executeWithHandling(Supplier<Response> apiCall) {
        try {
            return apiCall.get();
        } catch (Exception e) {
            System.err.println("API Execution Failed: " + e.getMessage());
            throw e;
        }
    }
}

