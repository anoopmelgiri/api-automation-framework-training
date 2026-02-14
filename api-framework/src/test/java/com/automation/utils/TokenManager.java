package com.automation.utils;

import com.automation.services.AuthService;

public class TokenManager {

    private static volatile String token;
    private static volatile long expiryTime;

    public static synchronized String getToken() {

        if (token == null || isTokenExpired()) {
        AuthService authService = new AuthService();
        token = authService.generateToken();
        expiryTime = System.currentTimeMillis() + (5 * 60 * 1000);
        }
        return token;
    }

    private static boolean isTokenExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}

