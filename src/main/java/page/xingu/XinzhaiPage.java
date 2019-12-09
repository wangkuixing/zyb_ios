package page.xingu;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import page.YjdxPage;

public class XinzhaiPage extends BasePage {

    public XinzhaiPage xinzhaiTest() throws InterruptedException {
        By sg=By.id("申购");
        By zwsj=By.id("暂无数据");
        By ljsg=By.id("立即申购");

        Thread.sleep(5000);
        if (isElementExist(zwsj)){
            return this;
        } else{
            //todo
            find(text("754421")).click();
            find(text("754313")).click();
            find(text("申购")).click();
            find(text("立即申购")).click();

            try{
                find(text("委托已提交"));
            }catch (NoSuchElementException e){}

            By qr=text("确认");
            WebDriverWait wait=new WebDriverWait(Driver.getCurrentDriver(),10);
            wait.until(ExpectedConditions.presenceOfElementLocated(qr));
            find(qr).click();

            return this;
        }
    }

    public YjdxPage gotoYjdx() throws InterruptedException {

        String back="TZTnavbarbackbg 1@2x";

        find_accid(back).click();
        return new YjdxPage();
    }
}
