package TestCases;

import org.testng.annotations.Test;
import pageObjects.Project;

public class ProjectTest extends BaseTest {
    @Test(priority = 17, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void projects() throws InterruptedException {
        project = new Project();
        project.project();
        project.createButton();
        project.dept();
        project.elevation();
        project.wo();
        project.projman();
        project.con();
//        project.exdata();
        project.notificationdatetime();
        project.noticationtimemint();
        project.setUploadPhoto();
        project.setUploadDoc();
        project.setUploadSafetyDoc();
        project.setUploadWarrentyDoc();
        project.setUploadTrainingDoc();
        project.setUploadPermitDoc();
        project.setCirclemap();
        project.setAddprojectbutton();
        project.setUploadSpacePaperwork();
        project.setUploadJsa();
        project.setAddprojectbutton1();
//        project.optprojectview();
//        project.optprojectdel();
        project.optprojectedit();
    }
}
