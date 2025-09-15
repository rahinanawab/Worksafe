package TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObjects.*;

public class BaseTest {
    protected Login loginPage;
    protected SelectWorksite selectWorksite;
    protected Filter filter;
    protected SearchTeam searchTeam;
    protected AddTeam addTeam;
    protected RemoveTeam removeTeam;
    protected SearchUser searchUser;
    protected CompanyStorage companyStorage;
    protected CompanyLicense companyLicense;
    protected Payment payment;
    protected Poi poi;
    protected SearchPoi searchPoi;
    protected Alert alert;
    protected SearchAlert searchAlert;
    protected Asset asset;
    protected SearchAsset searchAsset;
    protected Project project;
    protected SearchProject searchProject;
    protected DailyProject dailyProject;
    protected Workorder workorder;
    protected Logout logout;

    @BeforeSuite
    public void setUp() {
        BasePage.initializeDriver();
        loginPage = new Login();
        selectWorksite = new SelectWorksite();
        filter = new Filter();
        searchTeam = new SearchTeam();
        addTeam = new AddTeam();
        removeTeam = new RemoveTeam();
        searchUser = new SearchUser();
        companyStorage = new CompanyStorage();
        companyLicense = new CompanyLicense();
        payment = new Payment();
        poi = new Poi();
        searchPoi = new SearchPoi();
        alert = new Alert();
        searchAlert = new SearchAlert();
        asset = new Asset();
        searchAsset = new SearchAsset();
        project = new Project();
        searchProject = new SearchProject();
        dailyProject = new DailyProject();
        workorder = new Workorder();
        logout = new Logout();
    }
//    @AfterSuite
//    public void tearDownSuite() {
//        BasePage.quitDriver();
//    }
}
