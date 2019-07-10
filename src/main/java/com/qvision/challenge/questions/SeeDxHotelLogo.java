package com.qvision.challenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class SeeDxHotelLogo implements Question<String> {
    protected SeeDxHotelLogo() {
    }

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).getTitle();
    }
}
