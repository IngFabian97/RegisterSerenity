package registerserenity.stepdefinitions;

import java.net.URISyntaxException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import registerserenity.tasks.registration.CheckNewAccountCreated;
import registerserenity.tasks.registration.DoNotSendAllRequiredInformation;
import registerserenity.tasks.registration.RegisterUser;
import registerserenity.tasks.registration.ShouldSeeAllFieldsAreRequired;
import registerserenity.ui.registration.RegisterPage;

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
                                Open.browserOn(new RegisterPage()));
        }

        @When("{actor} send the required information to sign up")
        public void sendsRequiredInformationToSignUp(Actor actor) {

                actor.attemptsTo(
                                new RegisterUser(name, lastname, age, country, email, dayWork));
        }

        @Then("{actor} should have a new account created")
        public void shouldHaveANewAccountCreated(Actor actor) {
                actor.attemptsTo(
                                new CheckNewAccountCreated(name, lastname));
        }

        @When("{actor} does not send the required information")
        public void doesNotSendTheRequiredInformation(Actor actor) {
                actor.attemptsTo(
                                new DoNotSendAllRequiredInformation(name, lastname));
        }

        @Then("{actor} should be told all fields are required")
        public void shouldBeToldFieldsAreRequired(Actor actor) {
                actor.attemptsTo(
                                new ShouldSeeAllFieldsAreRequired());
        }
}