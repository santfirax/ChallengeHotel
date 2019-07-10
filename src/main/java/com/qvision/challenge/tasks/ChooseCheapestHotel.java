package com.qvision.challenge.tasks;

import com.qvision.challenge.userinterface.ResultsHotels;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class ChooseCheapestHotel implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        Integer cheapestHotel = actor.recall("cheapestHotel");
        Target hotel = Target.the("hotel").locatedBy("//P[@class='rate-number'][text()='${0}']/../..//SPAN[@class='dx-button-text'][text()='Book it'][text()='Book it']");
        while ((!hotel.of(String.valueOf(cheapestHotel)).resolveFor(actor).isPresent())) {
            actor.attemptsTo(Click.on(ResultsHotels.LEFT_BUTTON));
        }
        actor.attemptsTo(Scroll.to(hotel.of(String.valueOf(cheapestHotel))));
        actor.attemptsTo(Click.on(hotel.of(String.valueOf(cheapestHotel))));
    }
}
