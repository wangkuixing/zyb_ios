package page.ggt;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.BasePage;

import java.util.ArrayList;

public class GgchedanPage extends BasePage {

    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String queding="确定";
    String back="TZTnavbarbackbg 1@2x";

    String message;

    public GgchedanPage chedan() throws InterruptedException {

        //todo: 改造新增无委托情况的判断
        ArrayList<WebElement> array=new ArrayList<>();
        for (WebElement e: Driver.getCurrentDriver().findElementsByAccessibilityId("点击撤单")){
            array.add(e);
        }
        array.get(0).click();

        find_iosns("value", queding).click();
        message=find(msg).getText();
        find_iosns("value", queding).click();

        return this;
    }

    public String getMessage(){
        return message;
    }

    public GgtPage gotoGgt() throws InterruptedException {

        find_accid(back).click();

        return new GgtPage();
    }
}
