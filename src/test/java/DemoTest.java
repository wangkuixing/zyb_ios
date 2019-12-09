import driver.Driver;
import org.junit.jupiter.api.Test;

public class DemoTest {

    @Test
    public void LaunchApp(){
        Driver.start();
        Driver.getCurrentDriver().findElementByXPath("//*[@name='tzt toolbar tradeForW@2x']").click();

    }
}
