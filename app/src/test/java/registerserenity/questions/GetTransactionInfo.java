package registerserenity.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import registerserenity.ui.addTransaction.AddTransactionPage;

public class GetTransactionInfo {
    
    public static Question<String> getDescription() {
        return Question.about("transaction description").answeredBy(actor -> BrowseTheWeb.as(actor).textOf(AddTransactionPage.TRANSACTION_TABLE_XPATH));
    }
}
