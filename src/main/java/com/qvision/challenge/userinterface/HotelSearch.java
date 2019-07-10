package com.qvision.challenge.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class HotelSearch {
    private HotelSearch() {
    }
    public static final Target LOCATION_LIST = Target.the("location list").locatedBy("//div[@class='dx-first-row dx-first-col dx-last-col dx-field-item dx-col-0 dx-field-item-required dx-flex-layout dx-label-v-align']");
    public static final Target CHOOSE_LOCATION = Target.the("select {0}").locatedBy("//div[@class='dx-item-content dx-list-item-content' and contains(.,'{0}')]");
    public static final Target CHECK_IN = Target.the("check in from hotel search").locatedBy("//input[contains(@id,'checkIn')]");
    public static final Target CHECK_OUT = Target.the("checkout from hotel search").locatedBy("//input[contains(@id,'checkOut')]");
    public static final Target SEARCH_BUTTON = Target.the("search button").locatedBy("//div[@class='search main-color white-text dx-button dx-button-normal dx-button-mode-contained dx-widget dx-button-has-text']");

}
