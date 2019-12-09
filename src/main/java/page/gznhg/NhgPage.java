package page.gznhg;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class NhgPage extends BasePage {

    public SznhgPage gotoSz() throws InterruptedException {
        find_accid("Ｒ-001 131810").click();

        return new SznhgPage();
    }

    public ShnhgPage gotoSh() throws InterruptedException {

        find_accid("沪市").click();
        find_accid("GC001 204001").click();

        return new ShnhgPage();
    }

    public TradePage gotoTrade() throws InterruptedException {

        String back="TZTnavbarbackbg 1@2x";
        find_accid(back).click();

        return new TradePage();
    }
}
