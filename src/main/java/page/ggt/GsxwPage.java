package page.ggt;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class GsxwPage extends BasePage {

    String hgt="沪港通公司行为申报";
    String sgt="深港通公司行为申报";
    By xwdm=By.xpath("//*/XCUIElementTypeOther[6]/XCUIElementTypeOther[2]/XCUIElementTypeOther");
    String none="无可选行为代码";
    By sbsl=By.xpath("//*/XCUIElementTypeOther[7]/XCUIElementTypeOther[2]/XCUIElementTypeTextField");

    By sb=By.xpath("//XCUIElementTypeStaticText[@name='申报']");
    String queding="确定";
    String msg="请求";
    String back="TZTnavbarbackbg 1@2x";

    String message1;
    String message2;

    public GsxwPage gsxwHgt() throws InterruptedException {

        find_accid(hgt).click();
        //显式等待行为代码
        waituntil(xwdm);
        if (find(xwdm).getText().contains(none)){
            find_accid(back).click();
            message1=none;
        }
        else
        {
            find(sbsl).sendKeys("1");
            find(sb).click();
            find_iosns("value", queding).click();
            message1=find_iosns("name", msg).getText();
            find_iosns("value", queding).click();
            find_accid(back).click();
        }
        return this;
    }


    public GsxwPage gsxwSgt() throws InterruptedException {

        find_accid(sgt).click();
        //显式等待行为代码
        waituntil(xwdm);
        if (find(xwdm).getText().contains(none)){
            find_accid(back).click();
            message2=none;
        }
        else
        {
            find(sbsl).sendKeys("1");
            find(sb).click();
            find_iosns("value", queding).click();
            message2=find_iosns("name", msg).getText();
            find_iosns("value", queding).click();
            find_accid(back).click();
        }
        return this;
    }

    public String getMessage1(){
        return message1;
    }

    public String getMessage2(){
        return message2;
    }

    public GgtPage gotoGgt() throws InterruptedException {
        find_accid(back).click();
        return new GgtPage();
    }
}
