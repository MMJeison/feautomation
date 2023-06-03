package co.edu.udea.certification.calidad.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.edu.udea.certification.calidad.useriterfaces.UserPage.*;

public class LoginFailedWrongInput implements Question<Boolean> {
    private String validation;
    public LoginFailedWrongInput(String validation){
        this.validation = validation;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return ERROR_CONTAINER.isVisibleFor(actor);
    }

    public static LoginFailedWrongInput withValidation(String validation) {
        return new LoginFailedWrongInput(validation);
    }
}
