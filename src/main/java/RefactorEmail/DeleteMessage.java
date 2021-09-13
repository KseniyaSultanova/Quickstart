package RefactorEmail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
        DragDrop();
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
        driver.get("https://e.mail.ru/inbox/?authid=kst0m4n5.4kj&back=1%2C1&dwhsplit=s10273.b1ss12743s&from=login&x-login-auth=1&afterReload=1");
        Thread.sleep(3000);

        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElements(By.xpath("//a[contains(@class, 'letter-bottom')]")).get(0))
                .click(driver.findElements(By.xpath("//div[@class='checkbox__box checkbox__box_disabled']")).get(0)).perform();
        Thread.sleep(5000);

    }

    public static void DragDrop() {

        WebElement From = driver.findElement(By.xpath("//div[@class='llc__item llc__item_correspondent llc__item_unread']"));

         WebElement To = driver.findElement(By.xpath("//a[6]/div/div[2]/div"));

        Actions act = new Actions(driver);

        act.dragAndDrop(From, To).build().perform();
    }
}



