package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;

public class JjzhPage extends BasePage {

    String zcjj="选择转出基金";
    String select="完成";
    String zrjj="请输入转入基金";
    String zhfe="请输入转换份额";
    String queding="确定";
    By ok=By.xpath("//XCUIElementTypeStaticText[@name='确定']");
//    String msg="基金转换委托已提交";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String back="TZTnavbarbackbg 1@2x";

    String message;

    public JjzhPage jjZh(String stkcode, String amount) throws InterruptedException {

        find_iosns("value", zcjj).click();
        swipeControl(9/10, 8/10);
        find_accid(select).click();
        find_iosns("value", zrjj).sendKeys(stkcode);
        find_iosns("value", zhfe).sendKeys(amount);
        find_accid(queding).click();
        find(ok).click();

        message=find(msg).getText();
        find(ok).click();
        return this;
    }

    public String getMessage(){
        return message;
    }

    public KfsjjPage gotoKfsjj() throws InterruptedException {

        find_accid(back).click();
        return new KfsjjPage();
    }
}
