package pageObjects;

import org.openqa.selenium.By;

import java.time.Duration;

public class SearchProject extends BasePage{
    private final By search_project = By.xpath("//input[@id='ListSearch']");
    public void searchproject() throws InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            Thread.sleep(7000);
            driver.findElement(search_project).sendKeys("wffkbd");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            Thread.sleep(7000);

            driver.findElement(search_project).sendKeys("wffkbd");
        }
        Thread.sleep(4000);
    }
}
