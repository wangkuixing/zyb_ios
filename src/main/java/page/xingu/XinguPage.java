package page.xingu;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import page.YjdxPage;

public class XinguPage extends BasePage{

    public  XinguPage xinguTest() throws InterruptedException {
        By sg=By.id("申购");
        By zwsj=By.id("暂无数据");
        By ljsg=By.id("立即申购");


        Thread.sleep(5000);
        if (isElementExist(zwsj)){
            return this;
        } else{
            waituntil(sg);
            find(sg).click();

            find(ljsg).click();

            //todo: 要新股数据,需修改
            try{
                find(text("委托已提交"));
            }catch(NoSuchElementException e){}

            find(text("确认")).click();

            return this;
        }
    }

    public YjdxPage gotoYjdx() throws InterruptedException {

        String back="TZTnavbarbackbg 1@2x";

        find_accid(back).click();
        return new YjdxPage();
    }
}
