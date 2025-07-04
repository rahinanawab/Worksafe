package pageObjects;//package pageObjects;

import org.openqa.selenium.By;

import java.time.Duration;

public class SearchUser extends BasePage {

    private final By userstab = By.xpath("//*[@aria-describedby='«r5»']");
    private final By searchemailField = By.xpath("//input[@placeholder='Search user']");

    public void  users(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(userstab).click();
    }
    public void enterEmailsearch(String email) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(searchemailField).sendKeys(email);
    }
}