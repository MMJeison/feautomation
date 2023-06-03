package co.edu.udea.certification.calidad.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certification.calidad.useriterfaces.StudentCancellationsPage.CHECK_BOX_COURSE;
import static co.edu.udea.certification.calidad.useriterfaces.StudentCancellationsPage.INPUT_REASON_FIELD;
import static co.edu.udea.certification.calidad.useriterfaces.StudentCancellationsPage.BUTTON_SEND_REQUEST;

public class RegisterCancelationPage implements Interaction {

    private String justification;

    public RegisterCancelationPage(String justification) {
        this.justification = justification;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(CHECK_BOX_COURSE),
            Enter.theValue(justification).into(INPUT_REASON_FIELD),
            Click.on(BUTTON_SEND_REQUEST)
        );
    }

    public static RegisterCancelationPage withJustification(String justification) {
        return Tasks.instrumented(RegisterCancelationPage.class, justification);
    }
    
}
