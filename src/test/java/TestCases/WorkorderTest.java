package TestCases;

import org.testng.annotations.Test;
import pageObjects.Workorder;

public class WorkorderTest extends BaseTest{
        @Test(priority = 11, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void workorders() throws InterruptedException {
            workorder = new Workorder();
            workorder.wo();
//            workorder.createWoButton();
//            workorder.optwoview();
    }
}
