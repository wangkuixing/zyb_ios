package page;

import org.openqa.selenium.By;

public class CdbuyPage extends BasePage{

    By stockedit=By.id("tzt_trade_edit_stockcode");
    //By buyamount=By.id("tzt_trade_linear_count_addcount_icon");

    By buyamount=By.xpath("//android.widget.EditText[contains(@text, '可买')]");
    By ljcd=text("立即拆单");
    By randombtn=By.id("randomradiobutton");
    By randomedit=By.id("random_edit");
    By mr=text("立即买入");
    By msg=By.xpath("//android.widget.TextView[contains(@text, '委托已提交')]");
    By queding=text("确定");
    By back=By.xpath("//android.widget.Button[@text!='立即拆单']");

    String message1;
    String message2;

    //均分拆单
    public CdbuyPage jfTest(String stockcode) throws InterruptedException {

        find(stockedit).sendKeys(stockcode);
        find(buyamount).sendKeys("3700");
        find(ljcd).click();
        find(mr).click();
        find(queding).click();
        message1=find(msg).getText();
        find(queding).click();

        return this;
    }

    //随机拆单
    public CdbuyPage randomTest(String stockcode) throws InterruptedException {

        find(stockedit).sendKeys(stockcode);
        find(buyamount).sendKeys("20200");
        find(ljcd).click();
        find(randombtn).click();
        find(randomedit).sendKeys("3");
        find(mr).click();
        find(queding).click();
        message2=find(msg).getText();
        find(queding).click();

        return this;
    }

    public String getMessage1(){
        return message1;
    }

    public String getMessage2(){
        return message2;
    }

    public MorePage gotoMore() throws InterruptedException {
        find(back).click();
        return new MorePage();
    }

}
