package TestCases;

import org.testng.annotations.Test;
import pageObjects.SearchAlert;

public class SearchAlertTest extends BaseTest {
    @Test(priority = 14, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void testSearchalert() throws InterruptedException {
        searchAlert = new SearchAlert();
        searchAlert.searchalert();
    }
}
