package registerserenity.stepdefinitions;

import java.net.URISyntaxException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistrationStepDefinitions {

    String name = "Fabian";
    String lastname = "Guarin";
    String age = "28";
    String country = "Colombia";
    String email = "fabian@email.com";
    String dayWork = "Lunes";

    @Given("{actor} wants to register sign up in the aplication")
    public void wanstToSignUpInTheApplication(Actor actor) {

        actor.attemptsTo(
                Open.url("http://127.0.0.1:5501/register.html"));
    }

    @When("{actor} send the required information to sign up")
    public void sendsRequiredInformationToSignUp(Actor actor) throws URISyntaxException {

        actor.attemptsTo(WaitUntil.the("//input[@id='name']",
                isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(name).into("//input[@id='name']"),
                WaitUntil.the("//input[@id='last-name']", isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(lastname).into("//input[@id='last-name']"),
                WaitUntil.the("//input[@id='age']", isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(age).into("//input[@id='age']"),
                WaitUntil.the("//select[@id='country']", isVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(country).from("//select[@id='country']"),
                WaitUntil.the("//input[@id='sex-m']", isVisible()).forNoMoreThan(10).seconds(),
                Click.on("//input[@id='sex-m']"),
                WaitUntil.the("//input[@id='email']", isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(email).into("//input[@id='email']"),
                WaitUntil.the("//input[@id='monday']", isVisible()).forNoMoreThan(10).seconds(),
                Click.on("//input[@id='monday']"),
                Upload.theClasspathResource("pictures/OIP.jpg")
                        .to(Target.the("picture field").locatedBy("//input[@id='picture']")),
                WaitUntil.the("//button[@id='save-btn']", isVisible()).forNoMoreThan(10).seconds(),
                Click.on("//button[@id='save-btn']"));
    }

@Then("{actor} should have a new account created")
public void shouldHaveANewAccountCreated(Actor actor) {
    actor.attemptsTo(Switch.toWindowTitled("Summary"),
            WaitUntil.the("//strong[contains(text(), 'Nombre')]/parent::p", isVisible()).forNoMoreThan(10)
                    .seconds(),
            Ensure.that(Target.the("Name element")
                    .locatedBy("//strong[contains(text(), 'Nombre')]/parent::p")).text().containsIgnoringCase(name),
            Ensure.that(Target.the("Last name element")
                    .locatedBy("//strong[contains(text(), 'Apellido')]/parent::p")).text()
                    .containsIgnoringCase(lastname));
}

@When("{actor} does not send the required information")
public void doesNotSendTheRequiredInformation(Actor actor) {
    actor.attemptsTo(WaitUntil.the("//input[@id='name']",
            isVisible()).forNoMoreThan(10).seconds(),
            Enter.theValue(name).into("//input[@id='name']"),
            WaitUntil.the("//input[@id='last-name']", isVisible()).forNoMoreThan(10).seconds(),
            Enter.theValue(lastname).into("//input[@id='last-name']"),
            WaitUntil.the("//button[@id='save-btn']", isVisible()).forNoMoreThan(10).seconds(),
            Click.on("//button[@id='save-btn']"));
}

@Then("{actor} should be told all fields are required")
public void shouldBeToldFieldsAreRequired(Actor actor) {
    actor.attemptsTo(
            WaitUntil.the(
                    "// div[@role='alert']", isVisible()).forNoMoreThan(10)
                    .seconds(),
            Ensure.that(Target.the("Requires fields alert")
                    .locatedBy("// div[@role='alert']")).text()
                    .containsIgnoringCase("Por favor diligencie todos los campos"));
}
}