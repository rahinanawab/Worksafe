package pageObjects;

import org.openqa.selenium.By;

import java.time.Duration;

public class Payment extends BasePage{
//    private final By paymenttab = By.xpath("//div[@class='_MainSidecontainer_dyg2d_1']//div[@class='_NavigationIcon_dyg2d_23'][4]");
private final By paymenttab = By.cssSelector("div[class='_sideBarScroller_123ft_14'] div:nth-child(4)");


    public void payment() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(paymenttab).click();
        Thread.sleep(4000);
    }
}
