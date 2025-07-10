package TestCases;

import org.testng.annotations.Test;
import pageObjects.Project;

public class ProjectTest extends BaseTest {
    @Test(priority = 12, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void projects() throws InterruptedException {
        project = new Project();
        project.project();
        project.createButton();
    }
}
