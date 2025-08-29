package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CompanyStorage extends BasePage {
//    private final By companytab = By.xpath("//*[@aria-describedby='«r7»']");
    private final By companytab = By.xpath("//div[@class='_MainSidecontainer_dyg2d_1']//div[@class='_NavigationIcon_dyg2d_23'][3]");
    private final By buystorageButton = By.xpath("//button[normalize-space()='Buy Storage']");
    private final By purchaseStorage = By.cssSelector(".ant-select-selection-item");
    private final By storageButton = By.xpath("//div[@class='_FooterContainer_15gea_283']//button[2]");
    private final By cardno = By.xpath("//input[@id='cardNumber']");
    private final By cardexpiry = By.xpath("//input[@id='cardExpiry']");
    private final By cardcvc = By.xpath("//input[@id='cardCvc']");
    private final By billingName = By.xpath("//input[@id='billingName']");
    private final By payButton = By.cssSelector("button[type='submit']");


    public void company() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(companytab).click();
    }

    public void storage() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(buystorageButton).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        driver.findElement(purchaseStorage).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("'rc_select_1")));
        Thread.sleep(1000);
//        WebElement element = driver.findElement(By.id("rc_select_1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-select-item-option-content']")));
        Thread.sleep(1000);


        List<WebElement> options = driver.findElements(By.xpath("//div[@class='ant-select-item-option-content']"));
        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            options.get(randomIndex).click();

            System.out.println("Selected option index of storage: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
        Thread.sleep(1000);
        driver.findElement(storageButton).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(cardno).sendKeys("4242424242424242");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(cardexpiry).sendKeys("0228");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(cardcvc).sendKeys("554");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(billingName).sendKeys("hello");

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement button = driver.findElement(payButton);
//        js.executeScript("arguments[0].click();", button);
    }

}