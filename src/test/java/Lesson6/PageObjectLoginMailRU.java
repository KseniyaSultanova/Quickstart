package Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import lesson7.CustomLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class PageObjectLoginMailRU {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();

    }
    @BeforeEach
    void initDriver(){
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 5);

    }
    @Test
    @Story("Проверка сценариев: логин, написать пиьсмо себе")
    void loginMailRuTest() throws InterruptedException {
        driver.get("https://e.mail.ru/inbox/?authid=kst0m4n5.4kj&back=1%2C1&dwhsplit=s10273.b1ss12743s&from=login&x-login-auth=1&afterReload=1");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(3000);
        new LoginPageMailRu(driver).fillInputLoginEmail("user.morton@bk.ru");
        new LoginPageMailRu(driver).clickButtonOne.click();
        new LoginPageMailRu(driver).fillInputPasswordEmail("txbOu3YIyR1*");
        new LoginPageMailRu(driver).clickButtonTwo.click();

        Thread.sleep(3000);

        new SentMessage(driver).clickDropDown.click();
        new SentMessage(driver).clickYourselfButton.click();
        new SentMessage(driver).clickFieldLetterSubject.click();
        new SentMessage(driver).SentMessageMy("Письмо себе");
        new SentMessage(driver).clickButtonSent.click();
        new SentMessage(driver).clickButtonYesSent.click();

    }

    @AfterEach
    void tearDown(){
        LogEntries browserConsoleLogs = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = browserConsoleLogs.iterator();

        while (iterator.hasNext()) {
            Allure.addAttachment("Элемент лога браузера", iterator.next().getMessage());
        }

        driver.quit();
    }
}
