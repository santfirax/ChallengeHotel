package com.qvision.challenge.questions;

import com.qvision.challenge.userinterface.ResultsHotels;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TotalToPay implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ResultsHotels.TOTAL_TO_PAY).viewedBy(actor).asString().replace("$", "").replace(".00", "");
    }
}
