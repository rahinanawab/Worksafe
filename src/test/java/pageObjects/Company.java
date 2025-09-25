package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Company extends BasePage {
//    private final By companytab = By.xpath("//*[@aria-describedby='«r7»']");
private final By companytab = By.cssSelector("div[class='_sideBarScroller_123ft_14'] div:nth-child(3)");
 private final By buystorageButton = By.xpath("//button[normalize-space()='Buy Storage']");
    private final By purchaseStorage = By.xpath("//div[@class='ant-drawer-body']//div//div[@class='ant-select ant-select-outlined css-nxgixn ant-select-single ant-select-show-arrow']");
    private final By storageButton = By.xpath("//div[@class='_FooterContainer_15gea_283']//button[2]");
    private final By cardno = By.xpath("//input[@id='cardNumber']");
    private final By cardexpiry = By.xpath("//input[@id='cardExpiry']");
    private final By cardcvc = By.xpath("//input[@id='cardCvc']");
    private final By billingName = By.xpath("//input[@id='billingName']");
    private final By payButton = By.cssSelector("button[type='submit']");



    private final By buylicenseButton = By.xpath("//button[normalize-space()='Buy License']");
    private final By licenseno = By.xpath("//input[@placeholder='Please select number how many license you want to buy']");
    private final By licenseButton = By.xpath("//div[@class='_FooterContainer_15gea_283']//button[2]");



    public void company() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(companytab).click();
    }

    public void storage() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(buystorageButton).click();
        Thread.sleep(1000);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.findElement(purchaseStorage).click();
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("rc_select_1")));
        Thread.sleep(1000);
//        WebElement element = driver.findElement(By.id("rc_select_1"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//        Thread.sleep(1000);

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-select-item-option-content']")));
//        Thread.sleep(1000);


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

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement button = driver.findElement(payButton);
        js.executeScript("arguments[0].click();", button);
    }
    public void license() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(buylicenseButton).click();

        driver.findElement(licenseno).sendKeys("2");
        Thread.sleep(1000);

        driver.findElement(licenseButton).click();
        Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(cardno).sendKeys("4242424242424242");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(cardexpiry).sendKeys("0228");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(cardcvc).sendKeys("554");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(billingName).sendKeys("hello");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement button = driver.findElement(payButton);
        js.executeScript("arguments[0].click();", button);
    }
}