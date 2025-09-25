package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Workorder extends BasePage {
//    private final By wotab = By.xpath("//*[@aria-describedby='«rj»']");
private final By wotab = By.cssSelector("div[class='_sideBarScroller_123ft_14'] div:nth-child(9)");
    private final By createwobButton = By.xpath("//div[@class='_TabHeader_1vq1m_12']//div/button[4]");
    public final By title = By.xpath("//input[@placeholder='Enter Title']");
    private final By priority = By.id("rc_select_2");
    private final By AssignTo = By.id("rc_select_3");
    private final By dateaccess = By.xpath("//input[@placeholder='Select Date Access Available']");
    private final By profitchargeable = By.id("rc_select_4");
    private final By completionDate = By.xpath("//input[@placeholder='Select Completion Date Requirement']");
    private final By location = By.xpath("//input[@placeholder='Enter Location']");
    private final By entryreq = By.xpath("//input[@placeholder='Enter Entry Requirment']");
    private final By workhours = By.cssSelector("div._FeildColRight_1fzsm_241 > div._AddExtraDataFeild_1fzsm_344:nth-of-type(1)");
    private final By workhourname = By.xpath("//input[@placeholder='Name here']");
    private final By workhourdate = By.xpath("//input[@placeholder='Date here']");
    private final By workhour = By.xpath("//input[@placeholder='Number of hours']");
    private final By workhourstick = By.xpath("//body//div//div[@class='ant-drawer-body']//div//div[3]//*[name()='svg']");
    private final By workhourbutton = By.xpath("//button[normalize-space()='Add Work']");
    private final By closeworkhour = By.xpath("//button[@aria-label='Close']");
    private final By extradata = By.cssSelector("div._FeildColLeft_1fzsm_224 > div._AddExtraDataFeild_1fzsm_344:nth-of-type(1)");
    private final By extradataname = By.xpath("//div[@class='ant-drawer-content-wrapper']//div[@role='dialog']//div[@class='ant-drawer-body']//div//input[@placeholder='Name here']");
    private final By extradatadesc = By.xpath("//textarea[@placeholder='Description here']");
    private final By extradatasetting = By.xpath("//div[@class='ant-drawer ant-drawer-right css-nxgixn ant-drawer-open']//div[@class='ant-drawer-body']//div//div[2]//*[name()='svg']");
    private final By extradataButton = By.xpath("//button[normalize-space()='Add Data']");
    private final By closeextradata = By.xpath("//button[@aria-label='Close']");
    private final By material = By.xpath("//input[@placeholder='Enter Material or Parts Ordered']");
    private final By workreq = By.xpath("//textarea[@placeholder='Enter Work requested']");
    private final By jsatoggle = By.xpath("//button[@role='switch']");
    private final By uploadWarDoc = By.xpath("(//input[@accept='.pdf'])[1]");
    private final By uploadPhoto = By.xpath("(//input[@accept='.png,.jpg,.jpeg,.svg'])[1]");
    private final By uploadSafDoc = By.xpath("(//input[@accept='.pdf'])[2]");
    private final By email = By.xpath("//input[@placeholder='Enter Email copy to external contact']");
    private final By addemailbutton = By.cssSelector("._AddEmailBtn_1fzsm_447");
    private final By circlemap = By.xpath("//div[@class='_PolyCard_1fzsm_250']//div[1]");
    private final By addwobutton = By.xpath("//button[normalize-space()='Add work order']");
    private final By createdbyme = By.xpath("//button[normalize-space()='Created By Me']");
    private final By assignedtome = By.xpath("//button[normalize-space()='Assign To Me']");
    private final By optionwo = By.xpath("(//*[name()='svg'][@class='ant-dropdown-trigger'])[1]");
    private final By editwobutton = By.xpath("//button[normalize-space()='Save work order']");
    private final By search_wo = By.xpath("//input[@id='ListSearch']");


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
        return getRandomString(8) + "@example.com";
    }


    public void wo() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(wotab).click();
    }
    public void searchworkorder() throws InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            Thread.sleep(7000);
            driver.findElement(search_wo).sendKeys("wo");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            Thread.sleep(7000);

            driver.findElement(search_wo).sendKeys("wo");
        }
        Thread.sleep(4000);
    }
    public void createWoButton() throws InterruptedException {
        driver.findElement(createwobButton).click();
        Thread.sleep(1000);

        driver.findElement(title).sendKeys(getRandomString(6));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement prioritylevel = wait.until(ExpectedConditions.presenceOfElementLocated(priority));
        Thread.sleep(1000);
        prioritylevel.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='rc_select_2_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Selected option index of priority level: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
        Thread.sleep(1000);

        WebElement assignee = wait.until(ExpectedConditions.presenceOfElementLocated(AssignTo));
        Thread.sleep(1000);
        assignee.click();
        Thread.sleep(1000);

        List<WebElement> options1 = driver.findElements(By.xpath("//div[@id='rc_select_3_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options1.isEmpty()) {
            Random rand1 = new Random();
            int randomIndex = rand1.nextInt(options1.size());
            options1.get(randomIndex).click();
            System.out.println("Selected option index of assignee: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
        Thread.sleep(1000);

        driver.findElement(dateaccess).click();

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Now']")));
        date.click();
        Thread.sleep(1000);

        WebElement profit = wait.until(ExpectedConditions.presenceOfElementLocated(profitchargeable));
        Thread.sleep(1000);
        profit.click();
        List<WebElement> options2 = driver.findElements(By.xpath("//div[@id='rc_select_4_list']/following-sibling::div//div[@class='ant-select-item-option-content']"));
        if (!options2.isEmpty()) {
            Random rand2 = new Random();
            int randomIndex = rand2.nextInt(options2.size());
            options2.get(randomIndex).click();
            System.out.println("Selected option index of profit chargeable: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
        Thread.sleep(1000);

//        driver.findElement(completionDate).click();
//        WebElement date1 = wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector("div[class='ant-picker-dropdown css-nxgixn ant-picker-dropdown-placement-bottomRight'] div[class='ant-picker-panel-container ant-picker-datetime-panel-container'] div[class='ant-picker-panel-layout'] div a[class='ant-picker-now-btn']")));
//        date1.click();
//
//        Thread.sleep(1000);

        driver.findElement(location).sendKeys(getRandomString(6));

        driver.findElement(entryreq).sendKeys(getRandomString(6));

        driver.findElement(workhours).click();
        driver.findElement(workhourname).sendKeys(getRandomString(6));
        driver.findElement(workhourdate).click();
        WebElement dateselected = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Today']")));
        dateselected.click();
        driver.findElement(workhour).sendKeys("5");
        driver.findElement(workhourstick).click();
        driver.findElement(workhourbutton).click();
        driver.findElement(closeworkhour).click();

        driver.findElement(extradata).click();
        driver.findElement(extradataname).sendKeys(getRandomString(6));
        driver.findElement(extradatadesc).sendKeys(getRandomString(6));

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

        driver.findElement(material).sendKeys(getRandomString(6));
        driver.findElement(workreq).sendKeys(getRandomString(6));
        driver.findElement(jsatoggle).click();
        driver.findElement(uploadWarDoc).sendKeys("C:\\Users\\Administrator\\Documents\\Dummy.pdf");
        driver.findElement(uploadPhoto).sendKeys("C:\\Users\\Administrator\\Pictures\\Screenshots\\Screenshot 2025-09-22 060314.png");
        driver.findElement(uploadSafDoc).sendKeys("C:\\Users\\Administrator\\Documents\\Dummy.pdf");
        driver.findElement(email).sendKeys(getRandomEmail());
        driver.findElement(addemailbutton).click();
        driver.findElement(circlemap).click();
        driver.findElement(addwobutton).click();
        Thread.sleep(1000);
    }

    public void createBYme(){
        driver.findElement(createdbyme).click();
    }

    public void optwoview() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optview = wait.until(ExpectedConditions.presenceOfElementLocated(optionwo));
        Thread.sleep(1000);
        optview.click();
        WebElement viewwo = driver.findElement(By.xpath("//div[normalize-space()='View Work Order']"));
        viewwo.click();
    }
    public void optwodel() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optdel = wait.until(ExpectedConditions.presenceOfElementLocated(optionwo));
        Thread.sleep(1000);
        optdel.click();
        WebElement viewwo = driver.findElement(By.xpath("//div[normalize-space()='Archive Work Order']"));
        viewwo.click();
        try {
//            WebElement yes = driver.findElement(By.xpath("//button[@class='_CheckBtn_1vq1m_146']//*[name()='svg']"));
//            yes.click();
            WebElement no = driver.findElement(By.xpath("//button[contains(@class,'_CloseBtn_1vq1m_162')]//*[name()='svg']"));
            no.click();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present after clicking Archived Work Order.");
        }
    }
    public void optwoedit() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optedit = wait.until(ExpectedConditions.presenceOfElementLocated(optionwo));
        Thread.sleep(1000);
        optedit.click();
        WebElement editwo = driver.findElement(By.xpath("//div[normalize-space()='Edit Work Order']"));
        editwo.click();
        Thread.sleep(1000);

        WebElement edittitleField = driver.findElement(title);
        edittitleField.clear();
        edittitleField.sendKeys(getRandomString(6));

        WebElement locationField = driver.findElement(location);
        locationField.clear();
        locationField.sendKeys(getRandomString(6));
        Thread.sleep(1000);

        driver.findElement(editwobutton).click();
        Thread.sleep(1000);
    }
    public void optwocomp() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement optview = wait.until(ExpectedConditions.presenceOfElementLocated(optionwo));
        Thread.sleep(1000);
        optview.click();
        WebElement compwo = driver.findElement(By.xpath("//div[normalize-space()='Complete']"));
        compwo.click();
        WebElement uploadjsa = driver.findElement(By.xpath("(//input[@accept='.pdf,.docx,.doc'])"));
        uploadjsa.sendKeys("C:\\Users\\Administrator\\Documents\\Dummy.pdf");

        WebElement comp = driver.findElement(By.xpath("//button[normalize-space()='Save changes']"));
        comp.click();
    }
    public void assignedTome(){
        driver.findElement(assignedtome).click();
    }
}
