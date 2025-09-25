package TestCases;

import org.testng.annotations.BeforeSuite;
import pageObjects.*;

public class BaseTest {
    protected Login loginPage;
    protected SelectWorksite selectWorksite;
    protected Filter filter;
    protected Team team;
    protected Users users;
    protected Company company;
    protected Payment payment;
    protected Poi poi;
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
        team = new Team();
        users = new Users();
        company = new Company();
        payment = new Payment();
        poi = new Poi();
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
