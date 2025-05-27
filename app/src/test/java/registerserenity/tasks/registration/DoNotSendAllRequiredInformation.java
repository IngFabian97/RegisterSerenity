package registerserenity.tasks.registration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import registerserenity.ui.registration.RegisterForm;

public class DoNotSendAllRequiredInformation implements Task {

    private final String name;
    private final String lastName;

    public DoNotSendAllRequiredInformation(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(RegisterForm.INPUT_NAME,
                isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(name).into(
                        RegisterForm.INPUT_NAME),
                WaitUntil.the(RegisterForm.INPUT_LAST_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(lastName).into(
                        RegisterForm.INPUT_LAST_NAME),
                WaitUntil.the(
                        RegisterForm.BUTTON_SAVE, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(RegisterForm.BUTTON_SAVE));
    }
}
