package RefactorEmail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeleteMessage {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginEmail();
        deleteMassage();
        driver.get("https://e.mail.ru/tomyself/");
    }

    public static void loginEmail() throws InterruptedException {
        driver.get("https://account.mail.ru/login");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user.morton@bk.ru");

        driver.findElement(By.xpath("//button")).click();

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("txbOu3YIyR1*");

        driver.findElement(By.xpath("//button")).click();
    }

    public static void deleteMassage() throws InterruptedException {
        driver.get("https://e.mail.ru/tomyself/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='nav__folder-name__txt']")).click();

        Actions actions = new Actions(driver);
        WebElement clickMenuElement = driver.findElement(By.xpath("//span[contains(@class,'button2__explanation') and text()='Выделить все']"));
        actions.moveToElement(clickMenuElement).click();
        actions.click(clickMenuElement).perform();
//здесь мне так и не удалось найти решение,для того, чтобы бы произвелось действие клика на кнопку.

        Thread.sleep(3000);
    }


}
