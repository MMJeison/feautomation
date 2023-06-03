package co.edu.udea.certification.calidad.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.edu.udea.certification.calidad.useriterfaces.StudentCancellationsPage.PENDING_CANCELATIONS_ROW;

public class RequestedCancellations implements Question<Boolean>{

    @Override
    public Boolean answeredBy(Actor actor) {
        return PENDING_CANCELATIONS_ROW.isVisibleFor(actor);
    }
    
    public static RequestedCancellations isDisplayed() {
        return new RequestedCancellations();
    }
}
