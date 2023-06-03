package co.edu.udea.certification.calidad.tasks;

import co.edu.udea.certification.calidad.interactions.RegisterCancelationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class RegisterCancelation implements Task {

    private String justification;

    public RegisterCancelation(String justification) {
        this.justification = justification;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            RegisterCancelationPage.withJustification(justification)
        );
    }

    public static RegisterCancelation withJustification(String justification) {
        return Tasks.instrumented(RegisterCancelation.class, justification);
    }
    
}
