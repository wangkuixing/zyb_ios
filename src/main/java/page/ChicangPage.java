package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ChicangPage extends BasePage{

    public Boolean chicangTest() throws InterruptedException {

        try {
            find_accid("证券市值");
            find_accid("持仓");
            find_accid("盈亏");
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public TradePage gotoTrade() throws InterruptedException {

        String back="TZTnavbarbackbg 1@2x";

        find_accid(back).click();
        return new TradePage();

    }
}
