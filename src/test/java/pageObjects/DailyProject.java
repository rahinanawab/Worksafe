package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class DailyProject extends BasePage{
    private final By projecttab = By.xpath("//*[@aria-describedby='«rh»']");
    private final By optionproject = By.xpath("(//*[name()='svg'][@class='ant-dropdown-trigger'])[1]");
    private final By dailyproject = By.xpath("(//div[@class='_FeildColLeft_e1z2y_224']//div[@class='_AddExtraDataFeild_e1z2y_344'])[2]");
    private final By createdailyProjectButton = By.xpath("//div[@class='_TabHeader_1vq1m_12']//div/button[2]");
    private final By projectname = By.xpath("//input[@placeholder='Enter Project Name']");
    private final By address = By.xpath("//input[@placeholder='Enter Address']");
    private final By workhours = By.cssSelector("div._FeildColLeft_1temh_224 > div._AddExtraDataFeild_1temh_358:nth-of-type(1)");
    private final By workhourname = By.xpath("//input[@placeholder='Name here']");
    private final By workhourdate = By.xpath("//input[@placeholder='Date here']");
    private final By workhour = By.xpath("//input[@placeholder='Number of hours']");
    private final By workhourstick = By.xpath("//body//div//div[@class='ant-drawer-body']//div//div[3]//*[name()='svg']");
    private final By workhourbutton = By.xpath("//button[normalize-space()='Add Work']");
    private final By closeworkhour = By.xpath("//button[@aria-label='Close']");
    private final By extradata = By.cssSelector("div._FeildColRight_1temh_240> div._AddExtraDataFeild_1temh_358:nth-of-type(1)");
    private final By extradataname = By.xpath("//div[@class='ant-drawer-content-wrapper']//div[@role='dialog']//div[@class='ant-drawer-body']//div//input[@placeholder='Name here']");
    private final By extradatadesc = By.xpath("//textarea[@placeholder='Description here']");
    private final By extradatasetting = By.xpath("//div[@class='ant-drawer ant-drawer-right css-nxgixn ant-drawer-open']//div[@class='ant-drawer-body']//div//div[2]//*[name()='svg']");
    private final By extradataButton = By.xpath("//button[normalize-space()='Add Data']");
    private final By nearmissocc = By.cssSelector("div[class='_FeildColLeftSwitch_1temh_233'] button[role='switch']");
    private final By contractor = By.xpath("(//div[@class='_AddExtraDataFeild_1temh_358']//button[text()='Add'])[3]");
    private final By contractorname = By.xpath("//input[@placeholder='Enter Name']");
    private final By contractoraddress = By.xpath("//div[@class='ant-drawer-body']//div//input[@placeholder='Enter Address']");
    private final By contractorzipcode = By.xpath("//input[@placeholder='Enter Zip Code']");
    private final By contractorstate = By.xpath("//input[@placeholder='Enter State']");
    private final By contractorcountry = By.xpath("//input[@placeholder='Enter Country']");
    private final By contractorphone = By.xpath("//input[@placeholder='Enter Phone']");
    private final By contractoremail = By.xpath("//input[@placeholder='Enter Email']");
    private final By contractorpurchasedno = By.xpath("//input[@placeholder='Enter Purchase Number']");
    private final By contractoraddbutton = By.xpath("//button[normalize-space()='Add Contractor']");
    private final By selectcontractor = By.xpath("//label[text()='Contractor']/following::p[contains(text(), 'Select Contractor')][1]");
    private final By selectCheckbox = By.cssSelector("input.ant-checkbox-input");
    private final By closecontractor = By.xpath("//div[@class='ant-drawer-content-wrapper']//button[@aria-label='Close']");
    private final By incidentreview = By.xpath("//input[@placeholder='Enter Incident Review']");
    private final By reportedto = By.id("rc_select_5");
    private final By reporteddate = By.xpath("//input[@placeholder='Select Reported Date']");
    private final By whathappened = By.xpath("//input[@placeholder='Enter What Happened']");
    private final By whydidithappened = By.xpath("//input[@placeholder='Enter Why Did It Happen']");
    private final By reoccurance = By.xpath("//input[@placeholder='Enter How To Prevent Reoccurance']");
    private final By scope = By.cssSelector("div[class='_FeildColRightSwitch_1temh_240'] button[role='switch']");
    private final By description = By.xpath("//input[@placeholder='Enter Descriptions Of Changes']");
    private final By safetyconcerns = By.xpath("//input[@placeholder='Enter Safety Concerns Of Changes']");
    private final By email = By.xpath("//input[@placeholder='Enter Notifications Emails']");
    private final By addemailbutton = By.cssSelector("._AddEmailBtn_1temh_461");
    private final By approvers = By.id("rc_select_6");
    private final By dateapproved = By.xpath("//input[@placeholder='Select Date Approved']");
    private final By remainderdatetime = By.xpath("//input[@placeholder='Select Reminder Date & Time']");
    private final By uploadPhoto = By.xpath("(//input[@accept='.png,.jpg,.jpeg,.svg'])");
    private final By uploadDoc = By.xpath("(//input[@accept='.pdf,.docx,.doc'])[1]");
    private final By uploadSafetyDoc = By.xpath("(//input[@accept='.pdf,.docx,.doc'])[2]");
    private final By uploadWarrentyDoc = By.xpath("(//input[@accept='.pdf,.docx,.doc'])[3]");
    private final By adddailyprojectbutton = By.xpath("//button[normalize-space()='Add Daily Project']");
    private final By uploadSpacePaperwork = By.xpath("(//input[@accept='.pdf,.docx,.doc'])[4]");
    private final By uploadJsa = By.xpath("(//input[@accept='.pdf,.docx,.doc'])[5]");
    private final By adddailyprojectbutton1 = By.xpath("//div[@class='ant-modal-body']//div//button[contains(text(),'Add Daily Project')]");
    private final By optiondailyproject = By.xpath("(//*[name()='svg'][@class='ant-dropdown-trigger'])[1]");
    private final By editdailyprojectbutton = By.xpath("//button[normalize-space()='Save Daily Project']");

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

    private String getRandomDigits(int length) {
        String digits = "0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result.append(digits.charAt(random.nextInt(digits.length())));
        }
        return result.toString();
    }

    private String getRandomAlphaNumeric(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    public void project() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(projecttab).click();
    }
    public void optprojectview() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optview = wait.until(ExpectedConditions.presenceOfElementLocated(optionproject));
        Thread.sleep(1000);
        optview.click();
        WebElement viewproject = driver.findElement(By.xpath("//div[normalize-space()='View Project']"));
        viewproject.click();
    }
    public void setDailyproject() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement dailypro = wait.until(ExpectedConditions.presenceOfElementLocated(dailyproject));
        Thread.sleep(2000);
        dailypro.click();
    }
    public void createdailyButton() throws InterruptedException {
        driver.findElement(createdailyProjectButton).click();
        driver.findElement(projectname).sendKeys(getRandomString(6));
        driver.findElement(address).sendKeys(getRandomString(6));
        driver.findElement(workhours).click();
        driver.findElement(workhourname).sendKeys(getRandomString(6));
        driver.findElement(workhourdate).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement dateselected = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Today']")));
        dateselected.click();
        driver.findElement(workhour).sendKeys("5");
        driver.findElement(workhourstick).click();
        driver.findElement(workhourbutton).click();
        driver.findElement(closeworkhour).click();
    }
    public void exdata() throws InterruptedException {
        driver.findElement(extradata).click();
        driver.findElement(extradataname).sendKeys(getRandomString(6));
        driver.findElement(extradatadesc).sendKeys(getRandomString(6));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement extradatas = wait.until(ExpectedConditions.presenceOfElementLocated(extradatasetting));
        Thread.sleep(1000);
        extradatas.click();
        List<WebElement> options3 = driver.findElements(By.xpath("//li//span//div"));
        if (!options3.isEmpty()) {
            Random rand1 = new Random();
            int randomIndex = rand1.nextInt(options3.size());
            WebElement selectedOption = options3.get(randomIndex);
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
                            By.xpath("//a[normalize-space()='Today']")));
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
        Actions actions = new Actions(driver);
        actions.moveByOffset(10, 10).click().perform();
        Thread.sleep(1000);
    }
    public void occurance() throws InterruptedException {
        driver.findElement(nearmissocc).click();
        driver.findElement(contractor).click();
        driver.findElement(contractorname).sendKeys(getRandomString(6));
        driver.findElement(contractoraddress).sendKeys(getRandomString(6));
        driver.findElement(contractorzipcode).sendKeys(getRandomDigits(5));
        driver.findElement(contractorstate).sendKeys(getRandomString(6));
        driver.findElement(contractorcountry).sendKeys(getRandomString(6));
        driver.findElement(contractorphone).sendKeys(getRandomDigits(12));
        driver.findElement(contractoremail).sendKeys(getRandomEmail());
        driver.findElement(contractorpurchasedno).sendKeys(getRandomAlphaNumeric(10));
        driver.findElement(contractoraddbutton).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(1000);
        WebElement member = driver.findElement(selectcontractor);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", member);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", member);

        List<WebElement> checkboxes = driver.findElements(selectCheckbox);
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
        WebElement closeBtn = driver.findElement(closecontractor);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
        Thread.sleep(1000);
        driver.findElement(incidentreview).sendKeys(getRandomString(6));
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement reportedfield = wait.until(ExpectedConditions.presenceOfElementLocated(reportedto));
        Thread.sleep(1000);
        reportedfield.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_5_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Selected option index of verbally reported to: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
        Thread.sleep(1000);
        driver.findElement(reporteddate).click();
        WebElement todaydate = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Now']")));
        todaydate.click();
        Thread.sleep(1000);
        driver.findElement(whathappened).sendKeys(getRandomString(6));
        Thread.sleep(1000);
        driver.findElement(whydidithappened).sendKeys(getRandomString(6));
        Thread.sleep(1000);
        driver.findElement(reoccurance).sendKeys(getRandomString(6));
    }
    public void setScope() throws InterruptedException {
        driver.findElement(scope).click();
        Thread.sleep(1000);
        driver.findElement(description).sendKeys(getRandomString(6));
        Thread.sleep(1000);
        driver.findElement(safetyconcerns).sendKeys(getRandomString(6));
        Thread.sleep(1000);
        driver.findElement(email).sendKeys(getRandomEmail());
        driver.findElement(addemailbutton).click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement approversField = wait.until(ExpectedConditions.presenceOfElementLocated(approvers));
        Thread.sleep(1000);
        approversField.click();
        List<WebElement> options1 = driver.findElements(By.xpath("//div[@id='rc_select_6_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (options1.size() < 2) {
            System.out.println("Not enough options to select");
            return;
        }
        Random rand = new Random();
        Set<Integer> selectedIndexes = new HashSet<>();
        while (selectedIndexes.size() < 1) {
            selectedIndexes.add(rand.nextInt(options1.size()));
        }
        for (int index : selectedIndexes) {
            approversField.click();
            Thread.sleep(500);

            List<WebElement> refreshedOptions = driver.findElements(
                    By.xpath("//div[@id='rc_select_6_list']/following-sibling::div//div[@class='ant-select-item-option-content']")
            );
            if (index < refreshedOptions.size()) {
                refreshedOptions.get(index).click();
                System.out.println("Selected option index: " + index);
            }
            Thread.sleep(500);
        }
        driver.findElement(dateapproved).click();
        WebElement approveddate = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-picker-dropdown css-nxgixn ant-picker-dropdown-placement-topLeft']//div[@class='ant-picker-panel-container ant-picker-datetime-panel-container']//div[@class='ant-picker-panel-layout']//div//a[@class='ant-picker-now-btn'][normalize-space()='Now']")));
        approveddate.click();
        Thread.sleep(1000);
        driver.findElement(remainderdatetime).click();
        WebElement remainderdate = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-picker-dropdown css-nxgixn ant-picker-dropdown-placement-topLeft']//div[@class='ant-picker-panel-container ant-picker-datetime-panel-container']//div[@class='ant-picker-panel-layout']//div//a[@class='ant-picker-now-btn'][normalize-space()='Now']")));
        remainderdate.click();
        Thread.sleep(1000);
    }

    public void setUploadPhoto() {
        driver.findElement(uploadPhoto).sendKeys("C:\\Users\\Maze Digital\\Pictures\\Screenshots\\Screenshot 2025-07-14 203433.png");
    }

    public void setUploadDoc() {
        driver.findElement(uploadDoc).sendKeys("C:\\Users\\Maze Digital\\Desktop\\dummy.pdf");
    }

    public void setUploadSafetyDoc() {
        driver.findElement(uploadSafetyDoc).sendKeys("C:\\Users\\Maze Digital\\Desktop\\dummy.pdf");
    }

    public void setUploadWarrentyDoc() {
        driver.findElement(uploadWarrentyDoc).sendKeys("C:\\Users\\Maze Digital\\Desktop\\dummy.pdf");
    }

    public void setAdddailyprojectbutton() throws InterruptedException {
        driver.findElement(adddailyprojectbutton).click();
        Thread.sleep(4000);
    }

    public void setUploadSpacePaperwork() {
        driver.findElement(uploadSpacePaperwork).sendKeys("C:\\Users\\Maze Digital\\Desktop\\dummy.pdf");
    }
    public void setUploadJsa() {
        driver.findElement(uploadJsa).sendKeys("C:\\Users\\Maze Digital\\Desktop\\dummy.pdf");
    }
    public void setAdddailyprojectbutton1() throws InterruptedException {
        driver.findElement(adddailyprojectbutton1).click();
        Thread.sleep(1000);
    }

    public void optdailyprojectview() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optview = wait.until(ExpectedConditions.presenceOfElementLocated(optiondailyproject));
        Thread.sleep(1000);
        optview.click();
        WebElement viewdailyproject = driver.findElement(By.xpath("//div[normalize-space()='View Daily Project']"));
        viewdailyproject.click();
    }
    public void optdailyprojectdel() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optdel = wait.until(ExpectedConditions.presenceOfElementLocated(optiondailyproject));
        Thread.sleep(1000);
        optdel.click();
        WebElement viewdailyproject = driver.findElement(By.xpath("//div[normalize-space()='Delete Daily Project']"));
        viewdailyproject.click();
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
            System.out.println("No alert present after clicking Delete Daily Project.");
        }
    }
    public void optdailyprojectedit() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optedit = wait.until(ExpectedConditions.presenceOfElementLocated(optiondailyproject));
        Thread.sleep(1000);
        optedit.click();
        WebElement editproject = driver.findElement(By.xpath("//div[normalize-space()='Edit Daily Project']"));
        editproject.click();

        WebElement projectnamefield = driver.findElement(projectname);
        projectnamefield.clear();
        projectnamefield.sendKeys(getRandomString(6));

        WebElement editapproversField = wait.until(ExpectedConditions.presenceOfElementLocated(approvers));
        Thread.sleep(1000);
        editapproversField.click();
        List<WebElement> elevationOptions = driver.findElements(By.xpath("//div[@id='rc_select_6_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        Set<Integer> selectedIndexes = new HashSet<>();
        while (selectedIndexes.size() < 2 && elevationOptions.size() >= 2) {
            selectedIndexes.add(new Random().nextInt(elevationOptions.size()));
        }
        for (int index : selectedIndexes) {
            editapproversField.click();
            Thread.sleep(500);
            List<WebElement> refreshedOptions = driver.findElements(By.xpath("//div[@id='rc_select_6_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
            if (index < refreshedOptions.size()) {
                refreshedOptions.get(index).click();
            }
            Thread.sleep(500);
        }

        driver.findElement(editdailyprojectbutton).click();
        Thread.sleep(1000);
    }
}
