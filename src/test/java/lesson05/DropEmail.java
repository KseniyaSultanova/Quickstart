package lesson05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropEmail {

    static WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginToMail();
        Thread.sleep(5000);
        driver.get("https://passport.yandex.ru/auth?retpath=https%3A%2F%2Fpassport.yandex.ru%2Fprofile&noreturn=1");
        //driver.quit();

    }

    @Test
    void dragAndDropEmail(){
    }



    public static void loginToMail() throws InterruptedException {
        driver.get("https://passport.yandex.ru/login");

        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("u.oshkina@yandex.ru");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Войти')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("HHJSDHoo886YYj");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(.,'Войти')]")).click();

    }
}
