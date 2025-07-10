package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Project extends BasePage{
    private final By projecttab = By.xpath("//*[@aria-describedby='«rf»']");
    private final By createProjectButton = By.xpath("//div[@class='_TabHeader_1vq1m_12']//div/button[3]");
    private final By projectname = By.xpath("//input[@placeholder='Enter Project Name']");
    private final By department = By.id("rc_select_1");
    private final By elevationlevel = By.id("rc_select_2");
    private final By projectmanager = By.id("rc_select_3");
    private final By contractor = By.cssSelector("div[class='_FeildColRight_e1z2y_241'] div[class='_AddExtraDataFeild_e1z2y_344'] div button");


    private final Random random = new Random();

    private String getRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    public void project() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(projecttab).click();
    }
    public void createButton() throws InterruptedException {
        driver.findElement(createProjectButton).click();
        driver.findElement(projectname).sendKeys(getRandomString(6));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement departmentfield = wait.until(ExpectedConditions.presenceOfElementLocated(department));
        Thread.sleep(1000);
        departmentfield.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_1_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Selected option index of department: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
        WebElement elevationlevelField = wait.until(ExpectedConditions.presenceOfElementLocated(elevationlevel));
        Thread.sleep(1000);
        elevationlevelField.click();
        List<WebElement> options1 = driver.findElements(By.xpath("//div[@id='rc_select_2_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (options1.size() < 3) {
            System.out.println("Not enough options to select");
            return;
        }
        Random rand = new Random();
        Set<Integer> selectedIndexes = new HashSet<>();
        while (selectedIndexes.size() < 2) {
            selectedIndexes.add(rand.nextInt(options.size()));
        }
        for (int index : selectedIndexes) {
            elevationlevelField.click();
            Thread.sleep(500);

            List<WebElement> refreshedOptions = driver.findElements(
                    By.xpath("//div[@id='rc_select_2_list']/following-sibling::div//div[@class='ant-select-item-option-content']")
            );
            if (index < refreshedOptions.size()) {
                refreshedOptions.get(index).click();
                System.out.println("Selected option index: " + index);
            }
            Thread.sleep(500);
        }
        WebElement projectmanagerfield = wait.until(ExpectedConditions.presenceOfElementLocated(projectmanager));
        Thread.sleep(1000);
        projectmanagerfield.click();
        List<WebElement> options2 = driver.findElements(By.xpath("//div[@id='rc_select_3_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options2.isEmpty()) {
            Random rand1 = new Random();
            int randomIndex = rand1.nextInt(options2.size());
            options2.get(randomIndex).click();
            System.out.println("Selected option index of project manager: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
        driver.findElement(contractor).click();
    }
}
