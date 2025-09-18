package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Asset extends BasePage{

//    private final By assettab = By.xpath("//*[@aria-describedby='«rf»']");
    private final By assettab = By.xpath("//div[@class='_MainSidecontainer_dyg2d_1']//div[@class='_NavigationIcon_dyg2d_23'][7]");
    private final By createAssetButton = By.xpath("//div[@class='_TabHeader_1vq1m_12']//div/button[3]");
    private final By assettype = By.id("rc_select_1");
    private final By department = By.id("rc_select_2");
    private final By elevationlevel = By.id("rc_select_3");
    private final By workorder = By.id("rc_select_5");
    private final By model = By.id("rc_select_4");
    private final By date = By.xpath("//input[@placeholder='Select Date']");
    private final By notificationDateTime = By.xpath("//input[@placeholder='Select Notification Date & Time']");
    private final By extradata = By.cssSelector("div[class='_FeildColLeft_e1z2y_224'] div[class='_AddExtraDataFeild_e1z2y_344']");
    private final By extradataname = By.xpath("//input[@placeholder='Name here']");
    private final By extradatadesc = By.xpath("//textarea[@placeholder='Description here']");
    private final By extradatasetting = By.xpath("//body//div//div[@class='ant-drawer-body']//div//div[2]//*[name()='svg']");
    private final By extradataButton = By.xpath("//button[normalize-space()='Add Data']");
    private final By closeextradata = By.xpath("//div[@class='ant-drawer-content-wrapper']//button[@aria-label='Close']");
    private final By notificationtimeminute = By.xpath("//input[@placeholder='Enter Pre-Notification Time']");
    private final By uploadPhoto = By.xpath("(//input[@accept='.png,.jpg,.jpeg,.svg'])");
    private final By uploadDoc = By.xpath("(//input[@accept='.pdf,.docx,.doc'])");
    private final By circlemap = By.xpath("//div[@class='_PolyCard_1fzsm_250']//div[1]");
    private final By addassetbutton = By.xpath("//button[normalize-space()='Add Asset']");
    private final By optionasset = By.xpath("(//*[name()='svg'][@class='ant-dropdown-trigger'])[1]");
    private final By editassetbutton = By.xpath("//button[normalize-space()='Save Asset']");

    private final Random random = new Random();

    private String getRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    public void setassettab() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(assettab).click();
    }
    public void createButton() throws InterruptedException {
        driver.findElement(createAssetButton).click();
    }
    public void setAssettype() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement assettypefield = wait.until(ExpectedConditions.presenceOfElementLocated(assettype));
        Thread.sleep(1000);
        assettypefield.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_1_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Selected option index of asset type: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
    }
    public void setDepartment() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement departmentfield = wait.until(ExpectedConditions.presenceOfElementLocated(department));
        Thread.sleep(1000);
        departmentfield.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_2_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Selected option index of department: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
    }
    public void setElevationlevel() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement elevationlevelField = wait.until(ExpectedConditions.presenceOfElementLocated(elevationlevel));
        Thread.sleep(1000);
        elevationlevelField.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_2_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (options.size() < 3) {
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
                    By.xpath("//div[@id='rc_select_3_list']/following-sibling::div//div[@class='ant-select-item-option-content']")
            );
            if (index < refreshedOptions.size()) {
                refreshedOptions.get(index).click();
                System.out.println("Selected option index: " + index);
            }
            Thread.sleep(500);
        }
    }
    public void setWorkorder() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement workorderfield = wait.until(ExpectedConditions.presenceOfElementLocated(workorder));
        Thread.sleep(1000);
        workorderfield.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_5_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Selected option index of workorder: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
        Thread.sleep(1000);
    }
    public void setModel() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement modelfield = wait.until(ExpectedConditions.presenceOfElementLocated(model));
        Thread.sleep(1000);
        modelfield.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_4_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Selected option index of model: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
        Thread.sleep(1000);
    }

    public void setDate() {
        driver.findElement(date).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Today']")));
        date.click();
        System.out.println("Date and time selected successfully!");
    }
    public void setNotificationdatetime() {
        driver.findElement(notificationDateTime).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Now']")));
        date.click();
        System.out.println("Date and time selected successfully!");
    }
    public void exdata() throws InterruptedException {
        driver.findElement(extradata).click();
        driver.findElement(extradataname).sendKeys(getRandomString(6));
        driver.findElement(extradatadesc).sendKeys(getRandomString(6));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));


        WebElement extradatas = wait.until(ExpectedConditions.presenceOfElementLocated(extradatasetting));
        Thread.sleep(1000);
        extradatas.click();


        List<WebElement> options = driver.findElements(By.xpath("//li//span//div"));

        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            WebElement selectedOption = options.get(randomIndex);
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
    }
    public void noticationtimemint() {
        driver.findElement(notificationtimeminute).sendKeys("5");
    }
    public void setUploadPhoto() {
        driver.findElement(uploadPhoto).sendKeys("C:\\Users\\Maze Digital\\Pictures\\Screenshots\\Screenshot 2025-07-14 203433.png");
    }

    public void setUploadDoc() {
        driver.findElement(uploadDoc).sendKeys("C:\\Users\\Maze Digital\\Desktop\\dummy.pdf");
    }

    public void setCirclemap() {
        driver.findElement(circlemap).click();
    }

    public void setAddassetbutton() throws InterruptedException {
        driver.findElement(addassetbutton).click();
        Thread.sleep(1000);
    }


    public void optassetview() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optview = wait.until(ExpectedConditions.presenceOfElementLocated(optionasset));
        Thread.sleep(1000);
        optview.click();
        WebElement viewasset = driver.findElement(By.xpath("//div[normalize-space()='View Assets']"));
        viewasset.click();
    }
    public void optassetdel() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optdel = wait.until(ExpectedConditions.presenceOfElementLocated(optionasset));
        Thread.sleep(1000);
        optdel.click();
        WebElement viewasset = driver.findElement(By.xpath("//div[normalize-space()='Archived Assets']"));
        viewasset.click();
//        try {
//                        Alert alert = driver.switchTo().alert();
//                        //alert.accept();
//                        alert.dismiss();
//                    } catch (NoAlertPresentException e) {
//                        System.out.println("No alert present after clicking Archived Assets.");
//                    }
        try {
//            WebElement yes = driver.findElement(By.xpath("//button[@class='_CheckBtn_1vq1m_146']//*[name()='svg']"));
//            yes.click();
            WebElement no = driver.findElement(By.xpath("//button[contains(@class,'_CloseBtn_1vq1m_162')]//*[name()='svg']"));
            no.click();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present after clicking Archived Assets.");
        }
    }
    public void optassetedit() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optedit = wait.until(ExpectedConditions.presenceOfElementLocated(optionasset));
        Thread.sleep(1000);
        optedit.click();
        WebElement editasset = driver.findElement(By.xpath("//div[normalize-space()='Edit Assets']"));
        editasset.click();


        WebElement editelevationlevelField = wait.until(ExpectedConditions.presenceOfElementLocated(elevationlevel));
        Thread.sleep(1000);
        editelevationlevelField.click();
        List<WebElement> elevationOptions = driver.findElements(By.xpath("//div[@id='rc_select_3_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        Set<Integer> selectedIndexes = new HashSet<>();
        while (selectedIndexes.size() < 2 && elevationOptions.size() >= 2) {
            selectedIndexes.add(new Random().nextInt(elevationOptions.size()));
        }
        for (int index : selectedIndexes) {
            editelevationlevelField.click();
            Thread.sleep(500);
            List<WebElement> refreshedOptions = driver.findElements(By.xpath("//div[@id='rc_select_3_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
            if (index < refreshedOptions.size()) {
                refreshedOptions.get(index).click();
            }
            Thread.sleep(500);
        }

        driver.findElement(editassetbutton).click();
        Thread.sleep(1000);
    }
}
