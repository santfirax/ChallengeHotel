package com.qvision.challenge.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ResultsHotels {
    public static final Target TOTAL_TO_PAY = Target.the("total to pay").located(By.className("total-price"));
    public static final String PRICES_OF_HOTELS = "//p[@class='rate-number']";
    public static final Target PRICE_OF_HOTEL = Target.the("precios").locatedBy("//p[@class='rate-number']");
    public static final Target LEFT_BUTTON = Target.the("left button").locatedBy("//div[@class='switch switch-left']");
    public static final Target RIGHT_BUTTON = Target.the("left button").locatedBy("//div[@class='switch switch-right']");
    public static final Target CHEAPEST_HOTEL = Target.the("cheapest hotel").locatedBy("//P[@class='rate-number'][text()='${0}']/../..//SPAN[@class='dx-button-text'][text()='Book it'][text()='Book it']");

    private ResultsHotels() {
    }


}
