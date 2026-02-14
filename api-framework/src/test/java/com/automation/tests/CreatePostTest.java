package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.services.PostsService;
import com.automation.utils.JsonReader;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import com.automation.utils.ConfigReader;


public class CreatePostTest extends BaseTest {

    private PostsService postsService = new PostsService();

    @Test
    public void verifyCreatePostAPI() {

        String payload = JsonReader.readJson("postPayload.json");

        Response response = postsService.createPost(
            buildRequestSpec(),
            payload
        );

        response.then()
                .log().all()
                .statusCode(201);
    }

    @Test(enabled = false)
    public void verifyCreatePostWithEmptyPayload() {

        Response response = postsService.createPost(
                buildRequestSpec(),
                ""
        );

        response.then()
                .statusCode(org.hamcrest.Matchers.anyOf(
                        org.hamcrest.Matchers.equalTo(400),
                        org.hamcrest.Matchers.equalTo(422)
                ));
    }
    @Test(enabled = false)
    public void verifyCreatePostWithoutAuthorization() {

        RequestSpecification requestSpecWithoutAuth = RestAssured.given()
                .baseUri(ConfigReader.getProperty("base.url"))
                .header("Content-Type", "application/json");

        String payload = JsonReader.readJson("postPayload.json");

        Response response = postsService.createPost(
                requestSpecWithoutAuth,
                payload
        );

        response.then()
            .statusCode(org.hamcrest.Matchers.anyOf(
                    org.hamcrest.Matchers.equalTo(401),
                    org.hamcrest.Matchers.equalTo(403)
            ));
    }

    @Test(enabled = false)
    public void verifyInvalidEndpoint() {

        Response response = buildRequestSpec()
                .when()
                .get("/invalid-endpoint");

        response.then()
                .statusCode(404);
    }

}
