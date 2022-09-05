package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageMailRu extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    public WebElement inputLoginEmail;

    @FindBy(xpath = "//button")
    public WebElement clickButtonOne;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputPasswordEmail;

    @FindBy(xpath = "//button")
    public WebElement clickButtonTwo;

    public LoginPageMailRu(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод данных в поле логин")
    public void fillInputLoginEmail(String login){
        inputLoginEmail.sendKeys(login);
    }
    @Step("Ввод данных в поле пароль")
    public void fillInputPasswordEmail(String password){
        inputPasswordEmail.sendKeys(password);
    }

    public void loginEmail(String login, String password){
        inputLoginEmail.sendKeys(login);
        clickButtonOne.click();
        inputPasswordEmail.sendKeys(password);
        clickButtonTwo.click();

    }


    }

