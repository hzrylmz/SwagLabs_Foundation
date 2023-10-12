package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.Page;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTests  {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;


    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    void sepete_urun_eklenebilmesinin_kontrolu(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.backpack_addToCart);
        String requiredText = "1";
        String actualText = homePage.sayfadakiYaziyiOkuXpath(homePage.shoppingCartBadge);
        Assertions.assertEquals(requiredText,actualText);
    }

    @Test
    void sepete_eklenen_urunun_cikarildiginin_kontrolu(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.remove);
        homePage.elementGozukeneKadarBekleXpath(homePage.backpack_addToCart);
        String actualText = homePage.sayfadakiYaziyiOkuXpath(homePage.backpack_addToCart);
        String requiredText = "Add to cart";
        Assertions.assertEquals(requiredText,actualText);

    }

    @Test
    void sepet_sayfasina_gidilebilindigini_dogrula(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.cart);
        homePage.butonaTikla(homePage.cart);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.yourCart);
        String requiredText = cartPage.sayfadakiYaziyiOkuXpath(cartPage.yourCart);
        String actualText = "Your Cart";
        Assertions.assertEquals(requiredText,actualText);
    }

    @Test @Disabled
    void sepete_gittikten_sonra_tekrar_alısverise_devam_edebilme_kontrolu(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.cart);
        homePage.butonaTikla(homePage.cart);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.continueShopping);
        cartPage.butonaTikla(cartPage.continueShopping);
        homePage.elementGozukeneKadarBekleXpath(loginPage.baslik);
        String baslik = homePage.sayfadakiYaziyiOkuXpath(loginPage.baslik);
        String requiredText = "Swag Labs";
        Assertions.assertEquals(requiredText,baslik);

    }


    @Test
    void sepetteki_urunun_checkOut_yapilabilmesi_kontrolu(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.cart);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.sepettekiUrun1);
        String adet = cartPage.sayfadakiYaziyiOkuXpath(cartPage.sepettekiUrun1);
        String requiredText = "1";
        Assertions.assertEquals(requiredText,adet);

    }
    @Test
    void siparis_verilebilmesinin_kontrolu(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.cart);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.checkOut);
        cartPage.butonaTikla(cartPage.checkOut);
        cartPage.inputAlaninaGirisYap(cartPage.firstName,"Hızır");
        cartPage.inputAlaninaGirisYap(cartPage.lastName,"Yılmaz");
        cartPage.inputAlaninaGirisYap(cartPage.postalCode,"535353");
        cartPage.elementGozukeneKadarBekleXpath(cartPage.continueButton);
        cartPage.butonaTikla(cartPage.continueButton);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.finish);
        cartPage.butonaTikla(cartPage.finish);
        String completeOrder = cartPage.sayfadakiYaziyiOkuXpath(cartPage.complete_order);
        String requiredText = "Thank you for your order!";
        Assertions.assertEquals(requiredText,completeOrder);

    }

    @Test
    void siparis_verildikten_sonra_anasayfaya_donulebilmesi_kontrolu(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.cart);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.checkOut);
        cartPage.butonaTikla(cartPage.checkOut);
        cartPage.inputAlaninaGirisYap(cartPage.firstName,"Hızır");
        cartPage.inputAlaninaGirisYap(cartPage.lastName,"Yılmaz");
        cartPage.inputAlaninaGirisYap(cartPage.postalCode,"535353");
        cartPage.elementGozukeneKadarBekleXpath(cartPage.continueButton);
        cartPage.butonaTikla(cartPage.continueButton);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.finish);
        cartPage.butonaTikla(cartPage.finish);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.backHome);
        cartPage.butonaTikla(cartPage.backHome);
        homePage.elementGozukeneKadarBekleXpath(loginPage.baslik);
        String actualText = homePage.sayfadakiYaziyiOkuXpath(loginPage.baslik);
        String requiredText = "Swag Labs";
        Assertions.assertEquals(requiredText,actualText);

    }

    @Test
    void siparis_icin_bilgileri_girmeden_chechOut_ekranina_donulebilmesi_kontrolu(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.cart);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.checkOut);
        cartPage.butonaTikla(cartPage.checkOut);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.cancel);
        cartPage.butonaTikla(cartPage.cancel);
        String actualText = homePage.sayfadakiYaziyiOkuXpath(loginPage.baslik);
        String requiredText = "Swag Labs";
        Assertions.assertEquals(requiredText,actualText);


    }
    @Test
    void isim_girisi_yapilmadan_siparis_verilememesi_kontrolu(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.cart);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.checkOut);
        cartPage.butonaTikla(cartPage.checkOut);
        cartPage.butonaTikla(cartPage.continueButton);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.firstNameHata);
        String actualText = cartPage.sayfadakiYaziyiOkuXpath(cartPage.firstNameHata);
        String requiredText = "Error: First Name is required";
        Assertions.assertEquals(requiredText,actualText);

    }

    @Test
    void soyisim_girisi_yapilmadan_siparis_verilememesi_kontrolu(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.cart);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.checkOut);
        cartPage.butonaTikla(cartPage.checkOut);
        cartPage.inputAlaninaGirisYap(cartPage.firstName,"Hızır");
        cartPage.butonaTikla(cartPage.continueButton);
        String actualText = cartPage.sayfadakiYaziyiOkuXpath(cartPage.lastNameHata);
        String requiredText = "Error: Last Name is required";
        Assertions.assertEquals(requiredText,actualText);
    }
    @Test
    void postaKodu_girisi_yapilmadan_siparis_verilmesi_konusu(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.backpack_addToCart);
        homePage.butonaTikla(homePage.cart);
        cartPage.elementGozukeneKadarBekleXpath(cartPage.checkOut);
        cartPage.butonaTikla(cartPage.checkOut);
        cartPage.inputAlaninaGirisYap(cartPage.firstName,"Hızır");
        cartPage.inputAlaninaGirisYap(cartPage.lastName,"Yılmaz");
        cartPage.butonaTikla(cartPage.continueButton);
        String actualText = cartPage.sayfadakiYaziyiOkuXpath(cartPage.postalCodeHata);
        String requiredText = "Error: Postal Code is required";
        Assertions.assertEquals(requiredText,actualText);

    }



    @AfterEach
    void tearDown(){
        driver.close();
    }




















}
