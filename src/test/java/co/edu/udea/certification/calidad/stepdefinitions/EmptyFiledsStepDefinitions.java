package co.edu.udea.certification.calidad.stepdefinitions;


import co.edu.udea.certification.calidad.questions.EmptyFields;
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

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Cucumber.class)
public class EmptyFiledsStepDefinitions {
  @Managed(driver = "chrome")
  public WebDriver driver;
  private Actor student = Actor.named("juanito");
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

  @Given("I am on the login page of the platform")
  public void iAmOnTheLoginPage() {
    student.attemptsTo(Open.browserOn(userPage));
  }

  @When("I click on the login button")
  public void iClickOnTheLoginButton() {
    student.attemptsTo(
            LoginInThePlatform.withEmptyFields()
    );
  }

  @Then("I should see an warning message")
  public void iShouldSeeAnWarningMessage() {
    student.should(
            seeThat(EmptyFields.withMessage("Completa este campo"), equalTo(true))
    );
    // Thread.sleep(10000);
  }
  
}
