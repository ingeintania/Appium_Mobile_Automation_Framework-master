package com.company.project.android.shopeepay;

import com.company.project.utilities.appium.AppiumDriverFactory;
import com.company.project.utilities.appium.AppiumUserSimulations;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ShopeePayTests {

    private Logger log = LogManager.getLogger();
    AppiumUserSimulations appium = null;
    AppiumDriver driver = null;
    AppiumDriverFactory driverFactory = null;
    ShopeePayScreen shopeePayScreen = null;
    private String uniqueString = "";

    @BeforeMethod(alwaysRun = true)
    @Parameters({"runOn", "appPackage", "appActivity"})
    public void invokeApp( 
        @Optional("AndroidEmulator") String runOn, 
        @Optional("com.shopeepay.id") String appPackage, 
        @Optional("com.shopee.app.ui.home.HomeActivity_") String appActivity) {
        System.out.println("=== runOn: " + runOn);
        System.out.println("=== appPackage: " + appPackage);
        System.out.println("=== appActivity: " + appActivity);
        log.info("Trying to create appium driver for -" + runOn);
        driverFactory = new AppiumDriverFactory();

        if (runOn.equalsIgnoreCase("AndroidEmulator")){
            driver = driverFactory.createAndroidDriverWithInstalledApp(appPackage, appActivity);
        } else if(runOn.equalsIgnoreCase("AndroidDevice")){
            driver = driverFactory.createAndroidDriverWithInstalledApp(appPackage, appActivity);
        } else {
            log.info("Incorrect runOn parameter provided" + runOn);
        }

        if (driver == null) {
            throw new RuntimeException("Driver is null! Appium session not created.");
        }

        log.info("--------------------------------------------------------------------------");
        log.info("Appium driver created for - " + runOn);
        log.info("Targeting app - " + appPackage);
        log.info("--------------------------------------------------------------------------");

        appium = new AppiumUserSimulations(driver);
        uniqueString = appium.generateUniqueString();
        shopeePayScreen = new ShopeePayScreen(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Tearing down driver");
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void validateRegisterPage(){
        shopeePayScreen.assertRegisterWithPhoneNumberButton();
        shopeePayScreen.clickRegisterWithPhoneNumberButton();
        shopeePayScreen.assertRegisterPageTitle();
        shopeePayScreen.assertRegisterPageSubtitle();
        shopeePayScreen.assertRegisterPagePhoneNumberEditText();
        shopeePayScreen.assertRegisterPageSudahPunyaAkunText();
        shopeePayScreen.assertRegisterPageFooter();
        shopeePayScreen.assertRegisterPageLanjutButton();
    }

    @Test(priority = 2) //Assert puzzle pop up not showing > wifi/internet not connected
    public void registerWithRegisteredPhoneNumber(){
        shopeePayScreen.enterPhoneNumber("085156313854");
        shopeePayScreen.clickLanjutButton();
        shopeePayScreen.assertPuzzlePopUp();
    }

    // @Test(priority = 2) //Assert with wrong text "No. HP salah ga sih" > incorrect version
    // public void registerWithWrongFormatPhoneNumber(){
    //     shopeePayScreen.enterPhoneNumber("0851563138541111111");
    //     shopeePayScreen.clickLanjutButton();
    //     shopeePayScreen.assertErrorPhoneNumberMessage();
    //     shopeePayScreen.assertErrorMessageText("No. HP salah ga sih");
    // }

}
