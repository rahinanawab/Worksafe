package TestCases;

import org.testng.annotations.Test;
import pageObjects.DailyProject;

public class DailyProjectTest extends BaseTest {
    @Test(priority = 19, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void dailyprojects() throws InterruptedException {
        dailyProject = new DailyProject();
        dailyProject.project();
        dailyProject.optprojectview();
        dailyProject.setDailyproject();
        dailyProject.createdailyButton();
        dailyProject.exdata();
        dailyProject.occurance();
        dailyProject.setScope();
        dailyProject.setUploadPhoto();
        dailyProject.setUploadDoc();
        dailyProject.setUploadSafetyDoc();
        dailyProject.setUploadWarrentyDoc();
        dailyProject.setAdddailyprojectbutton();
        dailyProject.setUploadSpacePaperwork();
        dailyProject.setUploadJsa();
        dailyProject.setAdddailyprojectbutton1();
//        dailyProject.optdailyprojectview();
//        dailyProject.optdailyprojectdel();
        dailyProject.optdailyprojectedit();
    }
}
