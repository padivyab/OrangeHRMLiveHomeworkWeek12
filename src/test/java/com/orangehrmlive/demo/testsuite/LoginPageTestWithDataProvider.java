package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.Test;
import resources.testdata.TestData;

/**
 * Created by bhavesh patel
 */
public class LoginPageTestWithDataProvider extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "credentials",dataProviderClass = TestData.class)
    public void login(String userName, String password){
        //homePage.clickOnLoginLink();
        //loginPage.loginToApplication(userName,password);
    }



}
