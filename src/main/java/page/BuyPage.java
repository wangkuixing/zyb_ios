package page;

import driver.Driver;
import org.openqa.selenium.By;

public class BuyPage extends BasePage{

//    By stockedit=By.xpath("//*/XCUIElementTypeOther[4]/XCUIElementTypeScrollView[1]/XCUIElementTypeTextField[1]");
    String stockedit="输入证券代码";
    By buyamount=By.xpath("//*/XCUIElementTypeOther[4]/XCUIElementTypeScrollView/XCUIElementTypeButton[6]");
    String ljmr="立即买入";
    By mr=By.xpath("//XCUIElementTypeStaticText[@name='买入']");
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String queding="确定";
    String back="TZTnavbarbackbg 1@2x";
//    By back=By.xpath("//android.widget.Button");

    String message;


    public BuyPage buyTest(String stockcode) throws InterruptedException {

        sendKey("iosns", stockedit, stockcode);
        find(buyamount).click();
        find_accid(ljmr).click();
        find(mr).click();
        message=find(msg).getText();
        find_accid(queding).click();

        return this;
    }

    public String getMessage(){
        return message;
    }

    public TradePage gotoTrade() throws InterruptedException {

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        find_accid(back).click();
//        Driver.getCurrentDriver().findElements(back).get(0).click();
        return new TradePage();
    }
}
