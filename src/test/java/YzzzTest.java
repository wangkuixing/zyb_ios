import driver.GlobalConfig;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import page.BuyPage;
import page.LoginPage;
import page.MainPage;
import page.TradePage;
import page.yzzz.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class YzzzTest {

    static MainPage mainPage;
    static TradePage tradePage;
    static LoginPage loginPage;
    static ZjzrPage zjzrPage;
    static ZjzcPage zjzcPage;
    static WdzjPage wdzjPage;
    static ZjgjPage zjgjPage;
    static ZjdbPage zjdbPage;

    static GlobalConfig config=GlobalConfig.load("/data/globalConfig.yaml");

    @BeforeAll
    static void beforeALL() throws InterruptedException {
        String username=config.zyb.useryzzz;
        String password=config.zyb.password;

        mainPage= MainPage.start();
        tradePage=mainPage.gotoTrade();
        loginPage=tradePage.gotoLogin();
        tradePage=loginPage.passwordSuccess(username, password);
    }

    @Test
    @Description("银行转证券")
    @Order(1)
    void yhtoZq() throws InterruptedException {

        String expect=config.zyb.expect.get(3);

        zjzrPage=tradePage.gotoYzzz().gotoZjzr();
        zjzrPage.yhtoZq();
        String message=zjzrPage.getMessage();
        zjzrPage.gotoYzzz().gotoTrade();

        assertThat(message, containsString(expect));
    }

    @Test
    @Description("证券转银行")
    @Order(2)
    void zqtoYh() throws InterruptedException {

        String expect=config.zyb.expect.get(3);

        zjzcPage=tradePage.gotoYzzz().gotoZjzc();
        zjzcPage.zqtoYh();
        String message=zjzcPage.getMessage();
        zjzcPage.gotoYzzz().gotoTrade();

        assertThat(message, containsString(expect));
    }

    @Test
    @Description("我的资金")
    @Order(3)
    void wdZj() throws InterruptedException {

        wdzjPage=tradePage.gotoYzzz().gotoWdzj();
        Boolean zj=wdzjPage.wdZj();
        wdzjPage.gotoYzzz().gotoTrade();

        assertTrue(zj);
    }

    @Test
    @Description("资金归集")
    @Order(4)
    void zjGj() throws InterruptedException {

        String expect=config.zyb.expect.get(4);

        zjgjPage=tradePage.gotoYzzz().gotoZjgj();
        zjgjPage.zjGj();
        String message=zjgjPage.getMessage();
        zjgjPage.gotoYzzz().gotoTrade();

        assertThat(message, containsString(expect));
    }

    @Test
    @Description("资金调拨")
    @Order(5)
    void zjDb() throws InterruptedException {

        String expect=config.zyb.expect.get(11);

        zjdbPage=tradePage.gotoYzzz().gotoZjdb();
        Thread.sleep(5000);
        zjdbPage.zjDb();
        String message=zjdbPage.getMessage();
        zjdbPage.gotoYzzz().gotoTrade();

        assertThat(message, containsString(expect));
    }
}
