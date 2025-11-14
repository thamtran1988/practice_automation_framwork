package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;



public class LoginTest extends BaseTest {
    @Test
    public void loginSuccess() {
        openUrl("https://www.saucedemo.com/");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("standard_user", "secret_sauce");

    }
    //login unsuccess
    @Test
    public void loginUnsuccess() {
        openUrl("https://www.saucedemo.com/");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("locked_out_user", "secret_sauce");
        String errorMessage = loginpage.getErrorMessage();
        System.out.println("Error message: " + errorMessage);
    }



}
