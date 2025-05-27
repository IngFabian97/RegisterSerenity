package registerserenity.tasks.registration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import registerserenity.ui.registration.SummaryPage;

public class CheckNewAccountCreated implements Task {

    private final String name;
    private final String lastName;

    public CheckNewAccountCreated(String name, String lastname) {
        this.name = name;
        this.lastName = lastname;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Switch.toWindowTitled("Summary"),
                WaitUntil.the(SummaryPage.LABEL_NAME, isVisible()).forNoMoreThan(10)
                        .seconds(),
                Ensure.that(SummaryPage.LABEL_NAME).text().containsIgnoringCase(name),
                Ensure.that(SummaryPage.LABEL_LAST_NAME).text()
                        .containsIgnoringCase(lastName));
    }

}
