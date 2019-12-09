package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;

public class JjshPage extends BasePage {

    String jjdm="请输入基金代码";
    String shfe="请输入赎回份额";
    String queding="确定";
    By ok=By.xpath("//XCUIElementTypeStaticText[@name='确定']");
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String back="TZTnavbarbackbg 1@2x";
    String message;

    public JjshPage jjSh(String stockcode, String amount) throws InterruptedException {

        find_iosns("value", jjdm).sendKeys(stockcode);
        find_iosns("value", shfe).sendKeys(amount);
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
