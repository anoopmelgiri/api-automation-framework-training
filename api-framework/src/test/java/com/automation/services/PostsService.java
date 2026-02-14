package com.automation.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostsService {

    public Response getAllPosts(RequestSpecification requestSpec) {

        return requestSpec
                .when()
                .get("/posts");

    }
    public Response createPost(RequestSpecification requestSpec, String payload) {

    return requestSpec
            .body(payload)
            .when()
            .post("/posts");
    }
}

