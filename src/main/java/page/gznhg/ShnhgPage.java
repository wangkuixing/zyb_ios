package page.gznhg;

import org.openqa.selenium.By;
import page.BasePage;

public class ShnhgPage extends BasePage {

    By amount=By.xpath("//*/XCUIElementTypeOther[4]/XCUIElementTypeScrollView/XCUIElementTypeButton[6]");
    String ljmc="立即卖出";
    By mc=By.xpath("//XCUIElementTypeStaticText[@name='卖出']");
//    String msg="委托";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String queding="确定";
    String back="TZTnavbarbackbg 1@2x";
    String stkcode="输入证券代码";

    String message1;
    String message2;

    public ShnhgPage weituo204xxx() throws InterruptedException {
        find(amount).click();
        find_iosns("value", ljmc).click();
        find(mc).click();
        message1=find(msg).getText();
        find_iosns("value", queding).click();

        sendKey("iosns", stkcode, "204014");
        find(amount).click();
        find_iosns("value", ljmc).click();
        find(mc).click();
        message2=find(msg).getText();
        find_iosns("value", queding).click();

        return this;

    }

    public String getMessage1(){
        return message1;
    }

    public String getMessage2(){

        return message2;
    }

    public NhgPage gotoNhg() throws InterruptedException {

        find_accid(back).click();
        return new NhgPage();
    }
}
