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
import org.openqa.selenium.interactions.Actions;
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
        webDriverWait = new WebDriverWait(driver, 5);
        loginToMail();
        Thread.sleep(5000);
        driver.get("https://e.mail.ru/inbox/?authid=kst0m4n5.4kj&back=1%2C1&dwhsplit=s10273.b1ss12743s&from=login&x-login-auth=1&afterReload=1");
        //driver.quit();

    }

    @Test
    void dragAndDropEmail()throws InterruptedException{

            WebDriverManager.chromedriver().setup();
            Thread.sleep(3000);
        driver.get("https://e.mail.ru/inbox/?authid=kst0m4n5.4kj&back=1%2C1&dwhsplit=s10273.b1ss12743s&from=login&x-login-auth=1&afterReload=1");

            Actions actions = new Actions(driver);
            // Actions actions1 = actions.clickAndHold(driver.findElement(By.xpath("//div[@class='mt-h-c__item mt-h-c__item_title']")));
            Actions actions2 = actions.moveToElement(driver.findElement(By.xpath("//span[@class='mt-t mt-t_tomyself mt-t_unread' and contains(text(),'Письма себе')]")));
    }



    public static void loginToMail() throws InterruptedException {
        driver.get("https://account.mail.ru/login");
        Thread.sleep(4000);

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user.morton@bk.ru");
        Thread.sleep(4000);

        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("txbOu3YIyR1*");
        Thread.sleep(4000);

        driver.findElement(By.xpath("//button")).click();
    }
}
