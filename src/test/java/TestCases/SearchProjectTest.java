package TestCases;

import org.testng.annotations.Test;
import pageObjects.SearchPoi;
import pageObjects.SearchProject;

public class SearchProjectTest extends BaseTest {
    @Test(priority = 13, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void testSearchproject() throws InterruptedException {
        searchProject = new SearchProject();
        searchProject.searchproject();
    }
}
