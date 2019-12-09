package page.cnjj;

import org.openqa.selenium.By;
import page.BasePage;

public class CnjjshPage extends BasePage {

    String jjdm="请输入基金代码";
    String shfe="请输入赎回份额";
    String queding="确定";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    By ok=By.xpath("//XCUIElementTypeStaticText[@name='确定']");
    String back="TZTnavbarbackbg 1@2x";
    String message;


    public CnjjshPage jjSh(String stockcode, String amount) throws InterruptedException {
        find_iosns("value", jjdm).sendKeys(stockcode);
        find_iosns("value", shfe).click();
        find_iosns("value", shfe).sendKeys(amount);
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
