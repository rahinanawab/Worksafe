package pageObjects;

import TestCases.BaseTest;
import org.openqa.selenium.By;

import java.time.Duration;

import static pageObjects.BasePage.driver;

public class SearchAsset extends BaseTest {
    private final By search_asset = By.xpath("//input[@id='ListSearch']");
    public void searchasset() throws InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            Thread.sleep(7000);
            driver.findElement(search_asset).sendKeys("wffkbd");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            Thread.sleep(7000);

            driver.findElement(search_asset).sendKeys("wffkbd");
        }
        Thread.sleep(4000);
    }
}
