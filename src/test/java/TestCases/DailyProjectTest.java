package TestCases;

import org.testng.annotations.Test;
import pageObjects.DailyProject;

public class DailyProjectTest extends BaseTest{
    @Test(priority = 18, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void dailyprojects() throws InterruptedException {
        dailyProject = new DailyProject();
        dailyProject.project();
        dailyProject.optprojectview();
        dailyProject.setDailyproject();
        dailyProject.createdailyButton();
        dailyProject.con();
    }
}
