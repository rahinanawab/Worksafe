package TestCases;

import org.testng.annotations.Test;
import pageObjects.SearchUser;

public class SearchUserTest extends BaseTest {
            @Test(priority = 7, dependsOnMethods = "TestCases.LoginTest.testLogin")
        public void testSearchUser() throws InterruptedException {
                searchUser = new SearchUser();
                searchUser.users();
            searchUser.enterEmailsearch("peace@yopmail.com");
        }
}
