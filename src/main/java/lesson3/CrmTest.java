package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CrmTest {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginToCrm();
        Thread.sleep(3000);
        driver.get("https://crm.geekbrains.space/project/");


        driver.findElement(By.linkText("Создать проект")).click();

        Thread.sleep(4000);
        driver.findElement(By.name("crm_project[name]")).sendKeys("Project by KS");

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

        driver.quit();
    }
//https://crm.geekbrains.space/user/login
    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();

    }
}

