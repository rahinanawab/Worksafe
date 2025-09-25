package TestCases;

import org.testng.annotations.Test;
import pageObjects.Team;

public class TeamTest extends BaseTest {
    @Test(priority = 4, dependsOnMethods = "TestCases.LoginTest.testLogin")
        public void teams() throws InterruptedException {
            team = new Team();
            team.teamtab();
            team.searchteam();
            team.addmember();
            team.removemember();
        }
}