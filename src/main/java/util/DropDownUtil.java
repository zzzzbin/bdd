package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testbase.WebTestBase;

import java.util.List;

public class DropDownUtil extends WebTestBase {

    public static Select select;

    public static void bootstrapDropDown(List<WebElement> elementList, String option){
        for (WebElement element : elementList){
            if (element.getText().equalsIgnoreCase(option)){
                element.click();
                break;
            }
        }
    }

    public static void selectOptionByVisibleText(WebElement element, String option){
        select = new Select(element);
        select.selectByVisibleText(option);
    }

    public static void selectOptionByValue(WebElement element, String value){
        select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectOptionByIndex(WebElement element, int index){
        select = new Select(element);
        select.selectByIndex(index);
    }
}
