package com.automation.testcases;

import Utils.JsonDataReader;
import main.java.com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import models.LoginData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;


public class LoginTest extends BaseTest {
    // Đường dẫn đến file JSON của bạn
    private final String DATA_FILE = "src/test/java/com/automatio/resource/login-data.json";
    @DataProvider(name = "singleSuccessData")
    public Object[] getSingleSuccessData() {
        // Giả sử JsonDataReader có hàm đọc Map
        Map<String, LoginData> dataMap = JsonDataReader.getLoginDataMap(DATA_FILE);

        // Lấy đối tượng LoginData cho key "SUCCESS_USER"
        LoginData successData = dataMap.get("validCredentials");

        // Trả về một mảng chứa duy nhất đối tượng này
        return new Object[]{ successData };
    }
    @DataProvider(name = "invalidCredentials")
    public Object[] invalidCredentials() {
        // Giả sử JsonDataReader có hàm đọc Map
        Map<String, LoginData> dataMap = JsonDataReader.getLoginDataMap(DATA_FILE);

        // Lấy đối tượng LoginData cho key "SUCCESS_USER"
        LoginData successData = dataMap.get("invalidCredentials");

        // Trả về một mảng chứa duy nhất đối tượng này
        return new Object[]{ successData };
    }
    @DataProvider(name = "lockedOutUser")
    public Object[] lockedOutUser() {
        // Giả sử JsonDataReader có hàm đọc Map
        Map<String, LoginData> dataMap = JsonDataReader.getLoginDataMap(DATA_FILE);

        // Lấy đối tượng LoginData cho key "SUCCESS_USER"
        LoginData successData = dataMap.get("lockedOutUser");

        // Trả về một mảng chứa duy nhất đối tượng này
        return new Object[]{ successData };
    }

    @Test(dataProvider = "singleSuccessData")
    public void loginSuccess(LoginData loginData) {
        openUrl("https://www.saucedemo.com/");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login(loginData.getUsername(),loginData.getPassword());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Login successfully ");

    }
    //login unsuccess
    @Test(dataProvider = "invalidCredentials")
    public void loginUnsuccess(LoginData loginData) {
        openUrl("https://www.saucedemo.com/");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login(loginData.getUsername(),loginData.getPassword());
        String errorMessage = loginpage.getErrorMessage();
        System.out.println("Error message: " + errorMessage);
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service", "Login unsuccessfully ");
    }

    //login block account
    @Test(dataProvider = "lockedOutUser")
    public void loginBlockAccount(LoginData loginData) {
        openUrl("https://www.saucedemo.com/");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login(loginData.getUsername(),loginData.getPassword());
        String errorMessage = loginpage.getErrorMessage();
        System.out.println("Error message: " + errorMessage);
        Assert.assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.", "Login unsuccessfully - locked account");
    }



}