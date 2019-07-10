package com.qvision.challenge.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.qvision.challenge.userinterface.ResultsHotels.PRICE_OF_HOTEL;
import static com.qvision.challenge.userinterface.ResultsHotels.RIGHT_BUTTON;

public class FindPriceOfHotels implements Question<List<Integer>> {
    private final int SHORT_TIME_TO_GET_TEXT = 500;


    @Override
    public List<Integer> answeredBy(Actor actor) {
        List<Integer> cheapestPriceFromEachPage = new ArrayList<>();
        while (RIGHT_BUTTON.resolveFor(actor).isPresent()) {
            List<Integer> pricesOfHotels = new ArrayList<>();
            waitAShorTime();
            PRICE_OF_HOTEL.resolveAllFor(actor).forEach(price -> pricesOfHotels.add(Integer.valueOf(price.getText().replace("$", ""))));
            cheapestPriceFromEachPage.add(Collections.min(pricesOfHotels));
            RIGHT_BUTTON.resolveFor(actor).click();
        }
        return cheapestPriceFromEachPage;
    }

    private void waitAShorTime() {
        /*se agrega este tiempo de espera dado que cuando cambia de pagina lo hace muy rapido y no alcanza a guardar todos los precios en la lista*/
        try {
            Thread.sleep(this.SHORT_TIME_TO_GET_TEXT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
