package registerserenity.stepdefinitions;

import org.openqa.selenium.By;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class AddTransactionStepDefinitions {

    @Given("{actor} is logged into the application")
    public void isLoggedIntoTheApplication(Actor actor) {
        
        actor.attemptsTo(
                Open.url("http://127.0.0.1:5500/login/login.html"),
                    WaitUntil.the((By.id("username")),
                isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue("user").into(By.id("username")),
                WaitUntil.the((By.id("password")),
                isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue("pass").into(By.id("password")),
                WaitUntil.the((By.xpath("//button[normalize-space()='Iniciar sesión']")),
                isVisible()).forNoMoreThan(10).seconds(),
            Click.on(By.xpath("//button[normalize-space()='Iniciar sesión']"))
        );
    }

    @When("{actor} enters the required information for the new transaction")
    public void entersTheRequiredInformationForTheNewTransaction(Actor actor){
        actor.attemptsTo(WaitUntil.the((By.xpath("//button[normalize-space()='Añadir transacción']")),isVisible()).forNoMoreThan(10).seconds(),
                Click.on(By.xpath("//button[normalize-space()='Añadir transacción']")),
                WaitUntil.the((By.xpath("//input[@id='date']")),isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue("28052025").into(By.xpath("//input[@id='date']")),
                WaitUntil.the((By.xpath("//input[@id='amount']")),isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue("500").into(By.xpath("//input[@id='amount']")),
                WaitUntil.the((By.id("description")),isVisible()).forNoMoreThan(10).seconds(),
                        Enter.theValue("testing description").into(By.id("description")),
                        WaitUntil.the((By.xpath("//button[normalize-space()='Guardar']")),isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(By.xpath("//button[normalize-space()='Guardar']"))
                        );
    }
    
    @Then("{actor} should see a new transaction in the transacation list with correct details")
    public void shouldSeeANewTransactionInTheTransactionListWithCorrectDetails(Actor actor) {
        actor.attemptsTo(
            Ensure.that(By.xpath("//tbody[@id='transactions-list']")).text().contains("testing description"),
            Ensure.that(By.xpath("//tbody[@id='transactions-list']")).text().contains("500")
        );
    }
}
