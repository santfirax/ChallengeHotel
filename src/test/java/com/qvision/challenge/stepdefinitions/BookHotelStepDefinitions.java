package com.qvision.challenge.stepdefinitions;

import com.qvision.challenge.models.BookingHotel;
import com.qvision.challenge.tasks.AdministradorTask;
import com.qvision.challenge.userinterface.DxHotelHome;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

import java.util.List;

import static com.qvision.challenge.questions.DxHotelQuestions.theDxHotelLogo;
import static com.qvision.challenge.questions.DxHotelQuestions.totalOfReservation;
import static com.qvision.challenge.tasks.AdministradorTask.bookNewHotel;
import static com.qvision.challenge.tasks.AdministradorTask.findCheapeasteHotel;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class BookHotelStepDefinitions {
    @Given("^that I am on DX HOTELS website$")
    public void thatIAmOnDXHOTELSWebsite() {
        theActorCalled("Carolina").wasAbleTo(Open.browserOn().the(DxHotelHome.class));
        theActorInTheSpotlight().should(seeThat(theDxHotelLogo(), is(equalTo("DXHotels"))));
    }

    @When("^I verify the fees of the client with reservation$")
    public void iVerifyTheFeesOfTheClientWithReservation(List<BookingHotel> reservations) {
        theActorInTheSpotlight().remember("reservation", reservations.get(0));
        theActorInTheSpotlight().attemptsTo(bookNewHotel(reservations.get(0)),
                findCheapeasteHotel());
    }


    @And("^I choose cheapest hotel$")
    public void iChooseCheapestHotel() {
        theActorInTheSpotlight().attemptsTo(AdministradorTask.chooseCheapestHotel());
    }

    @Then("^I should see how much I have to pay for the hotel$")
    public void iShouldSeeHowMuchIHaveToPayForTheHotel() {
        BookingHotel bookingHotel = theActorInTheSpotlight().recall("reservation");
        theActorInTheSpotlight().should(seeThat(totalOfReservation(bookingHotel), is(equalTo(true))));
    }


}
