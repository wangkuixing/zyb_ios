package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;

public class JjdtPage extends BasePage {

    By jjdm=By.xpath("//*/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeTextField");
    String done="完成";
    String amount="输入定投金额";
    By dtje=By.xpath("//android.view.View[6]/android.view.View[2]/android.widget.EditText");
    String queding="确定";
    By ok=By.xpath("//XCUIElementTypeStaticText[@name='确定']");
//    String msg="基金定投开户请求已提交!";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String back="TZTnavbarbackbg 1@2x";

    String message;

    public JjdtPage jjDt(String stkcode, String amount) throws InterruptedException {

        find(jjdm).click();
        swipeControl(663/736, 620/736);
        find_accid(done).click();
        find_iosns("value", this.amount).sendKeys(amount);
        find_accid(done).click();
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
