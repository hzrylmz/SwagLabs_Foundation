package Pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends Page{

    public final String baslik = "//div[text() = 'Swag Labs']";
    public final String username = "//input[@id = 'user-name']";
    public final String password = "//input[@id = 'password']";
    public final String login_butonu = "//input[@id='login-button']";

    public final String bos_username = "//h3[.='Epic sadface: Username and password do not match any user in this service']";






    public LoginPage(WebDriver driver) {
        super(driver);
    }


}
