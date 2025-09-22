package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import java.time.Duration;

public class AddTeam extends BasePage {
    private final By addteamtab = By.xpath("//*[@aria-describedby='«r5»']");
//    private final By addteamtab = By.xpath("//div[@class='_MainSidecontainer_dyg2d_1']//div[@class='_NavigationIcon_dyg2d_23'][1]");
    private final By addmember = By.xpath("//div[@class='ant-dropdown-trigger']//*[name()='svg']");
    private final By member = By.xpath("//div[contains(text(),'Add member')]");
    private final By firstname = By.xpath("//input[@placeholder='Enter first name']");
    private final By lastname = By.xpath("//input[@placeholder='Enter last name']");
    private final By email = By.xpath("//input[@placeholder='Enter email']");
    private final By role = By.id("rc_select_1");
    private final By manager = By.id("rc_select_2");
    private final By adduserbutton = By.xpath("//button[normalize-space()='Add user']");

    private final Random random = new Random();

    private String getRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    private String getRandomEmail() {
        return getRandomString(8) + "@gmail.com";
    }

    public void teamtab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(2000);
        driver.findElement(addteamtab).click();

    }
    public void addmember() throws InterruptedException {
        driver.findElement(addmember).click();

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(member).click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.findElement(member).click();
        }

        driver.findElement(firstname).sendKeys(getRandomString(6));

        driver.findElement(lastname).sendKeys(getRandomString(6));

        driver.findElement(email).sendKeys(getRandomEmail());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement roleField = wait.until(ExpectedConditions.presenceOfElementLocated(role));
        Thread.sleep(1000);
        roleField.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_1_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Selected option index of role: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }

        WebElement managerField = wait.until(ExpectedConditions.presenceOfElementLocated(manager));
        Thread.sleep(1000);
        managerField.click();
        List<WebElement> options1 = driver.findElements(By.xpath("//div[@id='rc_select_2_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options1.isEmpty()) {
            Random rand1 = new Random();
            int randomIndex = rand1.nextInt(options1.size());
            options1.get(randomIndex).click();
            System.out.println("Selected option index of member: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }

        driver.findElement(adduserbutton).click();
        Thread.sleep(2000);
    }
}
