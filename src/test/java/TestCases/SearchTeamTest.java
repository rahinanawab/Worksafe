package TestCases;

import org.testng.annotations.Test;
import pageObjects.SearchTeam;

public class SearchTeamTest extends BaseTest{
        @Test(priority = 3, dependsOnMethods = "TestCases.LoginTest.testLogin")
        public void testSearch() throws InterruptedException {
            searchTeam = new SearchTeam();
            searchTeam.searchteam();
        }
}
