package TestCases;

import org.testng.annotations.Test;
import pageObjects.Filter;
import pageObjects.Payment;

public class PaymentTest extends BaseTest{
    @Test(priority = 7, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void payments() throws InterruptedException {
        payment = new Payment();
        payment.payment();
    }
}
