package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ContactPerson {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginToCrm();
        Thread.sleep(3000);
        driver.get("https://crm.geekbrains.space/contact/");


        driver.findElement(By.linkText("Создать контактное лицо")).click();

        Thread.sleep(4000);
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Султанова");

        Thread.sleep(4000);
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Ксения");

        Thread.sleep(4000);
        driver.findElement(By.linkText("Укажите организацию")).click();

        driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();

        Thread.sleep(4000);
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Студент");


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

