package lesson05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bitrix {
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
        loginToBitrix();
        driver.get("https://b24-lyojpm.bitrix24.ru/crm/deal/kanban/?current_fieldset=SOCSERV");
        //driver.quit();
    }

    @Test
    void CreateDeal() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        Thread.sleep(3000);
        driver.get("https://b24-lyojpm.bitrix24.ru/crm/deal/kanban/?current_fieldset=SOCSERV");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='crm-kanban-column-add-item-button']")).click();

        driver.findElement(By.name("TITLE")).sendKeys("Сделка1");

        Thread.sleep(2000);
        //driver.findElement(By.linkText("Сохранить")).click();//input[@value='Сохранить']
        driver.findElement(By.xpath("//input[@value='Сохранить']")).click();

    }

    @Test
    void DropDeal() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        Thread.sleep(3000);
        driver.get("https://b24-lyojpm.bitrix24.ru/crm/deal/kanban/?current_fieldset=SOCSERV");

        Actions actions = new Actions(driver);
       // Actions actions1 = actions.clickAndHold(driver.findElement(By.xpath("//div[@class='mt-h-c__item mt-h-c__item_title']")));
        Actions actions2 = actions.moveToElement(driver.findElement(By.xpath("//div[@class='mt-h-c__item mt-h-c__item_title']")));
        //  .dragAndDrop(By.xpath("//div[@class='main-kanban-column-title-text-inner']")
        //


    }
    //By.linkText("Укажите организацию"


    //"//div[@class='select2-result-label']")).click()
    public static void loginToBitrix() throws InterruptedException {
        driver.get("https://auth2.bitrix24.net/oauth/authorize/");

        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("u.oshkina@yandex.ru");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(.,'Далее')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("HHJSDHoo886YYj");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(.,'Далее')]")).click();

    }
}
