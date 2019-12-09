package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SearchPage extends BasePage{
    public SearchPage search(String keyword) throws InterruptedException {
        find(By.id("tz_searchstock_edit")).sendKeys(keyword);
        return this;
    }

    public HqPage cancel() throws InterruptedException {
        find(By.id("tz_searchstock_backup")).click();
        return new HqPage();
    }

    public ArrayList<String> getAll(){
        ArrayList<String> array=new ArrayList<>();
        for(WebElement e: Driver.getCurrentDriver().findElements(By.id("stockName"))){
            array.add(e.getText());
        }
        return array;
    }

    public SearchPage getStock(){
        return this;

    }

    public SearchPage addSelected() throws InterruptedException {
        find(By.id("tzt_querystock_list_col3")).click();
        return this;

    }

    public SearchPage removeSelected(){
        return this;

    }

    public StockPage gotoStock(String stockname) throws InterruptedException {
        //By searchresult=By.xpath("//android.widget.RelativeLayout[@instance=8]");
//        By searchresult=By.xpath("//*[@resource-id='stockName' and @text='"+stockname+"']");
        By searchresult=By.id("stockName");
        find(searchresult).click();
        return new StockPage();
    }

}
