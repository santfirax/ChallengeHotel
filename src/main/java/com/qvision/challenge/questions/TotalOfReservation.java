package com.qvision.challenge.questions;

import com.qvision.challenge.models.BookingHotel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TotalOfReservation implements Question<Boolean> {
    private final BookingHotel bookingHotel;

    protected TotalOfReservation(BookingHotel bookingHotel) {
        this.bookingHotel = bookingHotel;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        long days = actor.asksFor(DxHotelQuestions.findDaysBetweenCheckInAndCheckOut(bookingHotel));
        days += 1;
        Integer cheapestHotel = actor.recall("cheapestHotel");
        Integer totalToPay = Math.toIntExact(days * cheapestHotel);
        Integer valueToPay = Integer.valueOf(actor.asksFor(DxHotelQuestions.totalToPay()));
        return totalToPay.equals(valueToPay);
    }
}
