package page.cnjj;

import org.openqa.selenium.By;
import page.BasePage;
import page.hbjj.HbjjPage;
import page.hbjj.HbjjsgPage;

public class CnjjrgPage extends BasePage {

    String jjdm="请输入基金代码";
    String rgfe="请输入认购份额";
    String queding="确定";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    By ok=By.xpath("//XCUIElementTypeStaticText[@name='确定']");
    String back="TZTnavbarbackbg 1@2x";
    String message;

    public CnjjrgPage jjRg(String stockcode, String amount) throws InterruptedException {
        find_iosns("value", jjdm).sendKeys(stockcode);
        find_iosns("value", rgfe).click();
        find_iosns("value", rgfe).sendKeys(amount);
        find_accid(queding).click();
        waituntil(ok);
        find(ok).click();

        message=find(msg).getText();
        find(ok).click();
        return this;
    }

    public String getMessage(){
        return message;
    }

    public CnjjPage gotoCnjj() throws InterruptedException {

        find_accid(back).click();
        return new CnjjPage();
    }

}
