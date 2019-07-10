package com.qvision.challenge.questions;

import com.qvision.challenge.interactions.FindPriceOfHotels;
import com.qvision.challenge.models.BookingHotel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class DxHotelQuestions {
    public static Question<String> theDxHotelLogo() {
        return new SeeDxHotelLogo();
    }

    public static Question<Integer> findCheapestHotel(List<WebElementFacade> pricesElement) {
        return new FindCheapeasteHotel(pricesElement);
    }

    public static Question<Long> findDaysBetweenCheckInAndCheckOut(BookingHotel bookingHotel) {
        return new FindDaysBetweenCheckInAndCheckOut(bookingHotel);
    }
    public static Question<String> totalToPay(){
        return new TotalToPay();
    }

    public static Question<List<Integer>> thePricesOfHotels() {
        return new FindPriceOfHotels();
    }
}
