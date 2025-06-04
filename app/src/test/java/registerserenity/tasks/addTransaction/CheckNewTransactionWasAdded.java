package registerserenity.tasks.addTransaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import registerserenity.ui.addTransaction.AddTransactionPage;

public class CheckNewTransactionWasAdded implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(AddTransactionPage.TRANSACTIONS_TABLE).text().contains("testing description"),
                Ensure.that(AddTransactionPage.TRANSACTIONS_TABLE).text().contains("500"));
    }

}
