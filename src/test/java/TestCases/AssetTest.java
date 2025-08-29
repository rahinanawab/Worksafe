package TestCases;

import org.testng.annotations.Test;
import pageObjects.Asset;

public class AssetTest extends BaseTest {
    @Test(priority = 15, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void assets() throws InterruptedException {
        asset = new Asset();
        asset.setassettab();
        asset.createButton();
        asset.setAssettype();
        asset.setDepartment();
        asset.setElevationlevel();
        asset.setWorkorder();
        asset.setModel();
        asset.setDate();
        asset.setNotificationdatetime();
//        asset.exdata();
        asset.noticationtimemint();
        asset.setUploadPhoto();
        asset.setUploadDoc();
        asset.setCirclemap();
        asset.setAddassetbutton();
//        asset.optassetview();
//        asset.optassetdel();
//        asset.optassetedit();
        }
}
