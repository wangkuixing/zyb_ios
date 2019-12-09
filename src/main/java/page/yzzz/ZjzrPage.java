package page.yzzz;

import org.openqa.selenium.By;
import page.BasePage;

public class ZjzrPage extends BasePage {

    String zzje="请输入您的转账金额";
    By yhmm=By.xpath("//android.view.View[6]/android.view.View[2]/android.widget.EditText");
    String ljzz="立即转账";
    String queding="确定";
//    String msg="转账请求已提交，请在资金流水中查询转账结果!";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String back="TZTnavbarbackbg 1@2x";

    String message;


    public ZjzrPage yhtoZq() throws InterruptedException {

        find_iosns("value", zzje).sendKeys("666");
//        find(yhmm).sendKeys("123321");
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
