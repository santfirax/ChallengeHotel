package com.qvision.challenge.tasks;

import com.qvision.challenge.models.BookingHotel;
import com.qvision.challenge.userinterface.ResultsHotels;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.qvision.challenge.questions.DxHotelQuestions.findCheapestHotel;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class FindCheapestHotel implements Task {
    private final BookingHotel bookingHotel;

    protected FindCheapestHotel(BookingHotel bookingHotel) {
        this.bookingHotel = bookingHotel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Integer> precioMasBajoDeCadaPagina = new ArrayList<>();
        Target flecha = Target.the("flecha").locatedBy("//div[@class='switch switch-right']");
        Target preciosOtros = Target.the("precios").locatedBy("//p[@class='rate-number']");
        while (flecha.resolveFor(actor).isPresent()) {
            List<Integer> preciosBajos = new ArrayList<>();
            actor.attemptsTo(WaitUntil.the(preciosOtros, isPresent()));
            preciosOtros.resolveAllFor(actor).forEach(precio -> System.out.println(precio.getText()));
            preciosOtros.resolveAllFor(actor).forEach(precio -> preciosBajos.add(Integer.valueOf(precio.getText().replace("$", ""))));
            precioMasBajoDeCadaPagina.add(Collections.min(preciosBajos));
            preciosBajos.clear();
            flecha.resolveFor(actor).click();

        }
        List<WebElementFacade> pricesElement = BrowseTheWeb.as(actor).findAll(By.xpath(ResultsHotels.PRICES_OF_HOTELS));
        Integer hotel = actor.asksFor(findCheapestHotel(pricesElement));
        precioMasBajoDeCadaPagina.add(actor.recall("value_per_day"));
        System.out.println("*****PRECIO MAS BAJO DE CADA PAGINA***************");
        precioMasBajoDeCadaPagina.forEach(System.out::println);
        System.out.println("****** PRECIO MAS BAJO EN TODAS LAS PAGINAS*********");
        Integer hotelDePrecioMasBajo = Collections.min(precioMasBajoDeCadaPagina);
        actor.remember("cheapestHotel", hotelDePrecioMasBajo);
        System.out.println(hotelDePrecioMasBajo);
        System.out.println("*********EL HOTEL CON EL PRECIO MAS BAJO SE ENCUENTRA EN LA PAGINA***************");
        System.out.print(precioMasBajoDeCadaPagina.indexOf(hotelDePrecioMasBajo));
//  actor.attemptsTo(Click.on(CHEAPEST_HOTEL.of(String.valueOf(hotel))));
//        long days = actor.asksFor(findDaysBetweenCheckInAndCheckOut(bookingHotel));
//        days += 1;
//        Integer valueOfNightInHotel = actor.recall("value_per_day");
//        String totalToPay = String.valueOf(days * valueOfNightInHotel);
//        actor.should(seeThat(totalToPay(), is(equalTo(totalToPay))));
    }
}
