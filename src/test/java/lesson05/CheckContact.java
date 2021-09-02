package lesson05;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson3.ContactPerson;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckContact {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        loginToCrm();
    }
    //Создать проверку
    @Test
    void checkContactInListContactPerson() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        Thread.sleep(3000);
        driver.get("https://crm.geekbrains.space/contact/");

        driver.findElement(By.xpath("//div[@class='filter-item oro-drop']")).click();
        driver.findElement(By.name("value")).sendKeys("Султанова");
        driver.findElement(By.xpath("//button[contains(.,'Обновить')]")).click();

        List<WebElement> headerFio = (List<WebElement>) driver.findElement(By.cssSelector(".//tr[@grid-row]"));
        Assertions.assertTrue(Boolean.parseBoolean(headerFio.get(0).getText()),"Султанова Ксения");
    }

    //так и не смогла разобраться как сделать проверку в списке.

//    @AfterEach
//    void tearDown() {
//        driver.quit();
//    }

    void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();

    }
}

