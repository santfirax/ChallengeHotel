package com.qvision.challenge.tasks;

import com.qvision.challenge.models.BookingHotel;
import com.qvision.challenge.userinterface.ResultsHotels;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

import java.util.List;

import static com.qvision.challenge.questions.DxHotelQuestions.*;
import static com.qvision.challenge.userinterface.ResultsHotels.CHEAPEST_HOTEL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class ChooseCheapestHotel implements Task {
    private final BookingHotel bookingHotel;

    protected ChooseCheapestHotel(BookingHotel bookingHotel) {
        this.bookingHotel = bookingHotel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> pricesElement = BrowseTheWeb.as(actor).findAll(By.xpath(ResultsHotels.PRICES_OF_HOTELS));
        Integer hotel = actor.asksFor(findCheapestHotel(pricesElement));
        actor.attemptsTo(Click.on(CHEAPEST_HOTEL.of(String.valueOf(hotel))));
        long days = actor.asksFor(findDaysBetweenCheckInAndCheckOut(bookingHotel));
        days += 1;
        Integer valueOfNightInHotel = actor.recall("value_per_day");
        System.out.println("*****VALOR TOTAL*****");
        System.out.println(days * valueOfNightInHotel);
        String totalToPay = String.valueOf(days * valueOfNightInHotel);
        actor.should(seeThat(totalToPay(), is(equalTo(totalToPay))));
    }
}
