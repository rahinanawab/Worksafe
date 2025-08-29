package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RemoveTeam extends BasePage{
    private final By removeteam = By.xpath("(//tr[contains(@class,'ant-table-row')][1]/td[3]//p)[1]");
    private final By selectCheckboxes = By.cssSelector("input.ant-checkbox-input");
    private final By removeButton = By.xpath("//button[normalize-space()='Remove user']");

    public void removemember() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(1000);
        WebElement member = driver.findElement(removeteam);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", member);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", member);

        List<WebElement> checkboxes = driver.findElements(selectCheckboxes);
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

        driver.findElement(removeButton).click();
    }
}
