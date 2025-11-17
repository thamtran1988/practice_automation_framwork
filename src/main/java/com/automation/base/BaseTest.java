package main.java.com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

    public class BaseTest {

        protected WebDriver driver;  // Driver dùng chung cho tất cả test case

        // Setup driver trước mỗi test
        @BeforeMethod
        public void setUp() {
            // Đường dẫn ChromeDriver trên máy bạn
            //System.setProperty("webdriver.chrome.driver", "/Users/username/Drivers/chromedriver");

            driver = new ChromeDriver();           // Mở Chrome
            driver.manage().window().maximize();   // Maximize browser

        }
        //open url
        public void openUrl(String url) {
            driver.get(url);
        }

        //  Teardown driver sau mỗi test
        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit(); // Đóng browser + giải phóng driver
            }
        }
    }



