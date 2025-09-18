package TestCases;

import org.testng.annotations.Test;
import pageObjects.CompanyStorage;

public class CompanyStorageTest extends BaseTest {
            @Test(priority = 8, dependsOnMethods = "TestCases.LoginTest.testLogin")
        public void companystorage() throws InterruptedException {
                companyStorage = new CompanyStorage();
                companyStorage.company();
                companyStorage.storage();
            }
}
