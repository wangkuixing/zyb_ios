package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.xingu.XinguPage;
import page.xingu.XinzhaiPage;

public class YjdxPage extends BasePage{

    public XinguPage gotoXgsg() throws InterruptedException {

        find_accid("新股申购").click();

        return new XinguPage();
    }

    public XinzhaiPage gotoXinzhai() throws InterruptedException {

        find_accid("债券申购").click();

        return new XinzhaiPage();
    }

    public TradePage gotoTrade() throws InterruptedException {

        String back="TZTnavbarbackbg 1@2x";

        find_accid(back).click();
        return new TradePage();
    }
}
