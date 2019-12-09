package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class ChedanPage extends BasePage{

    public ChedanPage chedanTest(){

        ArrayList<WebElement> array=new ArrayList<>();
        for(WebElement e: Driver.getCurrentDriver().findElementsByAccessibilityId("点击撤单")){
            array.add(e);
        }

        array.get(0).click();

        return new ChedanPage();
    }
}
