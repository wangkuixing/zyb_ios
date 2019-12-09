package page.ggt;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class VoteggPage extends BasePage {

    String hgt="沪港通公司投票申报";
    String sgt="深港通公司投票申报";
    String none="暂无可选议案编号";
    By yabh=By.xpath("//*/XCUIElementTypeOther[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther");
    By zcsl=By.xpath("//*/XCUIElementTypeOther[6]/XCUIElementTypeOther[2]/XCUIElementTypeTextField");
    By fdsl=By.xpath("//android.view.View[7]/android.view.View[2]/android.widget.EditText");
    By qqsl=By.xpath("//android.view.View[8]/android.view.View[2]/android.widget.EditText");
    String tpsb="投票申报";
    String queding="确定";
    By msg=By.xpath("(//XCUIElementTypeStaticText)[1]");
    String back="TZTnavbarbackbg 1@2x";

    String message1;
    String message2;

    public VoteggPage voteHgt() throws InterruptedException {

        find_accid(hgt).click();
        //显式等待议案编号
        waituntil(yabh);
        if (find(yabh).getText().contains(none)){
            find_accid(back).click();
            message1=none;
        } else {
            find(zcsl).sendKeys("1");
            find_accid(tpsb).click();
            find_accid("完成").click();
            find_iosns("value", queding).click();
            message1=find(msg).getText();
            find_iosns("value", queding).click();
            find_accid(back).click();
        }
        return this;
    }

    public VoteggPage voteSgt() throws InterruptedException {

        find_accid(sgt).click();
        //显式等待议案编号
        waituntil(yabh);
        if (find(yabh).getText().contains(none)){
            find_accid(back).click();
            message2=none;
        }
        else
        {
            find(zcsl).sendKeys("1");
            find_accid(tpsb).click();
            find_accid("完成").click();
            find_iosns("value", queding).click();
            message2=find(msg).getText();
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
