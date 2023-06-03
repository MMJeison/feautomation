package co.edu.udea.certification.calidad.useriterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://localhost:5173/login")
public class StudentCancellationsPage extends PageObject {
    public static final Target CHECK_BOX_COURSE = Target.the("Checkbox para seleccionar el curso").locatedBy("//*[@id='root']/div/div/div[5]/div[2]/div[2]/table/tbody/tr[1]/td[1]/input");

    public static final Target INPUT_REASON_FIELD = Target.the("Area para escribir justificacion").locatedBy("//*[@id='root']/div/div/div[5]/div[2]/div[2]/textarea");

    public static final Target BUTTON_SEND_REQUEST = Target.the("Boton de enviar solicitud").locatedBy("//*[@id='root']/div/div/div[5]/div[2]/div[2]/div/button");

    public static final Target SECTION_PENDING_CANCELLATIONS = Target.the("Boton de enviar solicitud").locatedBy("//*[@id='root']/div/div/div[5]/div[1]/a[2]");

    public static final Target PENDING_CANCELATIONS_ROW = Target.the("Boton de enviar solicitud").locatedBy("//*[@id='root']/div/div/div[5]/div[2]/div[2]/table/tbody/tr");
}
