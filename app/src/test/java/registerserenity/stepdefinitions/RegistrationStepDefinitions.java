package registerserenity.stepdefinitions;

import java.net.URISyntaxException;
import java.util.List;

import io.cucumber.datatable.DataTable;
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

        String name = "";
        String lastName = "";
        String age = "";
        String country = "";
        String email = "";

        @Given("{actor} wants to register sign up in the aplication")
        public void wanstToSignUpInTheApplication(Actor actor) {

                actor.attemptsTo(
                                Open.browserOn(new RegisterPage()));
        }

        @When("{actor} send the required information to sign up")
        public void sendsRequiredInformationToSignUp(Actor actor, DataTable userInfo) {

                List<List<String>> rows = userInfo.asLists(String.class);
                for (List<String> columns : rows) {
                        name = columns.get(0);
                        lastName = columns.get(1);
                        age = columns.get(2);
                        country = columns.get(3);
                        email = columns.get(4);
                }
                actor.attemptsTo(
                                new RegisterUser(name, lastName, age, country, email));
        }

        @Then("{actor} should have a new account created")
        public void shouldHaveANewAccountCreated(Actor actor) {
                actor.attemptsTo(
                                new CheckNewAccountCreated(name, lastName));
        }

        @When("{actor} does not send the required information")
        public void doesNotSendTheRequiredInformation(Actor actor) {
                actor.attemptsTo(
                                new DoNotSendAllRequiredInformation(name, lastName));
        }

        @Then("{actor} should be told all fields are required")
        public void shouldBeToldFieldsAreRequired(Actor actor) {
                actor.attemptsTo(
                                new ShouldSeeAllFieldsAreRequired());
        }
}