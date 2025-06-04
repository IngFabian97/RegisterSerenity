package registerserenity.tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import registerserenity.ui.login.LoginPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

        private final String username;
        private final String password;

        public Login(String username, String password) {
                this.username = username;
                this.password = password;
        }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.INPUT_USERNAME,
                        isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(LoginPage.INPUT_USERNAME),
                WaitUntil.the(LoginPage.INPUT_PASSWORD,
                        isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(password).into(LoginPage.INPUT_PASSWORD),
                WaitUntil.the(LoginPage.BUTTON_LOGIN,
                        isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LoginPage.BUTTON_LOGIN));
    }

}
