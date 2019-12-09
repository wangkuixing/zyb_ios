package page.cnjj;

import org.openqa.selenium.By;
import page.BasePage;

public class CnjjPage extends BasePage {
    String cnrg="场内认购";
    String cnsg="场内申购";
    String cnsh="场内赎回";

    public CnjjrgPage gotoRg() throws InterruptedException {
        find_accid(cnrg).click();
        return new CnjjrgPage();
    }

    public CnjjsgPage gotoSg() throws InterruptedException {
        find_accid(cnsg).click();
        return new CnjjsgPage();
    }

    public CnjjshPage gotoSh() throws InterruptedException {
        find_accid(cnsh).click();
        return new CnjjshPage();
    }
}
