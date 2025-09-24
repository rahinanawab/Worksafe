package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchUser extends BasePage {

    private final By userstab = By.cssSelector("div[class='_sideBarScroller_123ft_14'] div:nth-child(2)");
    private final By searchemailField = By.xpath("//input[@placeholder='Search user']");
    private final By overlayMask = By.cssSelector(".ant-drawer-mask");

    public void users() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayMask));
        WebElement users = wait.until(ExpectedConditions.elementToBeClickable(userstab));
        users.click();
    }

    public void enterEmailsearch(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchemailField));
        emailField.clear();
        emailField.sendKeys(email);
    }
}
