package RefactorEmail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class LetterToYourself {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginEmail();
        letterToYourself();
        driver.get("https://e.mail.ru/inbox/?authid=kst0m4n5.4kj&back=1%2C1&dwhsplit=s10273.b1ss12743s&from=login&x-login-auth=1&afterReload=1");
    }

    public static void loginEmail() throws InterruptedException {
        driver.get("https://account.mail.ru/login");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user.morton@bk.ru");

        driver.findElement(By.xpath("//button")).click();

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("txbOu3YIyR1*");

        driver.findElement(By.xpath("//button")).click();
    }

    public static void letterToYourself() {
        driver.get("https://e.mail.ru/inbox/?authid=kst0m4n5.4kj&back=1%2C1&dwhsplit=s10273.b1ss12743s&from=login&x-login-auth=1&afterReload=1");

        driver.findElement(By.xpath("//span[@class='button2__wrapper button2__wrapper_centered']")).click();

        driver.findElement(By.xpath("//span[contains(@class,'list-item__text') and text()='Написать себе']")).click();

        driver.findElement(By.xpath("//div[@class='container--3QXHv']")).click();

        driver.findElement(By.name("Subject")).sendKeys("Письмо себе");

        driver.findElement(By.xpath("//span[contains(@class,'button2__txt') and text()='Отправить']")).click();

        driver.findElement(By.xpath("//button[contains(@class,'base-0-2-91 primary-0-2-105 auto-0-2-117')]")).click();

    }

}
