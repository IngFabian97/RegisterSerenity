package registerserenity.tasks.registration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import registerserenity.ui.registration.RegisterForm;

public class ShouldSeeAllFieldsAreRequired implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(
                        RegisterForm.ALERT_ALL_REQUIRED_FIELDS, isVisible()).forNoMoreThan(10)
                        .seconds(),
                Ensure.that(RegisterForm.ALERT_ALL_REQUIRED_FIELDS).text()
                        .containsIgnoringCase("Por favor diligencie todos los campos"));
    }

}
