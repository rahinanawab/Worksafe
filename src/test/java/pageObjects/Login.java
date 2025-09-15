package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends BasePage {

    private final By checkbox = By.xpath("//span[@class='checkbox__indicator']");
    private final By continueButton = By.xpath("//button[@id='onContinue']");
    private final By emailField = By.xpath("//input[@placeholder='Enter your email']");
    private final By passwordField = By.xpath("//input[@placeholder='Please type your password']");
    private final By loginButton = By.xpath("//button[@type='button']");

    public void navigateToLoginPage() {
        driver.get("https://app.worksafemaps.com/");
//        driver.get("https://work-safe-new-ui.vercel.app/");
    }

//    public void acceptTermsAndContinue() {
//        driver.findElement(checkbox).click();
//        driver.findElement(continueButton).click();
//    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("https://app.worksafemaps.com/");
//        return driver.getCurrentUrl().contains("https://work-safe-new-ui.vercel.app/");
    }

}
