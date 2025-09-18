package TestCases;

import org.testng.annotations.Test;
import pageObjects.AddTeam;

public class AddTeamTest extends BaseTest {
    @Test(priority = 4, dependsOnMethods = "TestCases.LoginTest.testLogin")
        public void addteam() throws InterruptedException {
            addTeam = new AddTeam();
            addTeam.teamtab();
            addTeam.addmember();
        }
}