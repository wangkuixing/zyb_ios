package page.kfsjj;

import org.openqa.selenium.By;
import page.BasePage;
import page.TradePage;

public class KfsjjPage extends BasePage {

    String jjsg="基金申购";
    String jjsh="基金赎回";
    String jjrg="基金认购";
    String cxwt="撤销委托";
    String fhsz="分红设置";
    String jjzh="基金转换";
    String dt="定投登记";
    String dtqx="定投取消";
    String back="TZTnavbarbackbg 1@2x";

    public JjsgPage gotoJjsg() throws InterruptedException {

        find_accid(jjsg).click();
        return new JjsgPage();
    }

    public JjshPage gotoJjsh() throws InterruptedException {

        find_accid(jjsh).click();
        return new JjshPage();
    }

    public JjrgPage gotoJjrg() throws InterruptedException {

        find_accid(jjrg).click();
        return new JjrgPage();
    }

    public JjcdPage gotoJjcd() throws InterruptedException {

        find_accid(cxwt).click();
        return new JjcdPage();
    }
    public FhszPage gotoFhsz() throws InterruptedException {

        find_accid(fhsz).click();
        return new FhszPage();
    }

    public JjzhPage gotoJjzh() throws InterruptedException {

        find_accid(jjzh).click();
        return new JjzhPage();
    }

    public JjdtPage gotoJjdt() throws InterruptedException {

        find_accid(dt).click();
        return new JjdtPage();
    }

    public JjdtqxPage gotoJjdtqx() throws InterruptedException {

        find_accid(dtqx).click();
        return new JjdtqxPage();
    }

    public TradePage gotoTrade() throws InterruptedException {

        find_accid(back).click();
        return new TradePage();
    }
}
