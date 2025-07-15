package TestCases;

import org.testng.annotations.Test;
import pageObjects.SearchPoi;

public class SearchPoiTest extends BaseTest{
            @Test(priority = 10, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void testSearchpoi() throws InterruptedException {
                searchPoi = new SearchPoi();
                searchPoi.searchpoi();
    }
}
