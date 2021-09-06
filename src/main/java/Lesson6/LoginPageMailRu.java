package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageMailRu {
    WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement inputLoginEmail;

    @FindBy(xpath = "//button")
    public WebElement clickButtonOne;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputPasswordEmail;

    @FindBy(xpath = "//button")
    public WebElement clickButtonTwo;


    public void fillInputLoginEmail(String login){
        inputLoginEmail.sendKeys(login);
    }
    public void fillInputPasswordEmail(String password){
        inputPasswordEmail.sendKeys(password);
    }

    public void loginEmail(String login, String password){
        inputLoginEmail.sendKeys(login);
        clickButtonOne.click();
        inputPasswordEmail.sendKeys(password);
        clickButtonTwo.click();

    }

    public LoginPageMailRu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
