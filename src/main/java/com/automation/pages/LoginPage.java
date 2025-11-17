package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    /*Bài tập 3 – Build LoginPage.java

    LoginPage https://www.saucedemo.com/ cần có:
    1.Locators:
    - Locator username
    - Locator password
    - Locator login button
    2. Action:
     Action login(user, pass)
    3. Action getErrorMessage()
     */

    //locators
    public String usernameLocator = "//*[@id='user-name']";
    public String passwordLocator = "//*[@id='password']";
    public String loginButtonLocator = "//*[@id='login-button']";

    //constructor
    public LoginPage(WebDriver driver ) {
        super(driver);
    }
    //actions
    public void login(String user, String pass) {
        type(By.xpath(usernameLocator), user);
        type(By.xpath(passwordLocator), pass);
        click(By.xpath(loginButtonLocator));

    }
    //get error message
    public String getErrorMessage() {
        By errorMessageLocator = By.cssSelector("h3[data-test='error']");
        return getText(errorMessageLocator);
    }



}
