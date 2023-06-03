package co.edu.udea.certification.calidad.questions;

import org.openqa.selenium.Alert;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ErrorAlert implements Question<Boolean>{

    String errorMessage;

    public ErrorAlert(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Alert alert = actor.usingAbilityTo(BrowseTheWeb.class).getDriver().switchTo().alert();
        return isAlertVisible(alert);
    }

    private boolean isAlertVisible(Alert alert) {
        try {
            // Si intentas interactuar con la alerta y no se lanza una excepción,
            // se considera que la alerta está visible
            alert.getText();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static ErrorAlert isDisplayed(String errorMessage) {
        return new ErrorAlert(errorMessage);
    }
    
}
