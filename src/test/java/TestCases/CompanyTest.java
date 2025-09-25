package TestCases;

import org.testng.annotations.Test;
import pageObjects.Company;

public class CompanyTest extends BaseTest {
            @Test(priority = 6, dependsOnMethods = "TestCases.LoginTest.testLogin")
        public void companystorage() throws InterruptedException {
                company = new Company();
                company.company();
                company.storage();
                company.license();
            }
}
