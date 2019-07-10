package com.qvision.challenge.tasks;

import com.qvision.challenge.models.BookingHotel;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.qvision.challenge.userinterface.HotelSearch.*;

public class AdministradorTask {

    public static Task bookNewHotel(BookingHotel bookingHotel) {
        return Task.where("{0} book a new hotel", Click.on(LOCATION_LIST), Click.on(CHOOSE_LOCATION.of(bookingHotel.getLocation())),
                Enter.theValue(bookingHotel.getCheckIn()).into(CHECK_IN), Click.on(CHECK_OUT), Clear.field(CHECK_OUT), Enter.theValue(bookingHotel.getCheckOut()).into(CHECK_OUT),
                Click.on(SEARCH_BUTTON));
    }

    public static Task findCheapeasteHotel() {
        return new FindCheapestHotel();
    }

    public static Task chooseCheapestHotel() {
        return new ChooseCheapestHotel();
    }
}
