package Pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    public final String product = "//span[text()='Products']";

    public final String hamburgerMenu_list = "//a[@class='bm-item menu-item']";

    public final String hamburgerMenu_button = "//button[@id='react-burger-menu-btn']";
    public final String hamburgerMenu_carpi = "//button[@id='react-burger-cross-btn']";
    public final String about = "//a[@class='bm-item menu-item'][2]";

    public final String about_yazisi;

    {
        about_yazisi = "//p[text()='The world relies on your code. Test on thousands of different device, browser, and OS configurations–anywhere, any time.']";
    }

    public final String inventory_list= "//div[@class='inventory_container']";

    public final String backpack_addToCart = "//button[@id='add-to-cart-sauce-labs-backpack']";

    public final String backpack_price = "//div[@class = 'inventory_item_price'][1]";

    public final String shoppingCartBadge = "//span[@class='shopping_cart_badge']";
    public final String remove = "//button[@id='remove-sauce-labs-backpack']";
    public final String cart = "//a[@class='shopping_cart_link']";

    //public final String logout = "//a[text()='Logout']";

    public final String filter = "//select[@class = 'product_sort_container']";
    public final String a_to_z = "//option[text()= 'Name (A to Z)']";
    public final String low_to_high = "//option[text()= 'Price (low to high)']";
    public final String high_to_low = "//option[text()= 'Price (high to low)']";
    public final String redTshirtTitle = "//div[text()= 'Test.allTheThings() T-Shirt (Red)']";

    public final String sauceLabsOnesie_price = "//div[@class = 'inventory_item_price'][1]";
    public final String sauceLabsFleeceJacket_price = "//div[@class = 'inventory_item_price'][1]";

    public HomePage(WebDriver driver) {
        super(driver);
    }


}