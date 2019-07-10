package com.qvision.challenge.tasks;

import com.qvision.challenge.userinterface.ResultsHotels;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ChooseCheapestHotel implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
//        Integer cheapestHotel = actor.recall("cheapestHotel");
        Integer cheapestHotel = 299;
        while ( (!ResultsHotels.PRICE_OF_CHEAPEST_HOTEL.of(String.valueOf(cheapestHotel)).resolveFor(actor).isPresent())&& (ResultsHotels.LEFT_BUTTON.resolveFor(actor).isEnabled())) {
            actor.attemptsTo(Click.on(ResultsHotels.LEFT_BUTTON));
        }
        actor.attemptsTo(Click.on(ResultsHotels.CHEAPEST_HOTEL.of(String.valueOf(cheapestHotel))));
    }
}
