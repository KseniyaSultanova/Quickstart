package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SentMessage extends BasePage{
    WebDriver driver;

    @FindBy(xpath = "//span[@class='button2__wrapper button2__wrapper_centered']")
    public WebElement clickDropDown;

    @FindBy(xpath = "//span[contains(@class,'list-item__text') and text()='Написать себе']")
    public WebElement clickYourselfButton;

    @FindBy(xpath = "//div[@class='container--3QXHv']")
    public WebElement clickFieldLetterSubject;

    @FindBy(name = "Subject")
    public WebElement writeEmailSubject;

    @FindBy(xpath = "//span[contains(@class,'button2__txt') and text()='Отправить']")
    public WebElement clickButtonSent;

    @FindBy(xpath = "//button[contains(@class,'base-0-2-100 primary-0-2-114 auto-0-2-126')]")
    public WebElement clickButtonYesSent;



    public void SentMessageMy(String subject){
        writeEmailSubject.sendKeys("Письмо себе");
    }


    public SentMessage(WebDriver driver) {
        super(driver);
    }

}
