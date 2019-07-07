package com.qvision.challenge.questions;

import com.qvision.challenge.models.BookingHotel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.concurrent.TimeUnit.DAYS;

public class FindDaysBetweenCheckInAndCheckOut implements Question<Long> {
    private final BookingHotel bookingHotel;

    protected FindDaysBetweenCheckInAndCheckOut(BookingHotel bookingHotel) {
        this.bookingHotel = bookingHotel;
    }


    @Override
    public Long answeredBy(Actor actor) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyy");
        LocalDate checkIn = LocalDate.parse(bookingHotel.getCheckIn(), formatter);
        LocalDate checkOut = LocalDate.parse(bookingHotel.getCheckOut(), formatter);
        return DAYS.toChronoUnit().between(checkIn, checkOut);
    }
}
