package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class Project extends BasePage {
//    private final By projecttab = By.xpath("//*[@aria-describedby='«rh»']");
private final By projecttab = By.cssSelector("div[class='_sideBarScroller_123ft_14'] div:nth-child(8)");
    private final By createProjectButton = By.xpath("//div[@class='_TabHeader_1vq1m_12']//div/button[3]");
    private final By projectname = By.xpath("//input[@placeholder='Enter Project Name']");
    private final By department = By.id("rc_select_1");
    private final By elevationlevel = By.id("rc_select_2");
    private final By workorder = By.id("rc_select_4");
    private final By projectmanager = By.id("rc_select_3");
    private final By contractor = By.cssSelector("div[class='_FeildColRight_e1z2y_241'] div[class='_AddExtraDataFeild_e1z2y_344'] div button");
    private final By contractorname = By.xpath("//input[@placeholder='Enter Name']");
    private final By contractoraddress = By.xpath("//input[@placeholder='Enter Address']");
    private final By contractorzipcode = By.xpath("//input[@placeholder='Enter Zip Code']");
    private final By contractorstate = By.xpath("//input[@placeholder='Enter State']");
    private final By contractorcountry = By.xpath("//input[@placeholder='Enter Country']");
    private final By contractorphone = By.xpath("//input[@placeholder='Enter Phone']");
    private final By contractoremail = By.xpath("//input[@placeholder='Enter Email']");
    private final By contractorpurchasedno = By.xpath("//input[@placeholder='Enter Purchase Number']");
    private final By contractoraddbutton = By.xpath("//button[normalize-space()='Add Contractor']");
    private final By selectcontractor = By.xpath("//div[@class='_FeildColRight_e1z2y_241']//div[@class='_AddExtraDataFeild_e1z2y_344']//div[1]");
    private final By selectCheckbox = By.cssSelector("input.ant-checkbox-input");
    private final By closecontractor = By.xpath("//div[@class='ant-drawer-content-wrapper']//button[@aria-label='Close']");
    private final By extradata = By.xpath("(//div[@class='_FeildColLeft_e1z2y_224']//div[@class='_AddExtraDataFeild_e1z2y_344'])[1]");
    private final By extradataname = By.xpath("//input[@placeholder='Name here']");
    private final By extradatadesc = By.xpath("//textarea[@placeholder='Description here']");
    private final By extradatasetting = By.xpath("//body//div//div[@class='ant-drawer-body']//div//div[2]//*[name()='svg']");
    private final By extradataButton = By.xpath("//button[normalize-space()='Add Data']");
    private final By closeextradata = By.xpath("//div[@class='ant-drawer-content-wrapper']//button[@aria-label='Close']");
    private final By notificationDateTime = By.xpath("//input[@placeholder='Select Notification Date & Time']");
    private final By notificationtimeminute = By.xpath("//input[@placeholder='Enter Pre-Notification Time']");
    private final By uploadPhoto = By.xpath("(//input[@accept='.png,.jpg,.jpeg,.svg'])");
    private final By uploadDoc = By.xpath("(//input[@accept='.pdf,.docx,.doc'])[1]");
    private final By uploadSafetyDoc = By.xpath("(//input[@accept='.pdf,.docx,.doc'])[2]");
    private final By uploadWarrentyDoc = By.xpath("(//input[@accept='.pdf,.docx,.doc'])[3]");
    private final By uploadTrainingDoc = By.xpath("(//input[@accept='.png,.jpg,.jpeg,.svg,.pdf'])[1]");
    private final By uploadPermitDoc = By.xpath("(//input[@accept='.png,.jpg,.jpeg,.svg,.pdf'])[2]");
    private final By circlemap = By.xpath("//div[@class='_PolyCard_1fzsm_250']//div[1]");
    private final By addprojectbutton = By.xpath("//button[normalize-space()='Add Project']");
    private final By uploadSpacePaperwork = By.xpath("(//input[@accept='.pdf,.docx,.doc'])[4]");
    private final By uploadJsa = By.xpath("(//input[@accept='.pdf,.docx,.doc'])[5]");
    private final By addprojectbutton1 = By.xpath("//div[@class='ant-modal-body']//div//button[contains(text(),'Add Project')]");
    private final By optionproject = By.xpath("(//*[name()='svg'][@class='ant-dropdown-trigger'])[1]");
    private final By editprojectbutton = By.xpath("//button[normalize-space()='Save Project']");
    private final By search_project = By.xpath("//input[@id='ListSearch']");

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
    public void searchproject() throws InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            Thread.sleep(7000);
            driver.findElement(search_project).sendKeys("gtftfft");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            Thread.sleep(7000);

            driver.findElement(search_project).sendKeys("gtftfft");
        }
        Thread.sleep(4000);
    }
    public void createButton() throws InterruptedException {
        driver.findElement(createProjectButton).click();
        driver.findElement(projectname).sendKeys(getRandomString(6));
    }
    public void dept() throws InterruptedException {
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
    }

    public void elevation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

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

    }

    public void wo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement workorderfield = wait.until(ExpectedConditions.presenceOfElementLocated(workorder));
        Thread.sleep(1000);
        workorderfield.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_4_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options.isEmpty()) {
            Random rand1 = new Random();
            int randomIndex = rand1.nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Selected option index of workorder: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
    }

    public void projman() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement projmanager = wait.until(ExpectedConditions.presenceOfElementLocated(projectmanager));
        Thread.sleep(1000);
        projmanager.click();
        Thread.sleep(500);

        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_3_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Selected option index of proj manager: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
        Thread.sleep(1000);
    }

    public void con() throws InterruptedException {
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

    public void notificationdatetime() {
        driver.findElement(notificationDateTime).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

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
    }

    public void noticationtimemint() {
        driver.findElement(notificationtimeminute).sendKeys("5");
    }

    public void setUploadPhoto() {
        driver.findElement(uploadPhoto).sendKeys("C:\\Users\\Administrator\\Pictures\\Screenshots\\Screenshot 2025-09-22 060314.png");
    }

    public void setUploadDoc() {
        driver.findElement(uploadDoc).sendKeys("C:\\Users\\Administrator\\Documents\\Dummy.pdf");
    }

    public void setUploadSafetyDoc() {
        driver.findElement(uploadSafetyDoc).sendKeys("C:\\Users\\Administrator\\Documents\\Dummy.pdf");
    }

    public void setUploadWarrentyDoc() {
        driver.findElement(uploadWarrentyDoc).sendKeys("C:\\Users\\Administrator\\Documents\\Dummy.pdf");
    }

    public void setUploadTrainingDoc() {
        driver.findElement(uploadTrainingDoc).sendKeys("C:\\Users\\Administrator\\Documents\\Dummy.pdf");
    }

    public void setUploadPermitDoc() {
        driver.findElement(uploadPermitDoc).sendKeys("C:\\Users\\Administrator\\Documents\\Dummy.pdf");
    }

    public void setCirclemap() {
        driver.findElement(circlemap).click();
    }

    public void setAddprojectbutton() throws InterruptedException {
        driver.findElement(addprojectbutton).click();
        Thread.sleep(1000);
    }
    public void setUploadSpacePaperwork() {
        driver.findElement(uploadSpacePaperwork).sendKeys("C:\\Users\\Administrator\\Documents\\Dummy.pdf");
    }
    public void setUploadJsa() {
        driver.findElement(uploadJsa).sendKeys("C:\\Users\\Administrator\\Documents\\Dummy.pdf");
    }
    public void setAddprojectbutton1() throws InterruptedException {
        driver.findElement(addprojectbutton1).click();
        Thread.sleep(1000);
    }
public void optprojectview() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    WebElement optview = wait.until(ExpectedConditions.presenceOfElementLocated(optionproject));
    Thread.sleep(1000);
    optview.click();
    WebElement viewproject = driver.findElement(By.xpath("//div[normalize-space()='View Project']"));
    viewproject.click();
}
public void optprojectdel() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    WebElement optdel = wait.until(ExpectedConditions.presenceOfElementLocated(optionproject));
    Thread.sleep(1000);
    optdel.click();
    WebElement viewproject = driver.findElement(By.xpath("//div[normalize-space()='Archived Project']"));
    viewproject.click();
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
        System.out.println("No alert present after clicking Archived Project.");
    }
}
public void optprojectedit() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    WebElement optedit = wait.until(ExpectedConditions.presenceOfElementLocated(optionproject));
    Thread.sleep(1000);
    optedit.click();
    WebElement editproject = driver.findElement(By.xpath("//div[normalize-space()='Edit Project']"));
    editproject.click();

    WebElement projectnamefield = driver.findElement(projectname);
    projectnamefield.clear();
    projectnamefield.sendKeys(getRandomString(6));

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

    driver.findElement(editprojectbutton).click();
    Thread.sleep(1000);
}
}
