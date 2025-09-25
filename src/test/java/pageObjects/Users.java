package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Users extends BasePage{
    private final By userstab = By.cssSelector("div[class='_sideBarScroller_123ft_14'] div:nth-child(2)");
    private final By searchemailField = By.xpath("//input[@placeholder='Search user']");


    public void usersearch() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(2000);

        driver.findElement(userstab).click();
    }

    public void enterEmailsearch(String email) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Thread.sleep(3000);

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchemailField));
//        emailField.clear();
        emailField.sendKeys(email);
        Thread.sleep(4000);
    }

}
