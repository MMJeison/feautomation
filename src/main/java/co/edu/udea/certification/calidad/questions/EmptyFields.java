package co.edu.udea.certification.calidad.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.edu.udea.certification.calidad.useriterfaces.UserPage.INPUT_PASSWORD;
import static co.edu.udea.certification.calidad.useriterfaces.UserPage.INPUT_USERNAME;

public class EmptyFields implements Question<Boolean> {
  private String message;

  public EmptyFields(String message) {
    this.message = message;
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    // validamos que el input contenga el warnin con el mensaje "complete this field"
    Boolean res =  INPUT_USERNAME.resolveFor(actor).getAttribute("validationMessage").equals(message) ||
            INPUT_PASSWORD.resolveFor(actor).getAttribute("validationMessage").equals(message);
    System.out.println(res);
    return res;
  }

  public static EmptyFields withMessage(String message) {
    return new EmptyFields(message);
  }
  
}
