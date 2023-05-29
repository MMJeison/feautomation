package co.edu.udea.certification.calidad.stepdefinitions;

import co.edu.udea.certification.calidad.questions.LoginSuccess;
import co.edu.udea.certification.calidad.tasks.LoginInThePlatform;
import co.edu.udea.certification.calidad.useriterfaces.UserPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Cucumber.class)
public class LoginSuccessStepDefinitions {
    @Managed(driver = "chrome")
    public WebDriver driver;
    private Actor student = Actor.named("pepito");
    private UserPage userPage;

    @Before
    public void setUp(){
        driver.manage().window().maximize();
        userPage = new UserPage();
        student.can(BrowseTheWeb.with(driver));
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage(){
        student.attemptsTo(Open.browserOn(userPage));
    }

    @When("I enter my username and password")
    public void iEnterMyUsernameAndPassword(){
        String username = "sara.duque";
        String password = "contrasena5";
        student.attemptsTo(
                LoginInThePlatform.withCredentials(username, password)
        );
    }

    @Then("I should be able to access the platform")
    public void iShouldBeAbleToAccessThePlatform(){
        String expectedMessage = "Cancelación de curso";
        student.should(
                seeThat(LoginSuccess.withValidation(expectedMessage), equalTo(true))
        );
    }
}
