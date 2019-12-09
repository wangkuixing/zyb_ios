package page.yzzz;

import org.openqa.selenium.By;
import page.BasePage;

public class ZjdbPage extends BasePage {

    By zrzh=By.xpath("//XCUIElementTypeOther[@name='资金调拨']/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]/XCUIElementTypeOther");
    String done="完成";
    String zzje="请输入您的转账金额";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String queding="确定";
    By queding2=By.xpath("//XCUIElementTypeStaticText[@name='确定']");
    String back="TZTnavbarbackbg 1@2x";


    String message;

    public ZjdbPage zjDb() throws InterruptedException {

        find(zrzh).click();
        swipeControl(9/10, 8/10);
        find_accid(done).click();
        find_iosns("value", zzje).sendKeys("333");
        find_accid(queding).click();
        find(queding2).click();
        message=find(msg).getText();
        find(queding2).click();
        return this;
    }

    public String getMessage(){

        return message;
    }

    public YzzzPage gotoYzzz() throws InterruptedException {
        find_accid(back).click();
        return new YzzzPage();
    }

    }

