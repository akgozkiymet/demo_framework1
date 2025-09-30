package com.demo.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class LoginAPI {
    @Given("the API base URL")
    public void the_api_base_url() {

    }
    @When("a POST request is sent with following login info:")
    public void a_post_request_is_sent_with_following_login_info(Map<String, String> credentials) {

    }

    @Then("response message should be {string}")
    public void response_message_should_be(String message) {

    }
    @Then("response status code should be {int}")
    public void response_status_code_should_be(Integer statusCode) {

    }
    @When("a DELETE request is sent to {string}")
    public void a_delete_request_is_sent_to(String endpoint) {

    }
}
