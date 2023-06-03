package co.edu.udea.certification.calidad.stepdefinitions;

import co.edu.udea.certification.calidad.questions.LoginFailedWrongInput;
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
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import co.edu.udea.certification.calidad.stepdefinitions.LoginSuccessStepDefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Cucumber.class)
public class LoginErrorWrongInputStepDefinitions {
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

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I am on the login page 2")
    public void studentIsOnTheLoginPage(){
        //student.iAmOnTheLoginPage();
        student.attemptsTo(Open.browserOn(userPage));
    }

    @When("I enter a wrong username and a password")
    public void iEnterMyUsernameAndPassword(){
        String username = "pepito.perez";
        String password = "contrasena3";
        student.attemptsTo(
                LoginInThePlatform.withCredentials(username, password)
        );
    }

    @Then("I should see an error message showing that the input fields are wrong")
    public void iShouldBeAbleToAccessThePlatform() throws  InterruptedException{
        Thread.sleep(2000);
        String expectedMessage = "Usuario o contrase";
        student.should(
                seeThat(LoginFailedWrongInput.withValidation(expectedMessage), equalTo(true))
        );

    }
}
