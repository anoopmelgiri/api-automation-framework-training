package com.automation.tests;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;
import com.automation.utils.RetryExecutor;
import com.automation.base.BaseTest;
import com.automation.services.PostsService;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetPostsTest extends BaseTest {

    private PostsService postsService = new PostsService();

    @Test
    public void verifyGetPostsAPI_1() {

        Response response = RetryExecutor.executeWithRetry(
        () -> postsService.getAllPosts(buildRequestSpec()),3);

        response.then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("posts-schema.json"))
                .header("Content-Type", containsString("application/json"))
                .header("Server", notNullValue());
    }

    @Test
    public void verifyGetPostsAPI_2() {

        Response response = RetryExecutor.executeWithRetry(
        () -> postsService.getAllPosts(buildRequestSpec()),3);

        response.then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("posts-schema.json"))
                .header("Content-Type", containsString("application/json"))
                .header("Server", notNullValue());
    }

    @Test
    public void verifyGetPostsAPI_3() {

        Response response = RetryExecutor.executeWithRetry(
        () -> postsService.getAllPosts(buildRequestSpec()),3);

        response.then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("posts-schema.json"))
                .header("Content-Type", containsString("application/json"))
                .header("Server", notNullValue());
    }    
}
