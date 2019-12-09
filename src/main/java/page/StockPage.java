package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class StockPage extends BasePage{

    By fanhui=By.xpath("//android.widget.ImageView[@instance=0]");
    //uiautomator2 无法用上面的instance=0定位，只有用下面这个（定位很慢）
    //By fanhui=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView");

    public StockPage addZixuan() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(Driver.getCurrentDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(text("加自选")));
        find(By.xpath("//android.widget.TextView[@text='加自选']")).click();
        return this;
    }

    public SearchPage gotoSearch() throws InterruptedException {
        find(fanhui).click();
        return new SearchPage();
//        后退方法：无法处理下次再说的那个弹窗
//        try {
//            Driver.getCurrentDriver().navigate().back();
//            return new SearchPage();
//        }catch(Exception e){
//            Driver.getCurrentDriver().findElement(text("下次再说")).click();
//            Driver.getCurrentDriver().navigate().back();
//            return new SearchPage();
        }
    }
