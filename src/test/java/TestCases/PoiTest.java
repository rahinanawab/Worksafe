package TestCases;

import org.testng.annotations.Test;
import pageObjects.Poi;

public class PoiTest extends BaseTest {
    @Test(priority = 8, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void pois() throws InterruptedException {
        poi = new Poi();
        poi.poi();
        poi.searchpoi();
    poi.createButton();
//    poi.optpoiview();
//    poi.optpoidel();
//    poi.optpoiedit();
    }
}
