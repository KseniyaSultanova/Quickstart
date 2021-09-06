package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginMail {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginToMail();
        Thread.sleep(5000);
        driver.get("https://e.mail.ru/inbox/?authid=kst0m4n5.4kj&back=1%2C1&dwhsplit=s10273.b1ss12743s&from=login&x-login-auth=1&afterReload=1");
        driver.quit();
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

