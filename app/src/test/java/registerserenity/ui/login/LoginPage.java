package registerserenity.ui.login;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static Target INPUT_USERNAME = Target.the("username input").located(By.id("username"));
    public static Target INPUT_PASSWORD = Target.the("password input").located(By.id("password"));
    public static Target BUTTON_LOGIN = Target.the("button login")
            .locatedBy("//button[normalize-space()='Iniciar sesión']");

}
