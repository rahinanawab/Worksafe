package TestCases;

import org.testng.annotations.Test;
import pageObjects.CompanyLicense;

public class CompanyLicenseTest extends BaseTest {
    @Test(priority = 9, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void companylicense() throws InterruptedException {
        companyLicense = new CompanyLicense();
        companyLicense.company();
        companyLicense.license();
    }
}
