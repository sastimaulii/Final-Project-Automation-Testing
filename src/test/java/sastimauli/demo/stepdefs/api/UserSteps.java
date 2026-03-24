package sastimauli.demo.stepdefs.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class UserSteps {
    private RequestSpecification request;
    private Response response;
    private final String BASE_URL = "https://dummyapi.io/data/v1";

    @Given("I have a valid app-id {string}")
    public void iHaveAValidAppId(String appId) {
        // Menyimpan app-id ke dalam header
        request = given()
                .header("app-id", appId)
                .contentType("application/json");
    }

    @When("I send a GET request to user with ID {string}")
    public void iSendAGetRequestToUserWithID(String userId) {
        response = request.when()
                .get(BASE_URL + "/user/" + userId);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @And("the response should contain the user's firstName and lastName")
    public void theResponseShouldContainFirstNameAndLastName() {
        // Validasi response body
        String firstName = response.jsonPath().getString("firstName");
        String lastName = response.jsonPath().getString("lastName");

        Assert.assertNotNull(firstName, "FirstName should not be null");
        Assert.assertNotNull(lastName, "LastName should not be null");

        System.out.println("User Found: " + firstName + " " + lastName);
    }
}