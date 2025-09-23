package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Filter extends BasePage{

    private final By searchicon = By.cssSelector("._SearchIcon_1qka8_119");
    private final By filtericon = By.cssSelector("div[class='_HeaderSearch_1qka8_138'] button");
    private final By selectCheckbox = By.xpath("(//input[@type='checkbox'])[position() <= 5]");
    private final By startdate = By.xpath("(//input[@placeholder='Select date'])[1]");
    private final By enddate = By.xpath("(//input[@placeholder='Select date'])[2]");
    private final By maploc = By.cssSelector("body > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1)");
    private final By maploc1 = By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)");
    private final By crossbutton = By.xpath("(//button[@aria-label='Custom Close Button'])[2]");
    private final By selectCheckbox1 = By.xpath("(//input[@type='checkbox'])[position() >= 6 and position() <= 8]");
    private final By applyfilterbutton = By.xpath("//button[normalize-space()='Apply Filter']");
    private final By crossbutton1 = By.xpath("(//button[@aria-label='Custom Close Button'])[1]");

    public void filtertab() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(searchicon).click();
    }

    public void filterselection() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(1000);
        WebElement member = driver.findElement(filtericon);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", member);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", member);

        List<WebElement> checkboxes = driver.findElements(selectCheckbox);
        for (WebElement checkboxInput : checkboxes) {
            if (checkboxInput.isSelected()) {
                try {
                    WebElement label = checkboxInput.findElement(By.xpath("./ancestor::label"));
                    label.click();
                } catch (Exception e) {
                    System.out.println("Could not unselect checkbox: " + e.getMessage());
                }
            }
        }
        if (checkboxes.size() < 2) {
            System.out.println("Less than 2 checkboxes found!");
            return;
        }

        Collections.shuffle(checkboxes, new Random());
        for (int i = 0; i < 2; i++) {
            WebElement checkboxInput = checkboxes.get(i);
            if (!checkboxInput.isSelected()) {
                try {
                    WebElement label = checkboxInput.findElement(By.xpath("./ancestor::label"));
                    label.click();
                } catch (Exception e) {
                    System.out.println("Could not click checkbox " + i + ": " + e.getMessage());
                }
            }
        }
        driver.findElement(startdate).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//td[@class='ant-picker-cell ant-picker-cell-in-view']//div[@class='ant-picker-cell-inner'][normalize-space()='12']")));
        date.click();
        System.out.println("Date and time selected successfully!");
        Thread.sleep(1000);

        driver.findElement(enddate).click();
        WebElement date1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-picker-dropdown css-nxgixn ant-picker-dropdown-placement-bottomRight']//div[@class='ant-picker-panel-container ant-picker-date-panel-container']//div[@class='ant-picker-panel-layout']//div//a[@class='ant-picker-now-btn'][normalize-space()='Today']")));
        date1.click();
        System.out.println("Date and time selected successfully!");
        Thread.sleep(1000);

//        driver.findElement(maploc).click();
//        Thread.sleep(1000);
//
//        driver.findElement(maploc1).click();
//        Thread.sleep(1000);
//
//        driver.findElement(crossbutton).click();
//        Thread.sleep(1000);

        List<WebElement> checkboxes1 = driver.findElements(selectCheckbox1);
        if (checkboxes1.size() < 2) {
            System.out.println("Less than 2 checkboxes found!");
            return;
        }
        Collections.shuffle(checkboxes1, new Random());
        for (int i = 0; i < 2; i++) {
            WebElement checkboxInput = checkboxes1.get(i);
            if (!checkboxInput.isSelected()) {
                try {
                    WebElement label = checkboxInput.findElement(By.xpath("./ancestor::label"));
                    label.click();
                } catch (Exception e) {
                    System.out.println("Could not click checkbox " + i + ": " + e.getMessage());
                }
            }
        }
        Thread.sleep(1000);

        driver.findElement(applyfilterbutton).click();
        Thread.sleep(2000);

        driver.findElement(crossbutton1).click();

    }
}
