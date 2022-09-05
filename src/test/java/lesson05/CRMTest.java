package lesson05;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class CRMTest {
    WebDriver driver;
    WebDriverWait webDriverWait; //условные ожидания
    private static final String BASE_URL = "https://crm.geekbrains.space/"; //константа для хранения URL

    @BeforeAll //перед выполнением всех тестов будет 1 раз выполняться метод,который зарегистрирует chromedriver
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
        //перед каждым тестом, будет создаваться новый driver
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        loginToCrm();
    }

    @Test
    @Step("Создание нового контактного лица")
    void createContactPersonTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        Thread.sleep(3000);
        driver.get("https://crm.geekbrains.space/contact/");

        driver.findElement(By.linkText("Создать контактное лицо")).click();

        Thread.sleep(4000);
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Султанова");

        Thread.sleep(4000);
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Ксения");

        Thread.sleep(4000);
        driver.findElement(By.linkText("Укажите организацию")).click();

       Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();

        Thread.sleep(4000);
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Студент");

        driver.findElement(By.xpath("//button[contains(.,'Сохранить')]")).click();

    }



    @Test
    @Step("Создание нового проекта")
    void createNewProjectTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginToCrm();
        Thread.sleep(3000);
        driver.get("https://crm.geekbrains.space/project/");
        driver.findElement(By.linkText("Создать проект")).click();

        Thread.sleep(4000);
        driver.findElement(By.name("crm_project[name]")).sendKeys("Project by KS7");

        Thread.sleep(4000);
        driver.findElement(By.linkText("Укажите организацию")).click();

        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();

        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText("Ким Юрий");

        Select projectManager = new Select(driver.findElement(By.name("crm_project[rp]")));
        projectManager.selectByVisibleText("Гатов Фёдор");

        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText("Палкина Анна");

        driver.findElement(By.xpath("//button[contains(.,'Сохранить')]")).click();
    }


    @AfterEach
        //после каждого теста,будем выполнять метод quit (закрытие браузера)
    void tearDown() {
        LogEntries browserConsoleLogs = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = browserConsoleLogs.iterator();

        while (iterator.hasNext()) {
            Allure.addAttachment("Элемент лога браузера", iterator.next().getMessage());
        }
        driver.quit();
    }

    void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();

    }
}
