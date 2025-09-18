package TestCases;

import org.testng.annotations.Test;
import pageObjects.SearchAsset;

public class SearchAssetTest extends BaseTest {
    @Test(priority = 16, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void testSearchaasset() throws InterruptedException {
        searchAsset = new SearchAsset();
        searchAsset.searchasset();
    }
}
