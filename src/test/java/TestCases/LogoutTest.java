package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Logout;

public class LogoutTest extends BaseTest {
        @Test(priority = 14, dependsOnMethods = "TestCases.LoginTest.testLogin")
        public void testLogout() throws InterruptedException {
            logout = new Logout();
            logout.logout();
            Assert.assertTrue(logout.isLogoutSuccessful(), "Logout Failed!");
            System.out.println("Logout Successful!");
        }
}
