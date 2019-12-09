package page.hbjj;

import org.openqa.selenium.By;
import page.BasePage;

public class HbjjPage extends BasePage {

    String jjsg="基金申购";
    String jjsh="基金赎回";

    public HbjjsgPage gotoSg() throws InterruptedException {
        find_accid(jjsg).click();
        return new HbjjsgPage();
    }

    public HbjjshPage gotoSh() throws InterruptedException {
        find_accid(jjsh).click();
        return new HbjjshPage();
    }
}
