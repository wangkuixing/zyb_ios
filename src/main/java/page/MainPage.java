package page;


import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends BasePage{
    By hq=name("tzt toolbar marketForW@2x");
    By trade=name("tzt toolbar tradeForW@2x");

    public static MainPage start(){
        Driver.start();
        return new MainPage();
    }

    public HqPage gotoHq() throws InterruptedException {
//        WebDriverWait wait=new WebDriverWait(Driver.getCurrentDriver(),10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(hq));

        find(hq).click();
        return new HqPage();

    }

    public TradePage gotoTrade() throws InterruptedException {
        find(trade).click();
        return new TradePage();
    }

    public SearchPage gotoSearch(){
        Driver.getCurrentDriver().findElement(By.id("home_search")).click();
        return new SearchPage();
    }

    public ZixuanPage gotoZixuan() throws InterruptedException {
        find(text("自选")).click();
        return new ZixuanPage();
    }
}

