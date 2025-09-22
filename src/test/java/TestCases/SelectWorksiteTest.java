package TestCases;

import org.testng.annotations.Test;
import pageObjects.SelectWorksite;

public class SelectWorksiteTest extends BaseTest {
    @Test(priority = 2, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void testSelectWorksite() throws InterruptedException {
        selectWorksite = new SelectWorksite();
//        selectWorksite.startfreetrial();
        selectWorksite.selectWorksites();

    }
}
