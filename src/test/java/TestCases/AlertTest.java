package TestCases;

import org.testng.annotations.Test;
import pageObjects.Alert;

public class AlertTest extends BaseTest {
    @Test(priority = 9, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void alerts() throws InterruptedException {
        alert = new Alert();
        alert.alerttab();
        alert.searchalert();
        alert.createButton();
//        alert.optalertview();
//        alert.optalertdel();
//        alert.optalertedit();

    }
}
