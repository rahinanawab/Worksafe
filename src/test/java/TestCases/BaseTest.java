package TestCases;

import org.testng.annotations.AfterSuite;
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
    protected Asset asset;
    protected Project project;
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
        asset = new Asset();
        project = new Project();
        dailyProject = new DailyProject();
        workorder = new Workorder();
        logout = new Logout();
    }
    @AfterSuite
    public void tearDownSuite() {
        BasePage.quitDriver();
    }
}
