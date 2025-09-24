package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RemoveTeam extends BasePage {
    private final By removeteam = By.xpath("(//tr[contains(@class,'ant-table-row')][1]/td[3]//p)[1]");
    private final By selectCheckboxes = By.cssSelector("input.ant-checkbox-input");
    private final By removeButton = By.xpath("//button[normalize-space()='Remove user']");

    public void removemember() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement member = wait.until(ExpectedConditions.elementToBeClickable(removeteam));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", member);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", member);

        List<WebElement> checkboxes = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(selectCheckboxes, 1));

        Collections.shuffle(checkboxes, new Random());

        int selected = 0;
        for (WebElement checkbox : checkboxes) {
            if (selected >= 2) break;
            try {
                if (!checkbox.isSelected()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                    selected++;
                }
            } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
                System.out.println("Retrying click due to: " + e.getMessage());
                try {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                    selected++;
                } catch (Exception ex) {
                    System.out.println("Failed to click checkbox after retry.");
                }
            }
        }

        WebElement removeBtn = wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeBtn);
    }
}
