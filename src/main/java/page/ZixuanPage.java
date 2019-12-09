package page;

import driver.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class ZixuanPage extends BasePage{

    //取自选股票name到array中
    public ArrayList<String> judgeStockname(){
        ArrayList<String> array=new ArrayList<>();
        for (WebElement e: Driver.getCurrentDriver().findElements(By.id("portfolio_stockName"))){
            array.add(e.getText());
        }
        return array;
//        find(text(stockname)).isEnabled();
//        return this;
    }

    public ZixuanPage removeAdd(String stockname) throws InterruptedException {
        //长按longPress
        WebElement added=find(text(stockname));
        PointOption po=new PointOption();
        po.withCoordinates(added.getLocation().getX(),added.getLocation().getY());
        TouchAction action = new TouchAction(Driver.getCurrentDriver());
        action.longPress(po).release().perform();
        find(text("删除")).click();
        return this;
    }
}
