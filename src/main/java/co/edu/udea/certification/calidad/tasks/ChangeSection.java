package co.edu.udea.certification.calidad.tasks;

import co.edu.udea.certification.calidad.interactions.CancellationsToRequested;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ChangeSection implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            CancellationsToRequested.goToRequested()
        );
    }

    public static ChangeSection toRequestedCancellations() {
        return Tasks.instrumented(ChangeSection.class);
    }
    
}
