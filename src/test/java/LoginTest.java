//
//
//import driver.GlobalConfig;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import page.LoginPage;
//import page.MainPage;
//import page.ProfilePage;
//
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//public class LoginTest {
//
//    static MainPage mainPage;
//    static ProfilePage profilePage;
//
//    @BeforeAll
//    static void beforeAll(){
//        mainPage=MainPage.start();
//        profilePage=mainPage.gotoProfile();
//
//    }
//
////    @ParameterizedTest
////    @CsvSource({
////            "13823342796, xxxxxxx, 用户名或密码错误"
////    })
////    public void nomobileNo(String username, String password, String expectation){
////        LoginPage loginPage=profilePage.gotoLogin();
////        loginPage.passwordFail(username, password);
////        String message=loginPage.getMessage();
////        profilePage=loginPage.gotoProfile();
////        assertThat(message, equalTo(expectation));
////    }
//
//
//    //配置驱动
//    @Test
//    public void nomobileNo1(){
//        GlobalConfig config=new GlobalConfig().load("/data/globalConfig.yaml");
//        LoginPage loginPage=profilePage.gotoLogin();
//        loginPage.passwordFail(config.xueqiu.username, config.xueqiu.password);
//        String message=loginPage.getMessage();
//        profilePage=loginPage.gotoProfile();
//        assertThat(message, equalTo("用户名或密码错误"));
//    }
//
//
//    @ParameterizedTest
//    @CsvSource({
//            "18688296242, xxxxxxxx",
//    })
//    public void loginSuceess(String username, String password){
//        LoginPage loginPage=profilePage.gotoLogin();
//        loginPage.passwordSuccess(username, password);
//    }
//}
