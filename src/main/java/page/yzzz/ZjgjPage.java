package page.yzzz;

import org.openqa.selenium.By;
import page.BasePage;

public class ZjgjPage extends BasePage {

    By zjgj=By.xpath("(//XCUIElementTypeStaticText[@name='资金归集'])[2]");
    By zjgjqr=By.xpath("(//XCUIElementTypeStaticText[@name='资金归集'])[4]");
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String queding="确定";
    String back="TZTnavbarbackbg 1@2x";


    String message;

    public ZjgjPage zjGj() throws InterruptedException {

        find(zjgj).click();
        find(zjgjqr).click();
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
