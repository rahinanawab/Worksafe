package pageObjects;

import org.openqa.selenium.By;

import java.time.Duration;

public class SearchTeam extends BasePage{
    private final By search = By.xpath("//input[@placeholder='Search team']");
    public void searchteam() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            Thread.sleep(7000);
//            driver.findElement(search).sendKeys("Test NEW WO 2");
            driver.findElement(search).sendKeys("Team");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            Thread.sleep(7000);

//            driver.findElement(search).sendKeys("Test NEW WO 2");
            driver.findElement(search).sendKeys("Team");

        }
        Thread.sleep(4000);
    }
}
