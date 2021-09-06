package Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObjectLoginMailRU {
    WebDriver driver;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
    }
    @Test
    void loginMailRuTest(){
        driver.get("https://e.mail.ru/inbox/?authid=kst0m4n5.4kj&back=1%2C1&dwhsplit=s10273.b1ss12743s&from=login&x-login-auth=1&afterReload=1");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        new LoginPageMailRu(driver).fillInputLoginEmail("user.morton@bk.ru");
        new LoginPageMailRu(driver).clickButtonOne.click();
        new LoginPageMailRu(driver).fillInputPasswordEmail("txbOu3YIyR1*");
        new LoginPageMailRu(driver).clickButtonTwo.click();
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
