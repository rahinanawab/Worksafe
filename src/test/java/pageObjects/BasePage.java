package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BasePage {

    protected static WebDriver driver;

    public static void initializeDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            // Disable "Chrome is being controlled..." message
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

            // Disable Chrome password manager & autofill
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            // Optional: Disable save-password bubble and autofill features
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-autofill");

            // Optional: Run in incognito mode
            // options.addArguments("--incognito");

            driver = new ChromeDriver(options);
            // driver.manage().window().maximize(); // optional

    }
//        if (driver == null) {
//            ChromeOptions options = new ChromeOptions();
//            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//            driver = new ChromeDriver(options);
//            // driver.manage().window().maximize(); // optional
//        }
//        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//        }
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
