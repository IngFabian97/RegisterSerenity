package registerserenity.ui.addTransaction;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class AddTransactionPage {

    public static Target BUTTON_TRANSACTION = Target.the("Add transaction button")
            .locatedBy("//button[normalize-space()='Añadir transacción']");
    public static Target INPUT_DATE = Target.the("date input")
            .locatedBy("//input[@id='date']");
    public static Target INPUT_AMOUNT = Target.the("amount input")
            .locatedBy("//input[@id='amount']");
    public static Target INPUT_DESCRIPTION = Target.the("description input")
            .located(By.id("description"));
    public static Target BUTTON_SAVE = Target.the("username input")
                    .located(By.xpath("//button[normalize-space()='Guardar']"));
        public static Target TRANSACTIONS_TABLE = Target.the("transactions table")
            .locatedBy("//tbody[@id='transactions-list']");
}
