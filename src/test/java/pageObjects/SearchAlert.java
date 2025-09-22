package pageObjects;

import org.openqa.selenium.By;

import java.time.Duration;

public class SearchAlert extends BasePage{
    private final By search_alert = By.xpath("//input[@id='ListSearch']");
    public void searchalert() throws InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            Thread.sleep(7000);
            driver.findElement(search_alert).sendKeys("wffkbd");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            Thread.sleep(7000);

            driver.findElement(search_alert).sendKeys("wffkbd");
        }
        Thread.sleep(4000);
    }
}
