package com.qvision.challenge.questions;

import com.google.common.collect.ImmutableList;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class FindCheapeasteHotel implements Question<Integer> {
    private final List<WebElementFacade> pricesElements;
    private List<Integer> prices = new ArrayList<>();
    private Integer cheapestValue;

    protected FindCheapeasteHotel(List<WebElementFacade> pricesElements) {
        this.pricesElements = ImmutableList.copyOf(pricesElements);
    }


    @Override
    public Integer answeredBy(Actor actor) {
        Consumer<WebElementFacade> getPrice = price -> this.prices.add(Integer.valueOf(price.getText().replace("$", "")));
        pricesElements.forEach(getPrice);
        this.cheapestValue = Collections.min(prices);
        actor.remember("value_per_day", cheapestValue);
        return prices.indexOf(cheapestValue);
    }
}
