package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;

public class JjrgPage extends BasePage {

    String jjdm="请输入基金代码";
    String rgje="请输入认购金额";
    String queding="确定";
    String sign="《适当性匹配意见及投资者确认书》";
    String queren="确认";
    By confirm=By.xpath("(//XCUIElementTypeStaticText[@name='确定'])[2]");
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    By ok=By.xpath("//XCUIElementTypeStaticText[@name='确定']");
    String back="TZTnavbarbackbg 1@2x";

    String message;

    public JjrgPage jjRg(String stockcode, String amount) throws InterruptedException {

        find_iosns("value", jjdm).sendKeys(stockcode);
        find_iosns("value", rgje).sendKeys(amount);
        find_accid(queding).click();
        find_accid(sign).click();
        find_accid(queren).click();
        find(confirm).click();

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
