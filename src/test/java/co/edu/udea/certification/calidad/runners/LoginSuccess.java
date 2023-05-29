package co.edu.udea.certification.calidad.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/login_to_the_university_platform.feature",
  glue = "co.edu.udea.certification.calidad.stepdefinitions",
  snippets = SnippetType.CAMELCASE
)

public class LoginSuccess {
  
}
