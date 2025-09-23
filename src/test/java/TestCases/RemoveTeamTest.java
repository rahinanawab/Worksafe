package TestCases;

import org.testng.annotations.Test;
import pageObjects.RemoveTeam;

public class RemoveTeamTest extends BaseTest {
            @Test(priority = 5, dependsOnMethods = "TestCases.LoginTest.testLogin")
        public void removeteam() throws InterruptedException {
                removeTeam = new RemoveTeam();
                removeTeam.removemember();
        }
}
