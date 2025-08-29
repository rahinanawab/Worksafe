package TestCases;

import org.testng.annotations.Test;
import pageObjects.Workorder;

public class WorkorderTest extends BaseTest {
        @Test(priority = 20, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void workorders() throws InterruptedException {
            workorder = new Workorder();
            workorder.wo();
            workorder.createWoButton();
//            workorder.createBYme();
//            workorder.optwoview();
//            workorder.optwodel();
//            workorder.optwoedit();
//            workorder.assignedTome();
//            workorder.optwocomp();
    }
}
