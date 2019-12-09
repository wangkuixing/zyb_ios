import driver.GlobalConfig;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import page.BuyPage;
import page.LoginPage;
import page.MainPage;
import page.TradePage;
import page.kfsjj.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KfsjjTest {

    static MainPage mainPage;
    static TradePage tradePage;
    static LoginPage loginPage;
    static BuyPage buyPage;
    static KfsjjPage kfsjjPage;
    static JjsgPage jjsgPage;
    static JjshPage jjshPage;
    static JjrgPage jjrgPage;
    static JjcdPage jjcdPage;
    static FhszPage fhszPage;
    static JjzhPage jjzhPage;
    static JjdtPage jjdtPage;
    static JjdtqxPage jjdtqxPage;

    static GlobalConfig config=GlobalConfig.load("/data/globalConfig.yaml");

    @BeforeAll
    static void beforeALL() throws InterruptedException {
        String username=config.zyb.userkfsjj;
        String password=config.zyb.password;

        mainPage=MainPage.start();
        tradePage=mainPage.gotoTrade();
        loginPage=tradePage.gotoLogin();
        tradePage=loginPage.passwordSuccess(username, password);
        kfsjjPage=tradePage.gotoKfsjj();
    }

    @Test
    @Description("基金申购000562")
    @Order(1)
    void jjSg() throws InterruptedException {
        String stkcode=config.zyb.stock.get(11);
        String amount=config.zyb.stkamt;
        String expect=config.zyb.expect.get(9);

        jjsgPage=kfsjjPage.gotoJjsg();
        jjsgPage.jjSg(stkcode, amount);
        String message=jjsgPage.getMessage();
        jjsgPage.gotoKfsjj();

        assertThat(message, containsString(expect));
    }

    @Test
    @Description("基金赎回202016")
    @Order(2)
    void jjSh() throws InterruptedException {

        String stkcode=config.zyb.stksale.get(3);
        String amount=config.zyb.stkamt;
        String expect=config.zyb.expect.get(9);

        jjshPage=kfsjjPage.gotoJjsh();
        jjshPage.jjSh(stkcode, amount);
        String message=jjshPage.getMessage();
        jjshPage.gotoKfsjj();

        assertThat(message, containsString(expect));
    }

    @Test
    @Description("基金认购000561")
    @Order(3)
    void jjRg() throws InterruptedException {

        String stkcode=config.zyb.stock.get(12);
        String amount=config.zyb.stkamt;
        String expect=config.zyb.expect.get(9);

        jjrgPage=kfsjjPage.gotoJjrg();
        jjrgPage.jjRg(stkcode, amount);
        String message=jjrgPage.getMessage();
        jjrgPage.gotoKfsjj();

        assertThat(message, containsString(expect));
    }

    @Test
    @Description("基金撤单 撤第一笔单，无委托返回查无数据")
    @Order(4)
    void jjCd() throws InterruptedException {

        String expect=config.zyb.expect.get(0);

        jjcdPage=kfsjjPage.gotoJjcd();
        jjcdPage.jjCd();
        String message=jjcdPage.getMessage();
        jjcdPage.gotoKfsjj();

        assertThat(message, containsString(expect));
    }

    @Test
    @Description("基金分红设置：000562现金")
    @Order(5)
    void fhSz() throws InterruptedException {

        String expect=config.zyb.expect.get(9);

        fhszPage=kfsjjPage.gotoFhsz();
        fhszPage.jjFh();
        String message=fhszPage.getMessage();
        fhszPage.gotoKfsjj();

        assertThat(message, containsString(expect));
    }

    @Test
    @Description("基金转换200015-000562")
    @Order(6)
    void jjZh() throws InterruptedException {

        String stkcode=config.zyb.stock.get(11);
        String amount=config.zyb.stkamt;
        String expect=config.zyb.expect.get(9);

        jjzhPage=kfsjjPage.gotoJjzh();
        jjzhPage.jjZh(stkcode, amount);
        String message=jjzhPage.getMessage();
        jjzhPage.gotoKfsjj();

        assertThat(message, containsString(expect));
    }

    @Test
    @Description("基金定投000562")
    @Order(7)
    void jjDt() throws InterruptedException {

        String stkcode=config.zyb.stock.get(11);
        String amount=config.zyb.stkamt;
        String expect=config.zyb.expect.get(9);

        jjdtPage=kfsjjPage.gotoJjdt();
        jjdtPage.jjDt(stkcode, amount);
        String message=jjdtPage.getMessage();
        jjdtPage.gotoKfsjj();

        assertThat(message, containsString(expect));
    }

    @Test
    @Description("基金定投取消000562")
    @Order(8)
    void jjDtqx() throws InterruptedException {

        String expect1=config.zyb.expect.get(9);
        String expect2=config.zyb.expect.get(10);

        jjdtqxPage=kfsjjPage.gotoJjdtqx();
        jjdtqxPage.jjDtqx();
        String message=jjdtqxPage.getMessage();
        jjdtqxPage.gotoKfsjj();

        assertThat(message, either(containsString(expect1)).or(containsString(expect2)));
    }
}
