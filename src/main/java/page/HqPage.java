package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class HqPage extends BasePage{
    By addzixuan=By.xpath("//android.widget.ImageView[@instance=1]");
    By stocknames=By.id("tztStockCodeName");

    public SearchPage addZixuan() throws InterruptedException {
        find(addzixuan).click();
        return new SearchPage();
    }

    public ArrayList<String> searchStock(){
        ArrayList<String> array=new ArrayList<>();
        for (WebElement e: Driver.getCurrentDriver().findElements(stocknames)){
            array.add(e.getText());
        }
        return array;

    }
}
