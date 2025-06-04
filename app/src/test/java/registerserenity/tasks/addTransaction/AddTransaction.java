package registerserenity.tasks.addTransaction;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import registerserenity.ui.addTransaction.AddTransactionPage;

public class AddTransaction {

        public static Performable

                        withInfo(String transactionDate, String transactionAmount, String transactionDescription) {
                return Task.where("{0} adss a new transaction",
                                WaitUntil.the(AddTransactionPage.BUTTON_TRANSACTION,
                                                isVisible())
                                                .forNoMoreThan(10).seconds(),
                                Click.on(AddTransactionPage.BUTTON_TRANSACTION),
                                WaitUntil.the(AddTransactionPage.INPUT_DATE, isVisible()).forNoMoreThan(10)
                                                .seconds(),
                                Enter.theValue(transactionDate).into(
                                                AddTransactionPage.INPUT_DATE),
                                WaitUntil.the((AddTransactionPage.INPUT_AMOUNT), isVisible()).forNoMoreThan(10)
                                                .seconds(),
                                Enter.theValue(transactionAmount).into(
                                                AddTransactionPage.INPUT_AMOUNT),
                                WaitUntil.the(AddTransactionPage.INPUT_DESCRIPTION, isVisible()).forNoMoreThan(10)
                                                .seconds(),
                                Enter.theValue(transactionDescription).into(
                                                AddTransactionPage.INPUT_DESCRIPTION),
                                WaitUntil.the(AddTransactionPage.BUTTON_SAVE, isVisible())
                                                .forNoMoreThan(10)
                                                .seconds(),
                                Click.on(AddTransactionPage.BUTTON_SAVE));

        }
}
