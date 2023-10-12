package Pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends Page{

    public final String yourCart = "//span[@class='title']";
    public final String continueShopping = "//button[@id='continue-shopping']";
    public final String sepettekiUrun1 = "//div[text()='1']";
    public final String checkOut="//button[@id='checkout']";
    public final String firstName = "//input[@id='first-name']";
    public final String lastName = "//input[@id='last-name']";
    public final String postalCode = "//input[@id='postal-code']";
    public final String continueButton = "//input[@id='continue']";
    public final String finish = "//button[@id='finish']";
    public final String complete_order = "//h2[text()='Thank you for your order!']";
    public final String backHome= "//button[@id='back-to-products']";
    public final String cancel ="//button[@id='cancel']";
    public final String firstNameHata= "//h3[text()='Error: First Name is required']";

    public final String lastNameHata = "//h3[text()='Error: Last Name is required']";
    public final String postalCodeHata = "//h3[text()='Error: Postal Code is required']";


    public CartPage(WebDriver driver) {
        super(driver);
    }
}
