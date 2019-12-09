package page;

import driver.Driver;
import org.openqa.selenium.By;


public class LoginPage extends BasePage{

    String username="//*/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField";
    String password="请输入密码";
    String loginbtn="登 录";

    String message;

//    public LoginPage passwordFail(String username, String password){
//        find(shouji).click();
//        find(youxiang).click();
//        find(this.username).sendKeys(username);
//        find(this.password).sendKeys(password);
//        find(loginbtn).click();
//        message=find(msg).getText();
//        find(By.id("md_buttonDefaultPositive")).click();
//
//        return this;
//    }

    public TradePage passwordSuccess(String username, String password) throws InterruptedException {

        sendKey("xpath", this.username, username);
        sendKey("iosns", this.password, password);
        find_accid(loginbtn).click();

        return new TradePage();
    }


    public String getMessage(){
        return message;
    }

}
