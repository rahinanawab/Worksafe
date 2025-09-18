package TestCases;

import org.testng.annotations.Test;
import pageObjects.Filter;

public class FilterTest extends BaseTest{
    @Test(priority = 3, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void assets() throws InterruptedException {
        filter = new Filter();
        filter.filtertab();
        filter.filterselection();
    }
}
