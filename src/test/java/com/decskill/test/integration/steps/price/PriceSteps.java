package com.decskill.test.integration.steps.price;

import com.decskill.test.integration.CucumberSpringBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PriceSteps extends CucumberSpringBase {

    public static final String PRICE_RESPONSE_JSON_PATH = "src/test/resources/fixtures/price/";
    @LocalServerPort
    int port;
    private Response response;
    private PriceRequest request;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Then("The system throws an error and responds with status {int}")
    public void theSystemThrowsAnErrorAndRespondsWithStatus(int statusCode) {
        response.then()
                .statusCode(statusCode);
    }

    @When("I query the price")
    public void iQueryThePrice() {
        response = given()
                .get("/api/v1/price?date={date}&productId={productId}&brandId={brandId}",
                        request.date(),
                        request.productId(),
                        request.brandId());
    }

    @Given("A {string}, {string} and {string}")
    public void aProductIdBrandIdAndDate(String productId, String brandId, String date) {
        request = new PriceRequest(productId, brandId, date);
    }

    @Then("I get the price response {string} with status {string}")
    public void iGetThePriceResponseJsonWithStatusStatus(String jsonFileName, String status) {
        var expectedJson = new JsonPath(new File(PRICE_RESPONSE_JSON_PATH + jsonFileName));

        response.then()
                .assertThat()
                .statusCode(Integer.parseInt(status))
                .body("", equalTo(expectedJson.getMap("")));
    }
}