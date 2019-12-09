import driver.GlobalConfig;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import page.*;
import page.gznhg.ShnhgPage;
import page.gznhg.SznhgPage;
import page.xingu.XinguPage;
import page.xingu.XinzhaiPage;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.stream.Stream;

@TestMethodOrder(OrderAnnotation.class)
public class ATest {

    static MainPage mainPage;
    static TradePage tradePage;
    static LoginPage loginPage;
    static BuyPage buyPage;
    static SalePage salePage;
    static ChaxunPage chaxunPage;
    static ChicangPage chicangPage;
    static MorePage morePage;
    static CdbuyPage cdbuyPage;
    static CdsalePage cdsalePage;
    static XinguPage xinguPage;
    static XinzhaiPage xinzhaiPage;
    static SznhgPage sznhgPage;
    static ShnhgPage shnhgPage;

    static GlobalConfig config=GlobalConfig.load("/data/globalConfig.yaml");

    @BeforeAll
    static void beforeALL() throws InterruptedException {
        String username=config.zyb.username;
        String password=config.zyb.password;

        mainPage=MainPage.start();
        tradePage=mainPage.gotoTrade();
        loginPage=tradePage.gotoLogin();
        tradePage=loginPage.passwordSuccess(username, password);
    }

    @Description("买入A股000001,600000")
    @Order(1)
    @ParameterizedTest
    @MethodSource("Getyamlbuy")
    void buyA(String stockcode, String expect) throws InterruptedException {

        buyPage=tradePage.gotoBuy();
        buyPage.buyTest(stockcode);
        String message=buyPage.getMessage();
        buyPage.gotoTrade();

        assertThat(message, containsString(expect));
    }

    @Description("卖出A股000882，600016")
    @Order(2)
    @ParameterizedTest
    @MethodSource("Getyamlsale")
    void saleA(String stksale, String expect) throws InterruptedException {

        String stkamt=config.zyb.stkamt;

        salePage=tradePage.gotoSale();
        salePage.SaleTest(stksale, stkamt);
        String message=salePage.getMessage();
        salePage.gotoTrade();

        assertThat(message, containsString(expect));
    }

    @Test
    @Description("查询资金")
    @Order(3)
    void chaZijin() throws InterruptedException {

        chaxunPage=tradePage.gotoChaxun();
        Boolean cha=chaxunPage.chaxunTest();
        chaxunPage.gotoTrade();

        assertTrue(cha);
    }

    @Test
    @Description("我的持仓")
    @Order(4)
    void chiCang() throws InterruptedException {

        chicangPage=tradePage.gotoChicang();
        Boolean chicang=chicangPage.chicangTest();
        chicangPage.gotoTrade();

        assertTrue(chicang);
    }

    @Test
    @Description("拆单买入A股000001")
    @Order(5)
    void cdbuyA() throws InterruptedException {

        String stockcode=config.zyb.stock.get(0);
        String expect=config.zyb.expect.get(2);

        cdbuyPage=tradePage.gotoMore().gotocdBuy();
        cdbuyPage.jfTest(stockcode);
        String message1=cdbuyPage.getMessage1();

        cdbuyPage.randomTest(stockcode);
        String message2=cdbuyPage.getMessage2();

        cdbuyPage.gotoMore().gotoTrade();

        assertThat(message1, containsString(expect));
        assertThat(message2, containsString(expect));
    }

    @Test
    @Description("拆单卖出A股000882")
    @Order(6)
    void cdsaleA(){
        //todo
        return;

    }

    //密码修改
    //todo

    @Test
    @Description("新股申购")
    @Order(7)
    void xinguTest() throws InterruptedException {

        tradePage.gotoYjdx()
                .gotoXgsg()
                .xinguTest()
                .gotoYjdx()
                .gotoTrade();

    }

    @Test
    @Description("债券申购")
    @Order(8)
    void xinzhaiTest() throws InterruptedException {

        tradePage.gotoYjdx()
                .gotoXinzhai()
                .xinzhaiTest()
                .gotoYjdx()
                .gotoTrade();

    }

    @Test
    @Description("深市国债逆回购")
    @Order(9)
    void sznhgTest() throws InterruptedException {

        sznhgPage=tradePage.gotoNhg().gotoSz();
        sznhgPage.weituo1318xx();
        String message1=sznhgPage.getMessage1();
        String message2=sznhgPage.getMessage2();
        sznhgPage.gotoNhg().gotoTrade();

        assertThat(message1, containsString("成功"));
        assertThat(message2, containsString("成功"));

    }

    @Test
    @Description("沪市国债逆回购")
    @Order(10)
    void shnhgTest() throws InterruptedException {

        shnhgPage=tradePage.gotoNhg().gotoSh();
        shnhgPage.weituo204xxx();
        String message1=shnhgPage.getMessage1();
        String message2=shnhgPage.getMessage2();
        shnhgPage.gotoNhg().gotoTrade();

        assertThat(message1, containsString("成功"));
        assertThat(message2, containsString("成功"));

    }

    //银证转账


//    //买入B股
//    @ParameterizedTest
//    @MethodSource("GetyamlbuyB")
//    void BuyB(String stockcode, String expect){
//
//        String name="退出登录";
//        String userb=config.zyb.userb;
//        String passb=config.zyb.password;
//
//        buyPage=tradePage.swipeControl().logOut(name)
//                .gotoLogin()
//                .passwordSuccess(userb, passb)
//                .gotoTrade()
//                .gotoBuy();
//
//        buyPage.ATest(stockcode);
//        String message=buyPage.getMessage();
//
//        assertThat(message, containsString(expect));
//        buyPage.gotoTrade();
//
//    }
//
//    //卖出B股
//    @ParameterizedTest
//    @MethodSource("GetyamlsaleB")
//    void SaleB(String stksaleB, String expect){
//
//        String stkamt=config.zyb.stkamt;
//        String name="退出登录";
//        String userb=config.zyb.userb;
//        String passb=config.zyb.password;
//
//        salePage=tradePage.logOut(name)
//                .gotoLogin()
//                .passwordSuccess(userb, passb)
//                .gotoTrade()
//                .gotoSale();
//
//        salePage.SaleTest(stksaleB, stkamt);
//        String message=salePage.getMessage();
//
//        assertThat(message, containsString(expect));
//        salePage.gotoTrade();
//    }

    static Stream<Arguments> Getyamlbuy() {

        return Stream.of(Arguments.of(config.zyb.stock.get(0),config.zyb.expect.get(0)),
                Arguments.of(config.zyb.stock.get(1),config.zyb.expect.get(1)));
    }

    static Stream<Arguments> Getyamlsale() {

        return Stream.of(Arguments.of(config.zyb.stksale.get(0),config.zyb.expect.get(0)),
                Arguments.of(config.zyb.stksale.get(1),config.zyb.expect.get(1)));
    }

//    static Stream<Arguments> GetyamlbuyB() {
//
//        return Stream.of(Arguments.of(config.zyb.stock.get(2),config.zyb.expect.get(0)),
//                Arguments.of(config.zyb.stock.get(3),config.zyb.expect.get(1)));
//    }
//
//    static Stream<Arguments> GetyamlsaleB() {
//
//        return Stream.of(Arguments.of(config.zyb.stock.get(4),config.zyb.expect.get(0)),
//                Arguments.of(config.zyb.stock.get(5),config.zyb.expect.get(1)));
//    }


}


