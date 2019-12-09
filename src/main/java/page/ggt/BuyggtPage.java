package page.ggt;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;


public class BuyggtPage extends BasePage {

    String stockedit="输入证券代码";
    //By hgtacct=text("A445206425 (沪HK)");
    String hgtacct="A445206425(沪HK)";
    //By sgtacct=text("0128208140 (深HK)");
    String sgtacct="0128208140(深HK)";
    By buyamount=By.xpath("//*/XCUIElementTypeOther[4]/XCUIElementTypeScrollView/XCUIElementTypeButton[4]");
    String ljmr="立即买入";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String queding="确定";
    String back="TZTnavbarbackbg 1@2x";

    String message1;
    String message2;


    public BuyggtPage buyHgt(String stockcode) throws InterruptedException {

        sendKey("iosns", stockedit, stockcode);
        find_accid(hgtacct).click();
        find(buyamount).click();
        find_iosns("value", ljmr).click();
        find_iosns("value", queding).click();

        message1=find(msg).getText();
        find_iosns("value", queding).click();

        return this;
    }

    public BuyggtPage buySgt(String stockcode) throws InterruptedException {

//        waituntil(By.xpath("//*/XCUIElementTypeOther[4]/XCUIElementTypeScrollView/XCUIElementTypeTextField[1]"));
        find_iosns("value", stockedit).sendKeys(stockcode);
        find_accid(sgtacct).click();
        find(buyamount).click();
        find_iosns("value", ljmr).click();
        find_iosns("value", queding).click();

        message2=find(msg).getText();
        find_iosns("value", queding).click();

        return this;
    }

    public String getMessage1(){
        return message1;
    }

    public String getMessage2(){
        return message2;
    }

    public GgtPage gotoGgt() throws InterruptedException {

        find_accid(back).click();
        return new GgtPage();
    }
}
