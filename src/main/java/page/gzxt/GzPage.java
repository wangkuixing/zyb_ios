package page.gzxt;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class GzPage extends BasePage {

    By xjmr=By.xpath("(//XCUIElementTypeStaticText[@name='限价买入'])[1]");
    By xjmc=By.xpath("(//XCUIElementTypeStaticText[@name='限价卖出'])[1]");
    String gzcd="股转撤单";
    String back="TZTnavbarbackbg 1@2x";

    public XjmrPage gotoXjmr() throws InterruptedException {

        find(xjmr).click();
        return new XjmrPage();
    }

    public XjmcPage gotoXjmc() throws InterruptedException {

        find(xjmc).click();
        return new XjmcPage();
    }

    public GzcdPage gotoGzcd() throws InterruptedException {

        find_accid(gzcd).click();
        return new GzcdPage();
    }

    public TradePage gotoTrade() throws InterruptedException {

        find_accid(back).click();
        return new TradePage();
    }
}
