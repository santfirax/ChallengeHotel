package com.qvision.challenge.utils.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.drawTheCurtain;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class BookHotelHook {
    @Before
    public void init() {
        setTheStage(new OnlineCast());
    }

    @After
    public void tearDown() {
        drawTheCurtain();
    }
}
