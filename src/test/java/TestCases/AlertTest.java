package TestCases;

import org.testng.annotations.Test;
import pageObjects.Alert;

public class AlertTest extends BaseTest {
    @Test(priority = 13, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void alerts() throws InterruptedException {
        alert = new Alert();
        alert.alerttab();
        alert.createButton();
//        alert.optalertview();
//        alert.optalertdel();
//        alert.optalertedit();

    }
}
