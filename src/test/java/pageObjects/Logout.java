package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout extends BasePage {

    private final By roleDropdown = By.cssSelector("div[class='ant-dropdown-trigger _UserProfileSide_fvo41_20']");
    private final By logoutOption = By.xpath("//div[contains(text(),'Logout')]");

    public void logout() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement roledropdownField = wait.until(ExpectedConditions.presenceOfElementLocated(roleDropdown));
        Thread.sleep(1000);
        roledropdownField.click();
        Thread.sleep(1000);

//        driver.findElement(roleDropdown).click();
        driver.findElement(logoutOption).click();
    }

    public boolean isLogoutSuccessful() {
        return driver.getCurrentUrl().contains("https://app.worksafemaps.com");
    }
}
