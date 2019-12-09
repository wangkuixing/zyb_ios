package page;

import org.openqa.selenium.By;

public class SalePage extends BasePage{

    String stockedit="输入证券代码";
    By stockamount=By.xpath("//*/XCUIElementTypeOther[4]/XCUIElementTypeScrollView/XCUIElementTypeButton[6]");
    String ljmc="立即卖出";
    By mc=By.xpath("//XCUIElementTypeStaticText[@name='卖出']");
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String queding="确定";
    String back="TZTnavbarbackbg 1@2x";

    String message;

    public SalePage SaleTest(String stockcode, String stockamount) throws InterruptedException {

        sendKey("iosns", stockedit, stockcode);
        find(this.stockamount).click();
        find_accid(ljmc).click();
        find(mc).click();
        message=find(msg).getText();
        find_accid(queding).click();

        return new SalePage();
    }

    public String getMessage(){
        return message;
    }

    public TradePage gotoTrade() throws InterruptedException {

        find_accid(back).click();

        return new TradePage();
    }
}
