package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Poi extends BasePage {
//    private final By poitab = By.xpath("//*[@aria-describedby='«rb»']");
    private final By poitab = By.xpath("//div[@class='_MainSidecontainer_dyg2d_1']//div[@class='_NavigationIcon_dyg2d_23'][5]");
    private final By createPOIButton = By.xpath("//div[@class='_TabHeader_1vq1m_12']//div/button[4]");
    private final By title = By.xpath("//input[@placeholder='Enter Title']");
    private final By threatlevel = By.id("rc_select_1");
    private final By elevationlevel = By.id("rc_select_2");
    private final By notificationtitle = By.xpath("//input[@placeholder='Enter Notification Title']");
    private final By notificationtimeminute = By.xpath("//input[@placeholder='Enter Pre-Notification Time']");
    private final By extradata = By.cssSelector("._AddExtraDataFeild_1huat_344");
    private final By extradataname = By.xpath("//input[@placeholder='Name here']");
    private final By extradatadesc = By.xpath("//textarea[@placeholder='Description here']");
    private final By extradatasetting = By.xpath("//body//div//div[@class='ant-drawer-body']//div//div[2]//*[name()='svg']");
    private final By extradataButton = By.xpath("//button[normalize-space()='Add Data']");
    private final By closeextradata = By.xpath("//button[@aria-label='Close']");
    private final By notificationDateTime = By.xpath("//input[@placeholder='Select Notification Date & Time']");
    private final By description = By.xpath("//textarea[@placeholder='Enter Description']");
    private final By notificationBody = By.xpath("//textarea[@placeholder='Enter Notification Body']");
    private final By uploadDoc = By.xpath("(//input[@accept='.pdf'])[1]");
    private final By uploadPhoto = By.xpath("(//input[@accept='.png,.jpg,.jpeg,.svg'])[1]");
    private final By circlemap = By.xpath("//div[@class='_PolyCard_1fzsm_250']//div[1]");
    private final By addpoibutton = By.xpath("//button[normalize-space()='Add POI']");
    private final By optionpoi = By.xpath("(//*[name()='svg'][@class='ant-dropdown-trigger'])[1]");
    private final By editpoibutton = By.xpath("//button[normalize-space()='Save POI']");

    private final Random random = new Random();

    private String getRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    public void poi() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(poitab).click();
    }

    public void createButton() throws InterruptedException {
        driver.findElement(createPOIButton).click();
        driver.findElement(title).sendKeys(getRandomString(6));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement threatlevelField = wait.until(ExpectedConditions.presenceOfElementLocated(threatlevel));
        Thread.sleep(1000);
        threatlevelField.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_1_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Selected option index of threat level: " + randomIndex);
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
            selectedIndexes.add(rand.nextInt(options1.size()));
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
        driver.findElement(notificationtitle).sendKeys(getRandomString(6));
        driver.findElement(notificationtimeminute).sendKeys("5");
        driver.findElement(extradata).click();
        driver.findElement(extradataname).sendKeys(getRandomString(6));
        driver.findElement(extradatadesc).sendKeys(getRandomString(6));


        WebElement extradatas = wait.until(ExpectedConditions.presenceOfElementLocated(extradatasetting));
        Thread.sleep(1000);
        extradatas.click();


        List<WebElement> options2 = driver.findElements(By.xpath("//li//span//div"));

        if (!options2.isEmpty()) {
            Random rand1 = new Random();
            int randomIndex = rand1.nextInt(options2.size());
            WebElement selectedOption = options2.get(randomIndex);
            String selectedText = selectedOption.getText().toLowerCase().trim();
            selectedOption.click();
            System.out.println("Selected option index: " + randomIndex);
            System.out.println("Selected option text: " + selectedText);
            Thread.sleep(1000);
            switch (selectedText) {
                case "input":
                    WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='Value here']"));
                    inputField.clear();
                    inputField.sendKeys("Sample Text");
                    String inputVal = inputField.getAttribute("value");
                    System.out.println("Input Value: " + inputVal);
                    break;
                case "boolean":
                    WebElement toggleSwitch = driver.findElement(By.xpath("//button[contains(@class,'ant-switch')]"));
                    String isChecked = toggleSwitch.getAttribute("aria-checked");
                    if (!"true".equals(isChecked)) {
                        toggleSwitch.click();
                    }
                    String updatedCheck = toggleSwitch.getAttribute("aria-checked");
                    System.out.println("Switch checked: " + updatedCheck);
                    break;
                case "date":
                    WebElement dateInput = driver.findElement(By.xpath("//input[@placeholder='Select Date']"));
                    Thread.sleep(1000);
                    dateInput.click();
                    WebElement todaydate = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//td[@class='ant-picker-cell ant-picker-cell-in-view ant-picker-cell-today']")));
                    todaydate.click();
                    break;
                case "color":
        WebElement colorPickerTrigger = driver.findElement(By.xpath("//div[contains(@class,'ant-color-picker-trigger')]"));
        colorPickerTrigger.click();
        Thread.sleep(500);
        WebElement rInput = driver.findElement(By.xpath("(//div[@class='ant-color-picker-rgb-input']//input)[1]"));
        WebElement gInput = driver.findElement(By.xpath("(//div[@class='ant-color-picker-rgb-input']//input)[2]"));
        WebElement bInput = driver.findElement(By.xpath("(//div[@class='ant-color-picker-rgb-input']//input)[3]"));
        rInput.clear();
        rInput.sendKeys("104");
        gInput.clear();
        gInput.sendKeys("12");
        bInput.clear();
        bInput.sendKeys("12");
        colorPickerTrigger.click();
        System.out.println("RGB color set to rgb(104, 12, 12)");
        break;
                default:
                    System.out.println("Unknown option selected: " + selectedText);
            }
        } else {
            System.out.println("No options found.");
        }
        driver.findElement(extradataButton).click();
        driver.findElement(closeextradata).click();
        driver.findElement(notificationDateTime).click();
        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-picker-cell-inner'][normalize-space()='25']")));
        date.click();
        WebElement hour = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[@data-type='hour']//div[@class='ant-picker-time-panel-cell-inner'][normalize-space()='02']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hour);
        hour.click();
        WebElement minute = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[@data-type='minute']//div[@class='ant-picker-time-panel-cell-inner'][normalize-space()='03']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", minute);
        minute.click();
        WebElement pm = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[contains(@class,'ant-picker-time-panel-column')][3]//div[normalize-space()='PM']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pm);
        pm.click();
        WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='ant-btn css-nxgixn ant-btn-primary ant-btn-color-primary ant-btn-variant-solid ant-btn-sm']")));
        okBtn.click();
        System.out.println("Date and time selected successfully!");
        driver.findElement(description).sendKeys(getRandomString(10));
        driver.findElement(notificationBody).sendKeys(getRandomString(6));
        driver.findElement(uploadDoc).sendKeys("C:\\Users\\Maze Digital\\Desktop\\dummy.pdf");
        driver.findElement(uploadPhoto).sendKeys("C:\\Users\\Maze Digital\\Pictures\\Screenshots\\Screenshot 2025-07-14 203433.png");
        driver.findElement(circlemap).click();
        driver.findElement(addpoibutton).click();
        Thread.sleep(1000);
    }

    public void optpoiview() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optview = wait.until(ExpectedConditions.presenceOfElementLocated(optionpoi));
        Thread.sleep(1000);
        optview.click();
        WebElement viewpoi = driver.findElement(By.xpath("//div[normalize-space()='View POI']"));
        viewpoi.click();
    }
    public void optpoidel() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optdel = wait.until(ExpectedConditions.presenceOfElementLocated(optionpoi));
        Thread.sleep(1000);
        optdel.click();
        WebElement viewpoi = driver.findElement(By.xpath("//div[normalize-space()='Archived POI']"));
        viewpoi.click();
//        try {
//                        Alert alert = driver.switchTo().alert();
//                        //alert.accept();
//                        alert.dismiss();
//                    } catch (NoAlertPresentException e) {
//                        System.out.println("No alert present after clicking Archived POI.");
//                    }
        try {
//            WebElement yes = driver.findElement(By.xpath("//button[@class='_CheckBtn_1vq1m_146']//*[name()='svg']"));
//            yes.click();
              WebElement no = driver.findElement(By.xpath("//button[contains(@class,'_CloseBtn_1vq1m_162')]//*[name()='svg']"));
              no.click();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present after clicking Archived POI.");
        }
    }
    public void optpoiedit() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optedit = wait.until(ExpectedConditions.presenceOfElementLocated(optionpoi));
        Thread.sleep(1000);
        optedit.click();
        WebElement editpoi = driver.findElement(By.xpath("//div[normalize-space()='Edit POI']"));
        editpoi.click();

        WebElement edittitleField = driver.findElement(title);
        edittitleField.clear();
        edittitleField.sendKeys(getRandomString(6));

        WebElement editelevationlevelField = wait.until(ExpectedConditions.presenceOfElementLocated(elevationlevel));
        Thread.sleep(1000);
        editelevationlevelField.click();
        List<WebElement> elevationOptions = driver.findElements(By.xpath("//div[@id='rc_select_2_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        Set<Integer> selectedIndexes = new HashSet<>();
        while (selectedIndexes.size() < 2 && elevationOptions.size() >= 2) {
            selectedIndexes.add(new Random().nextInt(elevationOptions.size()));
        }
        for (int index : selectedIndexes) {
            editelevationlevelField.click();
            Thread.sleep(500);
            List<WebElement> refreshedOptions = driver.findElements(By.xpath("//div[@id='rc_select_2_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
            if (index < refreshedOptions.size()) {
                refreshedOptions.get(index).click();
            }
            Thread.sleep(500);
        }

        WebElement ntField = driver.findElement(notificationtitle);
        ntField.clear();
        ntField.sendKeys(getRandomString(6));

        WebElement timeField = driver.findElement(notificationtimeminute);
        timeField.clear();
        timeField.sendKeys("1");

        driver.findElement(editpoibutton).click();
        Thread.sleep(1000);
    }
}