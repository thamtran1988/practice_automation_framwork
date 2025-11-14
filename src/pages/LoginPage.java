package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.zeromq.SocketType.type;

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
        type(By.cssSelector(usernameLocator), user);
        type(By.cssSelector(passwordLocator), pass);
        click(By.cssSelector(loginButtonLocator));

    }
    //get error message
    public String getErrorMessage() {
        By errorMessageLocator = By.cssSelector("h3[data-test='error']");
        return getText(errorMessageLocator);
    }



}
