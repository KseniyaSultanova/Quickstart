package Lesson6;

import org.openqa.selenium.WebDriver;

public class MainPageMail extends BasePage{
    public ListOfMessages listOfMessages;

    public MainPageMail(WebDriver driver) {
        super(driver);
        listOfMessages = new ListOfMessages(driver);
    }
}
