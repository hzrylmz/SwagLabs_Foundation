package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomePageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void hamburger_menudeki_alanlarin_sayisinin_geldigini_kontrol_edilmesi(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.butonaTikla(homePage.hamburgerMenu_button);
        int button_sayisi = homePage.ilgiliListeninSayisiniDondur(homePage.hamburgerMenu_list);
        Assertions.assertEquals(4,button_sayisi);

    }
    @Test @Disabled
    void hamburger_menudeki_alanlarin_textinin_geldigini_kontrol_edilmesi(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.butonaTikla(homePage.hamburgerMenu_button);
        List<String> liste = homePage.ilgiliListeninElemanlariniDondur(homePage.hamburgerMenu_list);
        System.out.println(liste);

    }
    /*
    @Test @Disabled
    void hakkinda_sayfasinin_geldigini_dogrula(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.butonaTikla(homePage.hamburgerMenu_button);
        homePage.elementGozukeneKadarBekleXpath(homePage.hamburgerMenu_list);
        homePage.butonaTikla(homePage.about);
        String requiredText = "The world relies on your code. Test on thousands of different device, browser, and OS configurations–anywhere, any time.";
        String actualText = homePage.sayfadakiYaziyiOkuXpath(homePage.about_yazisi);
        Assertions.assertEquals(requiredText,actualText);
    }*/

    @Test
    void anasayfadaki_goruntulenen_urun_sayisini_dondur(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.product);
        int urun_sayisi = homePage.ilgiliListeninSayisiniDondur(homePage.inventory_list);
        Assertions.assertEquals(1,urun_sayisi);

    }

    @Test
    void urunlerin_altındaki_addToCart_butonunun_geldigini_goruntule(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.backpack_addToCart);
        String actualText = homePage.sayfadakiYaziyiOkuXpath(homePage.backpack_addToCart);
        String requiredText = "Add to cart";
        Assertions.assertEquals(requiredText,actualText);

    }
    @Test
    void urunlerin_altında_price_geldigini_dogrula(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.backpack_price);
        String price = homePage.sayfadakiYaziyiOkuXpath(homePage.backpack_price);
        String requiredText = "$29.99";
        Assertions.assertEquals(requiredText,price);
    }

    @Test @Disabled
    void hamburger_menunun_carpi_butonuyla_kapatilmasi_kontrolu(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.hamburgerMenu_button);
        homePage.butonaTikla(homePage.hamburgerMenu_button);
        homePage.elementGozukeneKadarBekleXpath(homePage.hamburgerMenu_carpi);
        homePage.elementGozukeneKadarBekleXpath(homePage.product);
        String requiredText = "Products";
        String actualText = homePage.sayfadakiYaziyiOkuXpath(homePage.product);
        Assertions.assertEquals(requiredText,actualText);

    }

    @Test
    void urunlerin_ZtoA_seklinde_siralanmasi_kontrolu(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.butonaTikla(homePage.filter);
        homePage.elementGozukeneKadarBekleXpath(homePage.a_to_z);
        homePage.butonaTikla(homePage.a_to_z);
        String actualText = homePage.sayfadakiYaziyiOkuXpath(homePage.redTshirtTitle);
        String requiredText = "Test.allTheThings() T-Shirt (Red)";
        Assertions.assertEquals(requiredText,actualText);
    }

    @Test
    void urunlerin_fiyatlarina_göre_LowTo_High_siralanmasi(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.butonaTikla(homePage.filter);
        homePage.elementGozukeneKadarBekleXpath(homePage.low_to_high);
        homePage.butonaTikla(homePage.low_to_high);
        String price = homePage.sayfadakiYaziyiOkuXpath(homePage.sauceLabsOnesie_price);
        String requiredText = "$7.99";
        Assertions.assertEquals(requiredText,price);

    }
    @Test
    void urunlerin_fiyatlarina_göre_HighTo_Low_siralanmasi(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.butonaTikla(homePage.filter);
        homePage.elementGozukeneKadarBekleXpath(homePage.high_to_low);
        homePage.butonaTikla(homePage.high_to_low);
        String price = homePage.sayfadakiYaziyiOkuXpath(homePage.sauceLabsFleeceJacket_price);
        String requiredText = "$49.99";
        Assertions.assertEquals(requiredText,price);

    }



    @AfterEach
    void tearDown(){
        driver.close();
    }




















}
