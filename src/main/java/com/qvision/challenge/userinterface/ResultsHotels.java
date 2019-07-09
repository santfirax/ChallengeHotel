package com.qvision.challenge.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ResultsHotels {
    public static final Target TOTAL_TO_PAY = Target.the("total to pay").located(By.className("total-price"));

    private ResultsHotels() {
    }

    public static final String PRICES_OF_HOTELS = "//p[@class='rate-number']";
    public static final Target CHEAPEST_HOTEL = Target.the("cheapest hotel").locatedBy("(//div[@class='book-it gray-button dx-button dx-button-normal dx-button-mode-contained dx-widget dx-button-has-text'])['{0}']");

}
