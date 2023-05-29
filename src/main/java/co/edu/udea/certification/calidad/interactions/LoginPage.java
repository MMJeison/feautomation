package co.edu.udea.certification.calidad.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static co.edu.udea.certification.calidad.useriterfaces.UserPage.INPUT_PASSWORD;
import static co.edu.udea.certification.calidad.useriterfaces.UserPage.INPUT_USERNAME;
import static co.edu.udea.certification.calidad.useriterfaces.UserPage.BUTTON_LOGIN;

public class LoginPage implements Interaction {

  private String username;
  private String password;

  public LoginPage(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(username).into(INPUT_USERNAME),
        Enter.theValue(password).into(INPUT_PASSWORD),
        Click.on(BUTTON_LOGIN)
    );
  }

  public static LoginPage login(String username, String password) {
    return Tasks.instrumented(LoginPage.class, username, password);
  }
  
}
