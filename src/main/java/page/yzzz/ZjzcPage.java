package page.yzzz;

import org.openqa.selenium.By;
import page.BasePage;

public class ZjzcPage extends BasePage {

    String zzje="请输入您的转账金额";
    String fundpwd="请输入您的资金密码";
    String ljzz="立即转账";
    String queding="确定";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String back="TZTnavbarbackbg 1@2x";

    String message;



    public ZjzcPage zqtoYh() throws InterruptedException {

        find_iosns("value", zzje).sendKeys("222");
        find_iosns("value", fundpwd).sendKeys("123321");
        find_accid(ljzz).click();
        find_iosns("value", queding).click();
        message=find(msg).getText();
        find_iosns("value", queding).click();

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
