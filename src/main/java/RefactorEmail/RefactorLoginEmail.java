package RefactorEmail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RefactorLoginEmail {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginEmail();
        driver.get("https://e.mail.ru/inbox/?authid=kst0m4n5.4kj&back=1%2C1&dwhsplit=s10273.b1ss12743s&from=login&x-login-auth=1&afterReload=1");
    }

    public static void loginEmail() throws InterruptedException {
        driver.get("https://account.mail.ru/login");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user.morton@bk.ru");

        driver.findElement(By.xpath("//button")).click();

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("txbOu3YIyR1*");

        driver.findElement(By.xpath("//button")).click();
    }
}

