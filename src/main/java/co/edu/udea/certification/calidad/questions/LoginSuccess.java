package co.edu.udea.certification.calidad.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.edu.udea.certification.calidad.useriterfaces.UserPage.TEXT_VALIDATION_LOGIN;

public class LoginSuccess implements Question<Boolean> {

  private String validation;

  public LoginSuccess(String validation) {
    this.validation = validation;
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return TEXT_VALIDATION_LOGIN.resolveFor(actor).getText().equals(validation);
  }

  public static LoginSuccess withValidation(String validation) {
    return new LoginSuccess(validation);
  }
  
}
