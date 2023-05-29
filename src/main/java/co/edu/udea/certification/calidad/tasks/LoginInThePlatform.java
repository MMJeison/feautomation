package co.edu.udea.certification.calidad.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import co.edu.udea.certification.calidad.interactions.LoginPage;

public class LoginInThePlatform implements Task {

  private String username;
  private String password;

  public LoginInThePlatform(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        LoginPage.login(username, password)
    );
  }

  public static LoginInThePlatform withCredentials(String username, String password) {
    return Tasks.instrumented(LoginInThePlatform.class, username, password);
  }
  
}
