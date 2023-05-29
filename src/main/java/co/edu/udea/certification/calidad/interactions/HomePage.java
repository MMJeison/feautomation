package co.edu.udea.certification.calidad.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certification.calidad.useriterfaces.UserPage.BUTTON_ESTUDIANTES;

public class HomePage implements Interaction {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(BUTTON_ESTUDIANTES)
    );
  }

  public static HomePage clickButtonEstudiantes() {
    return Tasks.instrumented(HomePage.class);
  }
  
}
