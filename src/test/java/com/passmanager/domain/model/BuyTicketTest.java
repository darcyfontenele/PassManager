package com.passmanager.domain.model;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyTicketTest {

    boolean value;
    PassCard passcard;

    @Given("^I have (\\d+) in my bank$")
    public void i_have_in_my_bank(int num) throws Throwable {
        passcard = new PassCard(num);
    }

    @When("^I buy a \"([^\"]*)\" ticket$")
    public void i_buy_a_ticket(FareEnum type) throws Throwable {
        value = passcard.chargeFare(type);
    }

    @Then("System return success or fail (true|false)")
    public void system_return_fail_status(boolean status) throws Throwable {
        assertEquals(status, value);
    }
}
