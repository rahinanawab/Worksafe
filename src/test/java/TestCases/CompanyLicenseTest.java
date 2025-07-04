package TestCases;

import org.testng.annotations.Test;
import pageObjects.CompanyLicense;
import pageObjects.CompanyStorage;

public class CompanyLicenseTest extends BaseTest{
    @Test(priority = 8, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void companylicense() throws InterruptedException {
        companyLicense = new CompanyLicense();
        companyLicense.company();
        companyLicense.license();
    }
}
