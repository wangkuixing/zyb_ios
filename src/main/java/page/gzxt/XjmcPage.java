package page.gzxt;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class XjmcPage extends BasePage {

    String stockedit="输入证券代码";
    By buyamount=By.xpath("//*/XCUIElementTypeOther[4]/XCUIElementTypeScrollView/XCUIElementTypeButton[6]");
    String xjmc="限价卖出";
    String nike="我已阅读并确认《产品或服务风险警示投资者确认书》";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String queding="确定";
    String back="TZTnavbarbackbg 1@2x";

    String message;

    public XjmcPage saleGz(String stockcode) throws InterruptedException {

        sendKey("iosns", stockedit, stockcode);
        find(buyamount).click();
        find_iosns("value", xjmc).click();
        find_iosns("value", queding).click();
        message=find(msg).getText();

        return this;
    }

    public String getMessage(){
        return message;
    }

    public GzPage gotoGz() throws InterruptedException {

        find_accid(back).click();
        return new GzPage();
    }
}
