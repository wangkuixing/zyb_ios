package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ChaxunPage extends BasePage{

    public Boolean chaxunTest() throws InterruptedException {

        try{
           find_accid("人民币");
           return true;
        }
        catch (NoSuchElementException e){
            return false;
        }

    }

    public TradePage gotoTrade() throws InterruptedException {
        String back="TZTnavbarbackbg 1@2x";

        find_accid(back).click();
        return new TradePage();
    }
}
