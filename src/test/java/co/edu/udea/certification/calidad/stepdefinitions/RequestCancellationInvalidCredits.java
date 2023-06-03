package co.edu.udea.certification.calidad.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.After;
import io.cucumber.junit.Cucumber;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import co.edu.udea.certification.calidad.questions.ErrorAlert;
import co.edu.udea.certification.calidad.questions.RequestedCancellations;
import co.edu.udea.certification.calidad.tasks.ChangeSection;
import co.edu.udea.certification.calidad.tasks.LoginInThePlatform;
import co.edu.udea.certification.calidad.tasks.RegisterCancelation;
import co.edu.udea.certification.calidad.useriterfaces.StudentCancellationsPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Cucumber.class)
public class RequestCancellationInvalidCredits {
    @Managed(driver = "chrome")
    public WebDriver driver;
    private Actor student = Actor.named("pepito");
    private StudentCancellationsPage cancellationsPage;

    @Before
    public void setUp(){
        driver.manage().window().maximize();
        cancellationsPage = new StudentCancellationsPage();
        student.can(BrowseTheWeb.with(driver));
        student.attemptsTo(Open.browserOn(cancellationsPage));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I am in the course cancellation section with my platform user 2")
    public void iAmInTheCourseCancellationSectionWithMyPlatformUser() {
        student.attemptsTo(
                LoginInThePlatform.withCredentials("juan.guillermo", "contrasena6")
        );
    }

    @When("I fill all the required fields to make a cancellation request 2")
    public void iFillAllTheRequiredFieldsToMakeACancellationRequest() {
        String justification = "Carga academica";
        student.attemptsTo(
            RegisterCancelation.withJustification(justification)
        );
    }

    @Then("I can see an error message for the amount of credits enrolled")
    public void iCanSeeAnErrorMessageForTheAmountOfCreditsEnrolled() throws InterruptedException {
        // Evitemos que el test termine antes de que se muestre la alerta
        
        // Validemos que al dar click en el botón se muestre una alerta con el mennsaje: "No se puede"
        //Alert alert = driver.switchTo().alert();
        //String alertMessage= alert.getText();
        //alert.accept();
        Thread.sleep(2000);
        student.should(
                seeThat(ErrorAlert.isDisplayed("error"), equalTo(true))
        );
        Thread.sleep(2000);
    }
}
