package com.qvision.challenge.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@CucumberOptions(
        features = "src//test//resources//features//booking_cheapest_hotel.feature",
        glue = {"com.qvision.challenge.stepdefinitions", "com.qvision.challenge.utils.hooks"},
        snippets = CAMELCASE
)
@RunWith(CucumberWithSerenity.class)
public class BookHotelRunner {
}
