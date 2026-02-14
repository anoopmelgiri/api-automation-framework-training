package com.automation.base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.automation.utils.ConfigReader;
import com.automation.utils.TokenManager;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    protected RequestSpecification buildRequestSpec() {
        return RestAssured.given()
                .baseUri(ConfigReader.getProperty("base.url"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + TokenManager.getToken());
    }
}
