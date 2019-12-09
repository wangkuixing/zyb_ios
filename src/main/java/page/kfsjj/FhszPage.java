package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;

public class FhszPage extends BasePage {

    String jjmc="选择基金名称";
    String select="完成";
    String fhfs="分红方式";
    String queding="确定";
    By ok=By.xpath("//XCUIElementTypeStaticText[@name='确定']");
//    String msg="基金分红变更委托已提交!";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String back="TZTnavbarbackbg 1@2x";

    String message;

    public FhszPage jjFh() throws InterruptedException {

        find_iosns("value", jjmc).click();
        swipeControl(9/10, 8/10);
        find_accid(select).click();
        find_iosns("value", fhfs).click();
        swipeControl(9/10, 8/10);
        find_accid(select).click();
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
