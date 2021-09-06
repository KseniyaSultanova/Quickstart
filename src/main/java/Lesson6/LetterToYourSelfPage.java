package Lesson6;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LetterToYourSelfPage {
    public WriteAnEmailElement writeAnEmailElement;
    @FindBy(xpath = "//span[contains(@class,'list-item__text')]")
    public List<WebElement> dropDownMenu;
}
