# 移动端UI自动化测试

这个是IOS项目,android项目见zyb_autotest，
刚开始做写代码的时候，准备android和IOS重用同一套框架代码，后来考虑到Android和IOS界面布局，控件定位方式很多不一样，
也跟许多朋友交流过，两套混在一起维护困难，所以考虑分开做。
（appium里有@AndroiodFindBy  @IosFindBy，有兴趣的同学可以尝试）

## 使用工具

* appium@1.15.1
* junit5:测试用例执行
* allure2:自动生成测试报告
* jenkins:CI
* gitlab:代码仓库（私有化部署）

## 项目结构
* main/driver: driver全局配置，数据驱动读取yaml文件
* page: pageObject页面
* test/java: testCase

## 运行

代码上传至gitlab，jenkins中配置maven project，可实现按需定时执行project，执行完成后生成allure report
