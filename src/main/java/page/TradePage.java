package page;

import driver.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import page.cnjj.CnjjPage;
import page.ggt.BuyggtPage;
import page.ggt.GgtPage;
import page.gznhg.NhgPage;
import page.gzxt.GzPage;
import page.hbjj.HbjjPage;
import page.kfsjj.KfsjjPage;
import page.yzzz.YzzzPage;

import java.time.Duration;

public class TradePage extends BasePage {

    public  LoginPage gotoLogin() throws InterruptedException {

        find_accid("买入").click();
        return new LoginPage();
    }

    public  BuyPage gotoBuy() throws InterruptedException {

        find_accid("买入").click();
        return new BuyPage();
    }

    public  SalePage gotoSale() throws InterruptedException {

        find_accid("卖出").click();
        return new SalePage();
    }

    public ChedanPage gotoChedan() throws InterruptedException {

        find_accid("撤单").click();
        return new ChedanPage();
    }

    public ChaxunPage gotoChaxun() throws InterruptedException {

        find_accid("查询资金").click();
        return new ChaxunPage();
    }

    public ChicangPage gotoChicang() throws InterruptedException {

        find_accid("我的持仓").click();
        return new ChicangPage();
    }

    public MorePage gotoMore() throws InterruptedException {

        find_accid("更多").click();
        return new MorePage();
    }

    public YjdxPage gotoYjdx() throws InterruptedException {

        find_accid("一键打新").click();
        return new YjdxPage();
    }

    public NhgPage gotoNhg() throws InterruptedException {

        find_accid("国债逆回购").click();
        return new NhgPage();
    }

    public YzzzPage gotoYzzz() throws InterruptedException {

        find_accid("银证转账").click();
//        find(By.xpath("//android.view.View[@text='银证转账']")).click();
        return new YzzzPage();
    }

    public GgtPage gotoGgt() throws InterruptedException {

        find_accid("港股通交易").click();
        return new GgtPage();
    }

    public GzPage gotoGz() throws InterruptedException {

        find_accid("股转业务").click();
        return new GzPage();
    }

    public KfsjjPage gotoKfsjj() throws InterruptedException {

        swipeControl(3/4, 1/4);
        find_accid("开放式基金").click();
        return new KfsjjPage();
    }

    public HbjjPage gotoHbjj() throws InterruptedException {

        find_accid("实时货币基金").click();
        return new HbjjPage();
    }

    public CnjjPage gotoCnjj() throws InterruptedException {

        swipeControl(3/4, 1/4);
        find_accid("场内基金").click();
        return new CnjjPage();
    }

    public TradePage logOut(String name) throws InterruptedException {

        find_accid(name).click();
        find_accid("确定").click();
        return new TradePage();
    }



//    //上滑页面从3/4位置滑动到1/4
//    public void swipeControl(int from, int to){
//
//        int width=Driver.getCurrentDriver().manage().window().getSize().width;
//        int height=Driver.getCurrentDriver().manage().window().getSize().height;
//        int y1=height * from;
//        int y2=height * to;
//
//        PointOption po1=new PointOption();
//        po1.withCoordinates(width/2,y1);
//
//        PointOption po2=new PointOption();
//        po2.withCoordinates(width/2,y2);
//
//        Duration duration=Duration.ofNanos(2000);
//
//        WaitOptions wait=new WaitOptions();
//        wait.withDuration(duration);
//
//        TouchAction taction=new TouchAction(Driver.getCurrentDriver());
//        taction.press(po1).waitAction(wait).moveTo(po2).release().perform();
//
//    }
}
