package driver;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static IOSDriver<WebElement> driver;

    public static void start(){
        DesiredCapabilities caps=new DesiredCapabilities();

        GlobalConfig config= GlobalConfig.load("/data/globalConfig.yaml");
        config.appium.capabilities.keySet().forEach(key->{
            Object value=config.appium.capabilities.get(key);
            caps.setCapability(key, value);
        });


        URL remoteurl=null;
        try {
            remoteurl=new URL(config.appium.url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new IOSDriver<>(remoteurl, caps);
        driver.manage().timeouts().implicitlyWait(config.appium.wait, TimeUnit.SECONDS);
    }

    public static IOSDriver<WebElement> getCurrentDriver(){
        return driver;
    }


}
