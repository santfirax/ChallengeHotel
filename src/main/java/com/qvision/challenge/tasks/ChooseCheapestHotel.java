package com.qvision.challenge.tasks;

import com.qvision.challenge.userinterface.ResultsHotels;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.qvision.challenge.userinterface.ResultsHotels.CHEAPEST_HOTEL;

public class ChooseCheapestHotel implements Task {
    protected ChooseCheapestHotel() {
    }

    @Step("{0} choose cheapest Hotel")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Integer cheapestHotel = actor.recall("cheapestHotel");
        while ((!CHEAPEST_HOTEL.of(String.valueOf(cheapestHotel)).resolveFor(actor).isPresent())) {
            actor.attemptsTo(Click.on(ResultsHotels.LEFT_BUTTON));
        }
        actor.attemptsTo(Click.on(CHEAPEST_HOTEL.of(String.valueOf(cheapestHotel))));
    }
}
