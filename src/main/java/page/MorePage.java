package page;

import org.openqa.selenium.By;

public class MorePage extends BasePage{

    String back="TZTnavbarbackbg 1@2x";

    public CdbuyPage gotocdBuy() throws InterruptedException {
        find_accid("拆单买入").click();
        return new CdbuyPage();
    }

    public CdsalePage gotocdSale() throws InterruptedException {
        find_accid("拆单卖出").click();
        return new CdsalePage();
    }

    public TradePage gotoTrade() throws InterruptedException {
        find_accid(back).click();
        return new TradePage();
    }
}
