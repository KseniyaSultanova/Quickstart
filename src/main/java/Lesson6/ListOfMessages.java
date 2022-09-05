package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class ListOfMessages extends BasePage{
    WebDriver driver;

    @FindBy(xpath = "//a[contains(@class, 'letter-bottom')]")
    public WebElement listMessage;

    @FindBy(xpath = "//div[@class='checkbox__box checkbox__box_disabled']")
    public WebElement checkbox;



    public ListOfMessages(WebDriver driver) {
        super(driver);
    }

    public void clickOneMessage() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElements(By.xpath("//a[contains(@class, 'letter-bottom')]")).get(0))
                .click(driver.findElements(By.xpath("//div[@class='checkbox__box checkbox__box_disabled']")).get(0)).perform();
        Thread.sleep(5000);
    }
}
