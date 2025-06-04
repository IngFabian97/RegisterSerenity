package registerserenity.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import registerserenity.models.LoginModel;
import registerserenity.models.TransactionModel;
import registerserenity.tasks.addTransaction.AddTransaction;
import registerserenity.tasks.addTransaction.CheckNewTransactionWasAdded;
import registerserenity.tasks.login.Login;
import registerserenity.tasks.navigation.NavigateTo;
import registerserenity.util.GetInfoFromTable;

public class AddTransactionStepDefinitions {

    @Given("{actor} is logged into the application")
    public void isLoggedIntoTheApplication(Actor actor, DataTable userLogin) {

        
        LoginModel loginModel = GetInfoFromTable.getLoginCredentials(userLogin);

        actor.attemptsTo(
                NavigateTo.loginPage(),
                new Login(loginModel.getUsername(), loginModel.getPassword())

        );
    }

    @When("{actor} enters the required information for the new transaction")
    public void entersTheRequiredInformationForTheNewTransaction(Actor actor, DataTable transactionInfo) {


        TransactionModel transactionModel = GetInfoFromTable.getTransactionDate(transactionInfo);

        actor.attemptsTo(
                AddTransaction.withInfo(transactionModel.getTransactionDate(),
                                        transactionModel.getTransactionAmount(),
                                        transactionModel.getTransactionDescription()));
    }

    @Then("{actor} should see a new transaction in the transacation list with correct details")
    public void shouldSeeANewTransactionInTheTransactionListWithCorrectDetails(Actor actor) {
        actor.attemptsTo(
                new CheckNewTransactionWasAdded());
    }
}
