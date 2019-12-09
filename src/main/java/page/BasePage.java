package page;

import driver.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static WebElement find(By locator) throws InterruptedException {
        Thread.sleep(3000);
        try {
            return Driver.getCurrentDriver().findElement(locator);
        }catch(Exception e){
            e.printStackTrace();
            //if (Driver.getCurrentDriver().findElement(By.xpath("//android.widget.TextView[contains(@text, '获取栏目列表信息失败')]")))
            Driver.getCurrentDriver().findElement(name("确定")).click();
            return Driver.getCurrentDriver().findElement(locator);
        }
    }

    public static By locate(String locator){
        if(locator.matches("/.*")){
            return By.xpath(locator);
        }else{
            return By.id(locator);
        }
    }


    //*[@name="tzt toolbar marketForW@2x"]

    public static By text(String content){
        return By.xpath("//*[@text='"+ content + "']");
    }

    public static By name(String content){
        return By.xpath("//*[@name='"+ content + "']");
    }

    public static WebElement find_accid(String desc) throws InterruptedException {
        Thread.sleep(3000);
        try {
            return Driver.getCurrentDriver().findElementByAccessibilityId(desc);
        }catch(Exception e){
            e.printStackTrace();
            //if (Driver.getCurrentDriver().findElement(By.xpath("//android.widget.TextView[contains(@text, '获取栏目列表信息失败')]")))
            Driver.getCurrentDriver().findElement(name("确定")).click();
            return Driver.getCurrentDriver().findElementByAccessibilityId(desc);
        }
    }

    public static WebElement find_iosns(String item, String desc) throws InterruptedException {
        Thread.sleep(3000);
        try {
            return Driver.getCurrentDriver().findElementByIosNsPredicate("" + item + "  CONTAINS  '" + desc + "'");
        }catch(Exception e){
            e.printStackTrace();
            //if (Driver.getCurrentDriver().findElement(By.xpath("//android.widget.TextView[contains(@text, '获取栏目列表信息失败')]")))
            Driver.getCurrentDriver().findElement(name("确定")).click();
            return Driver.getCurrentDriver().findElementByIosNsPredicate("" + item + "  CONTAINS  '" + desc + "'");
        }
    }

    public Boolean isElementExist(By locator){
        try{
            Driver.getCurrentDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public Boolean isAccidExist(String name){
        try{
            Driver.getCurrentDriver().findElementByAccessibilityId(name);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    //IOS app修改了输入框默认键盘布局，无法调用appium的sendKeys方法，通过这个方法处理,可选择3种定位方式：accid,iosNsPredicate,Xpath
    public void sendKey(String item, String locator, String key) throws InterruptedException {
        if (item == "accid"){
            find_accid(locator).click();
            find_iosns("value", "ABC").click();
            find_accid(locator).clear();
            find_accid(locator).sendKeys(key);
        } else if (item == "iosns"){
            find_iosns("value", locator).click();
//            find(By.xpath("//XCUIElementTypeStaticText[@name='ABC']")).click();
            find_iosns("value", "ABC").click();
            find_iosns("value", locator).clear();
            find_iosns("value", locator).sendKeys(key);
        } else if (item == "xpath"){
            find(By.xpath(locator)).click();
//            find(By.xpath("//XCUIElementTypeStaticText[@name='ABC']")).click();
            find_iosns("value", "ABC").click();
            find(By.xpath(locator)).clear();
            find(By.xpath(locator)).sendKeys(key);
        }
    }

    //封装显式等待
    public static WebElement waituntil(By locator){
        WebDriverWait wait=new WebDriverWait(Driver.getCurrentDriver(),10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //上滑页面从3/4位置滑动到1/4
    public void swipeControl(int from, int to){

        int width=Driver.getCurrentDriver().manage().window().getSize().width;
        int height=Driver.getCurrentDriver().manage().window().getSize().height;
        int y1=height * from;
        int y2=height * to;

        PointOption po1=new PointOption();
        po1.withCoordinates(width/2,y1);

        PointOption po2=new PointOption();
        po2.withCoordinates(width/2,y2);

        Duration duration=Duration.ofNanos(2000);

        WaitOptions wait=new WaitOptions();
        wait.withDuration(duration);

        TouchAction taction=new TouchAction(Driver.getCurrentDriver());
        taction.press(po1).waitAction(wait).moveTo(po2).release().perform();

    }

}
