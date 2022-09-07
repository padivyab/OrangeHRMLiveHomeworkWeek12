package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.ViewSystemUsersPage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by bhavesh patel
 */
public class UsersTest extends TestBase {

    //HomePage homepage = new HomePage();
    LoginPage loginpage = new LoginPage();

    ViewSystemUsersPage viewSystemUsersPage = new ViewSystemUsersPage();

    AddUserPage addUserPage =new AddUserPage();


  /*  public void verifyUserShouldNavigateToLoginPage()
    {
        String actualText = loginpage.getVerifyLogin();
        String expectedText = "Login";
        Assert.assertEquals(expectedText,actualText,"successfully");

    }*/
    @Test
   public void adminShouldAddUserSuccessFully() throws InterruptedException {

        loginpage.LoginToApplication("Admin","admin123");
        viewSystemUsersPage.clickAdminLink();
        viewSystemUsersPage.getSystemUserText();
        viewSystemUsersPage.clickAddButton();
        viewSystemUsersPage.AddUser();
        viewSystemUsersPage.selectAdminRole();
        viewSystemUsersPage.enterEmp();
        viewSystemUsersPage.enterUser();
        viewSystemUsersPage.selectDisableOption();
        viewSystemUsersPage.enterPass();
        viewSystemUsersPage.enterConfirmPass();
        viewSystemUsersPage.clickOnSaveButton();


    }

    @Test
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        loginpage.LoginToApplication("Admin","admin123");
        viewSystemUsersPage.clickAdminLink();
        viewSystemUsersPage.getSystemUserText();
        addUserPage.enterUser();
        addUserPage.SelectUserRole();
        addUserPage.SelectStatus();
        addUserPage.ClickSearchButton();
        addUserPage.VerifyResultList();

    }

    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {
        this.searchTheUserCreatedAndVerifyIt();
        /*loginpage.LoginToApplication("Admin","admin123");
        //this.searchTheUserCreatedAndVerifyIt();
        viewSystemUsersPage.clickAdminLink();
        viewSystemUsersPage.getSystemUserText();
        addUserPage.enterUser();
        addUserPage.SelectUserRole();
        addUserPage.SelectStatus();
        addUserPage.ClickSearchButton();
        addUserPage.VerifyResultList();*/
        addUserPage.clickOnCheckbox();
        addUserPage.ClickDeleteButton();
        addUserPage.PopUpClick();
        addUserPage.VerifyMsgCheck();


    }
    @Test
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() throws InterruptedException {

        //this.verifyThatAdminShouldDeleteTheUserSuccessFully();
        loginpage.LoginToApplication("Admin","admin123");
        viewSystemUsersPage.clickAdminLink();
        viewSystemUsersPage.getSystemUserText();
        addUserPage.enterUser();
        addUserPage.SelectUserRole();
        addUserPage.SelectStatus();
        addUserPage.SearchButtonDelete();
        addUserPage.VerifyNoRecordFound();


    }


}
