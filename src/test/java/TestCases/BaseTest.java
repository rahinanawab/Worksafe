package TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObjects.*;

public class BaseTest {
    protected Login loginPage;
    protected SelectWorksite selectWorksite;
    protected SearchTeam searchTeam;
    protected AddTeam addTeam;
    protected RemoveTeam removeTeam;
    protected SearchUser searchUser;
    protected CompanyStorage companyStorage;
    protected CompanyLicense companyLicense;
    protected SearchPoi searchPoi;
    protected Poi poi;
    protected Workorder workorder;
    protected Project project;
    protected SearchProject searchProject;
    protected Alert alert;
    protected SearchAlert searchAlert;
    protected Logout logout;

    @BeforeSuite
    public void setUp() {
        BasePage.initializeDriver();
        loginPage = new Login();
        selectWorksite = new SelectWorksite();
        searchTeam = new SearchTeam();
        addTeam = new AddTeam();
        removeTeam = new RemoveTeam();
        searchUser = new SearchUser();
        companyStorage = new CompanyStorage();
        companyLicense = new CompanyLicense();
        searchPoi = new SearchPoi();
        poi = new Poi();
        workorder = new Workorder();
        project = new Project();
        searchProject = new SearchProject();
        alert = new Alert();
        searchAlert = new SearchAlert();
        logout = new Logout();
    }
//    @AfterSuite
//    public void tearDownSuite() {
//        BasePage.quitDriver();
//    }
}
