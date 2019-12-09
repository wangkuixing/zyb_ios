package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;

public class JjdtqxPage extends BasePage {

    By jjdm=By.xpath("//XCUIElementTypeOther[@name='定投取消']/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther");
    String done="完成";
    String queding="确定";
    By ok=By.xpath("//XCUIElementTypeStaticText[@name='确定']");
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String back="TZTnavbarbackbg 1@2x";

    String message;

    public JjdtqxPage jjDtqx() throws InterruptedException {

        find(jjdm).click();
        swipeControl(4/5, 1/2);
        find_accid(done).click();
        find_accid(queding).click();
        find(ok).click();
        message = find(msg).getText();
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
