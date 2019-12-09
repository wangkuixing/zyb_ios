package page.ggt;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class GgtPage extends BasePage {

    public BuyggtPage gotoBuy() throws InterruptedException {
        find_accid("港股通买入").click();

        return new BuyggtPage();
    }

    public SaleggtPage gotoSale() throws InterruptedException {

        find_accid("港股通卖出").click();

        return new SaleggtPage();
    }

    public GgchedanPage gotoChedan() throws InterruptedException {

        find_accid("港股撤单").click();

        return new GgchedanPage();
    }

    public VoteggPage gotoVote() throws InterruptedException {

        find_accid("投票申报").click();

        return new VoteggPage();
    }

    public GsxwPage gotoGsxx() throws InterruptedException {

        find_accid("公司行为").click();

        return new GsxwPage();
    }

    public TradePage gotoTrade() throws InterruptedException {

        String back="TZTnavbarbackbg 1@2x";
        find_accid(back).click();

        return new TradePage();
    }
}
