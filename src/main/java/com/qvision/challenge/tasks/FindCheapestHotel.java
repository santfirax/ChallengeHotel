package com.qvision.challenge.tasks;

import com.qvision.challenge.userinterface.ResultsHotels;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.Collections;
import java.util.List;

import static com.qvision.challenge.questions.DxHotelQuestions.findCheapestHotel;
import static com.qvision.challenge.questions.DxHotelQuestions.thePricesOfHotels;

public class FindCheapestHotel implements Task {

    protected FindCheapestHotel() {
    }

    @Step("{0} find cheapest hotel")
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Integer> cheapestPriceFromEachPage;
        cheapestPriceFromEachPage = actor.asksFor(thePricesOfHotels());
        List<WebElementFacade> pricesElement = BrowseTheWeb.as(actor).findAll(By.xpath(ResultsHotels.PRICES_OF_HOTELS));
        actor.asksFor(findCheapestHotel(pricesElement));
        cheapestPriceFromEachPage.add(actor.recall("value_per_day"));
        Integer hotelDePrecioMasBajo = Collections.min(cheapestPriceFromEachPage);
        actor.remember("cheapestHotel", hotelDePrecioMasBajo);
    }


}
