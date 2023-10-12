package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Page {

    WebDriver driver;


    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void elementGozukeneKadarBekleXpath(String elementId){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementId)));
    }


    public String sayfadakiYaziyiOkuXpath(String elementId){
        String text = driver.findElement(By.xpath(elementId)).getText();
        return text;
    }

    public void inputAlaninaGirisYap(String elementId, String input){
        driver.findElement(By.xpath(elementId)).sendKeys(input);
    }

    public void butonaTikla(String elementId){
        driver.findElement(By.xpath(elementId)).click();
    }

    /*
    public void alarmiKabulEt(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    */

    public int ilgiliListeninSayisiniDondur(String elementId){
        List<WebElement> elements =driver.findElements(By.xpath(elementId));
        return elements.size();

    }
    public List<String> ilgiliListeninElemanlariniDondur(String elementId){
        List<WebElement> elements =driver.findElements(By.xpath(elementId));
        List<String> elemenTextleri = new ArrayList<>();
        for (WebElement element : elements) {
            elemenTextleri.add(element.getText());

        }
        return elemenTextleri;

    }


}
