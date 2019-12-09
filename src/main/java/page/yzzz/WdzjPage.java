package page.yzzz;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import page.BasePage;

public class WdzjPage extends BasePage {

    String back="TZTnavbarbackbg 1@2x";

    public Boolean wdZj() throws InterruptedException {

        try{
            find_accid("人民币");
            find_iosns("value", "余额");

            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public YzzzPage gotoYzzz() throws InterruptedException {

        find_accid(back).click();
        return new YzzzPage();
    }
}
