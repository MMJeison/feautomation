package co.edu.udea.certification.calidad.useriterfaces;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://localhost:5173/login")
public class UserPage extends PageObject {
  
  public static final Target BUTTON_ESTUDIANTES = Target.the("Boton para ir a la pagina de estudiantes").locatedBy("//*[@id='root']/div[1]/div[2]/ul/li[1]/a");

  public static final Target INPUT_USERNAME = Target.the("Campo para ingresar el nombre de usuario").locatedBy("//*[@id='root']/div/div/div[2]/form/div[1]/input");

  public static final Target INPUT_PASSWORD = Target.the("Campo para ingresar la contraseña").locatedBy("//*[@id='root']/div/div/div[2]/form/div[2]/input");

  public static final Target BUTTON_LOGIN = Target.the("Boton para iniciar sesion").locatedBy("//*[@id='root']/div/div/div[2]/form/input");

  public static final Target TEXT_VALIDATION_LOGIN = Target.the("Texto de validacion de inicio de sesion").locatedBy("//*[@id='first_e']/h4");

}
