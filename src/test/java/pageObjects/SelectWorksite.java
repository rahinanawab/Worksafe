package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SelectWorksite extends BasePage {

//    private final By popup = By.xpath("//button[normalize-space()='Start free trial']");
    private final By worksite = By.id("rc_select_0");
private final By happyworksite = By.xpath("//div[contains(text(),'Happy')]");
//    public void startfreetrial() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        WebElement popupField = wait.until(ExpectedConditions.presenceOfElementLocated(popup));
//        Thread.sleep(3000);
//        popupField.click();
//    }

    public void selectWorksites() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement managerField = wait.until(ExpectedConditions.presenceOfElementLocated(worksite));
        Thread.sleep(3000);
        managerField.click();
        WebElement worksiteField = wait.until(ExpectedConditions.presenceOfElementLocated(happyworksite));
        Thread.sleep(3000);
        worksiteField.click();

//        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_0_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
//        Thread.sleep(1000);
//        if (!options.isEmpty()) {
//            Random rand = new Random();
//            int randomIndex = rand.nextInt(options.size());
//            options.get(randomIndex).click();
//            System.out.println("Selected option index of worksite: " + randomIndex);
//        } else {
//            System.out.println("No options found.");
//        }
        Thread.sleep(2000);
    }
}
