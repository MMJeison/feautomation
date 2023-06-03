package co.edu.udea.certification.calidad.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certification.calidad.useriterfaces.StudentCancellationsPage.SECTION_PENDING_CANCELLATIONS;


public class CancellationsToRequested implements Interaction{

    public CancellationsToRequested() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(SECTION_PENDING_CANCELLATIONS)
        );
    }
    
    public static CancellationsToRequested goToRequested() {
        return Tasks.instrumented(CancellationsToRequested.class);
    }
}
