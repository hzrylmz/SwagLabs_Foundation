package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {

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
    void sayfa_basliginin_geldigini_goruntule(){

        loginPage.elementGozukeneKadarBekleXpath(loginPage.baslik);
        String actualText = loginPage.sayfadakiYaziyiOkuXpath(loginPage.baslik);
        String requiredText = "Swag Labs";
        Assertions.assertEquals(requiredText,actualText);

    }

    @Test
    void sayfaya_login_olunabildigini_dogrula(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"standard_user");
        loginPage.inputAlaninaGirisYap(loginPage.password,"secret_sauce");
        loginPage.butonaTikla(loginPage.login_butonu);
        homePage.elementGozukeneKadarBekleXpath(homePage.product);
        String requiredText = "Products";
        String actualText = homePage.sayfadakiYaziyiOkuXpath(homePage.product);
        Assertions.assertEquals(requiredText,actualText);
    }

    @Test
    void username_ve_password_alani_bos_birakilarak_giris_yapilamaya_calisilmasi(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username," ");
        loginPage.inputAlaninaGirisYap(loginPage.password," ");
        loginPage.butonaTikla(loginPage.login_butonu);
        loginPage.elementGozukeneKadarBekleXpath(loginPage.bos_username);
        String requiredText = "Epic sadface: Username and password do not match any user in this service";
        String actualText = loginPage.sayfadakiYaziyiOkuXpath(loginPage.bos_username);
        Assertions.assertEquals(requiredText,actualText);
    }

    @Test
    void username_ve_password_alaninin_hatali_girilmesi(){
        loginPage.elementGozukeneKadarBekleXpath(loginPage.username);
        loginPage.inputAlaninaGirisYap(loginPage.username,"addasads");
        loginPage.inputAlaninaGirisYap(loginPage.password,"asdasd");
        loginPage.butonaTikla(loginPage.login_butonu);
        loginPage.elementGozukeneKadarBekleXpath(loginPage.bos_username);
        String requiredText = "Epic sadface: Username and password do not match any user in this service";
        String actualText = loginPage.sayfadakiYaziyiOkuXpath(loginPage.bos_username);
        Assertions.assertEquals(requiredText,actualText);
    }

    @AfterEach
    void tearDown(){
        driver.close();
    }


































}
