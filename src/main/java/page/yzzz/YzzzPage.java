package page.yzzz;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class YzzzPage extends BasePage {

    String zjzr="资金转入";
    String zjzc="资金转出";
    String wdzj="我的资金";
    String yhye="银行余额";
    String zjgj="资金归集";
    String zjdb="资金调拨";
    String back="TZTnavbarbackbg 1@2x";

    public ZjzrPage gotoZjzr() throws InterruptedException {

        find_accid(zjzr).click();
        return new ZjzrPage();
    }

    public ZjzcPage gotoZjzc() throws InterruptedException {

        find_accid(zjzc).click();
        return new ZjzcPage();
    }

    public WdzjPage gotoWdzj() throws InterruptedException {

        find_accid(wdzj).click();
        return new WdzjPage();
    }

    public YhyePage gotoYhye() throws InterruptedException {

        find_accid(yhye).click();
        return new YhyePage();
    }

    public ZjgjPage gotoZjgj() throws InterruptedException {

        find_accid(zjgj).click();
        return new ZjgjPage();
    }

    public ZjdbPage gotoZjdb() throws InterruptedException {

        find_accid(zjdb).click();
        return new ZjdbPage();
    }

    public TradePage gotoTrade() throws InterruptedException {

        find_accid(back).click();
        return new TradePage();
    }
}
