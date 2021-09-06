package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(xpath = "//button")
    public WebElement clickLoginButton;

    public LoginPage fillInputLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillInputPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton(){
        clickLoginButton.click();
        return this;
    }

    public void login(String login,String password){
        inputLogin.sendKeys();
        inputPassword.sendKeys();
        clickLoginButton.click();

    }

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
