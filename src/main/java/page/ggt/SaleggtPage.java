package page.ggt;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import page.SalePage;
import page.TradePage;

public class SaleggtPage extends BasePage {

    String stockedit="输入证券代码";
    //By hgtacct=text("A445206425 (沪HK)");
    String hgtacct="A445206425(沪HK)";
    By stockamount=By.xpath("//*/XCUIElementTypeOther[4]/XCUIElementTypeScrollView/XCUIElementTypeButton[4]");
    String ljmr="立即卖出";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String queding="确定";
    String back="TZTnavbarbackbg 1@2x";

    String message;

    public SaleggtPage saleHgt(String stockcode) throws InterruptedException {

        sendKey("iosns", stockedit, stockcode);
        find_accid(hgtacct).click();
        find(stockamount).click();
        find_iosns("value", ljmr).click();
        find_iosns("value", queding).click();

        message=find(msg).getText();
        find_iosns("value", queding).click();

        return this;
    }

    public SaleggtPage saleSgt(String stockcode) throws InterruptedException {

        find_iosns("value", stockedit).sendKeys(stockcode);
        find(stockamount).click();
        find_iosns("value", ljmr).click();
        find_iosns("value", queding).click();

        message=find(msg).getText();
        find_iosns("value", queding).click();

        return new SaleggtPage();
    }


    public String getMessage(){
        return message;
    }

    public GgtPage gotoGgt() throws InterruptedException {

        find_accid(back).click();

        return new GgtPage();
    }
}
