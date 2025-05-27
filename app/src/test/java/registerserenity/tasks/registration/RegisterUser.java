package registerserenity.tasks.registration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import java.net.URISyntaxException;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;
import registerserenity.ui.registration.RegisterForm;

public class RegisterUser implements Task {
    
    private final String name;
    private final String lastname;
    private final String age;
    private final String country;
    private final String email;

    public RegisterUser(String name, String lastname, String age, String country, String email) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.country = country;
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
      try {
        actor.attemptsTo(WaitUntil.the(RegisterForm.INPUT_NAME,
                    isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(name).into(
                        RegisterForm.INPUT_NAME),
                    WaitUntil.the(RegisterForm.INPUT_LAST_NAME, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(lastname).into(
                        RegisterForm.INPUT_LAST_NAME),
                    WaitUntil.the(RegisterForm.INPUT_AGE, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(age).into(
                        RegisterForm.INPUT_AGE),
                    WaitUntil.the(RegisterForm.SELECT_COUNTRY, isVisible()).forNoMoreThan(10).seconds(),
                    SelectFromOptions.byVisibleText(country).from(
                        RegisterForm.SELECT_COUNTRY),
                    WaitUntil.the(RegisterForm.INPUT_SEX, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(RegisterForm.INPUT_SEX),
                    WaitUntil.the(RegisterForm.INPUT_EMAIL, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(email).into(RegisterForm.INPUT_EMAIL),
                    WaitUntil.the(RegisterForm.INPUT_MONDAY, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(RegisterForm.INPUT_MONDAY),
                    Upload.theClasspathResource("pictures/OIP.jpg")
                            .to(RegisterForm.INPUT_PICTURE),
                    WaitUntil.the(RegisterForm.BUTTON_SAVE, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(RegisterForm.BUTTON_SAVE));
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
    }

}
