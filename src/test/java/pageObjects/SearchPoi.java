package pageObjects;

import org.openqa.selenium.By;

import java.time.Duration;

public class SearchPoi extends BasePage{
        private final By search_poi = By.xpath("//input[@id='ListSearch']");
        public void searchpoi() throws InterruptedException {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                Thread.sleep(7000);
                driver.findElement(search_poi).sendKeys("wffkbd");
            }
            catch(org.openqa.selenium.StaleElementReferenceException ex)
            {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                Thread.sleep(7000);

                driver.findElement(search_poi).sendKeys("wffkbd");
            }
            Thread.sleep(4000);
        }
    }
