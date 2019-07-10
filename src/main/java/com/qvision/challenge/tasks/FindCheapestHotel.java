package com.qvision.challenge.tasks;

import com.qvision.challenge.models.BookingHotel;
import com.qvision.challenge.userinterface.ResultsHotels;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.qvision.challenge.questions.DxHotelQuestions.findCheapestHotel;
import static com.qvision.challenge.questions.DxHotelQuestions.thePricesOfHotels;

public class FindCheapestHotel implements Task {
    private final BookingHotel bookingHotel;
    private final int SHORT_TIME_TO_GET_TEXT = 500;

    protected FindCheapestHotel(BookingHotel bookingHotel) {
        this.bookingHotel = bookingHotel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Integer> cheapestPriceFromEachPage = new ArrayList<>();
       /* while (RIGHT_BUTTON.resolveFor(actor).isPresent()) {
            List<Integer> pricesOfHotels = new ArrayList<>();
            pricesOfHotels=actor.asksFor(DxHotelQuestions.thePricesOfHotels());
            PRICE_OF_HOTEL.resolveAllFor(actor).forEach(price -> pricesOfHotels.add(Integer.valueOf(price.getText().replace("$", ""))));
            cheapestPriceFromEachPage.add(Collections.min(pricesOfHotels));
            RIGHT_BUTTON.resolveFor(actor).click();
        }*/
        cheapestPriceFromEachPage = actor.asksFor(thePricesOfHotels());
        List<WebElementFacade> pricesElement = BrowseTheWeb.as(actor).findAll(By.xpath(ResultsHotels.PRICES_OF_HOTELS));
        actor.asksFor(findCheapestHotel(pricesElement));
        cheapestPriceFromEachPage.add(actor.recall("value_per_day"));
        cheapestPriceFromEachPage.forEach(System.out::println);
        Integer hotelDePrecioMasBajo = Collections.min(cheapestPriceFromEachPage);
        actor.remember("cheapestHotel", hotelDePrecioMasBajo);
    }


}
