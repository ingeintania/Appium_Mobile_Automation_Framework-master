package com.company.project.android.shopeepay;

import com.company.project.android.landing.LandingScreenAndroid;
import com.company.project.utilities.appium.AppiumUserSimulations;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class ShopeePayScreen extends LandingScreenAndroid {

    private final Logger log = LogManager.getLogger();
    private AppiumUserSimulations appium;
    private AppiumDriver driver;

    public ShopeePayScreen(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        appium = new AppiumUserSimulations(driver);
    }

    public void clickRegisterWithPhoneNumberButton(){
        appium.click(ShopeePayLocators.registerWithPhoneNumberButton);
    }

    public void enterPhoneNumber(String phoneNumber){
        appium.clear(ShopeePayLocators.phoneNumberEditText);
        appium.sendKeys(ShopeePayLocators.phoneNumberEditText, phoneNumber);
    }

    public void clickLanjutButton(){
        appium.click(ShopeePayLocators.LanjutButton);
    }

    public void assertErrorPhoneNumberMessage(){
        appium.isDisplayed(ShopeePayLocators.errorPhoneNumberMessageLabel);
    }

    public void assertRegisterPageTitle() {
        appium.isDisplayed(ShopeePayLocators.registerPageTitleLabel);
    }

    public void assertRegisterPageSubtitle() {
        appium.isDisplayed(ShopeePayLocators.registerPageSubtitleLabel);
    }

    public void assertRegisterPagePhoneNumberEditText() {
        appium.isDisplayed(ShopeePayLocators.phoneNumberEditText);
    }

    public void assertRegisterPageSudahPunyaAkunText() {
        appium.isDisplayed(ShopeePayLocators.registerPageSudahPunyaAkunTextLabel);
    }

    public void assertRegisterPageFooter() {
        appium.isDisplayed(ShopeePayLocators.registerPageFooterLabel);
    }

    public void assertRegisterPageLanjutButton() {
        appium.isDisplayed(ShopeePayLocators.LanjutButton);
    }

    public void assertErrorMessageText(String expected){
        String actual = appium.getText(ShopeePayLocators.errorPhoneNumberMessageLabel);
        Assert.assertEquals(actual, expected);
    }

    public void assertPuzzlePopUp(){
        appium.isDisplayed(ShopeePayLocators.puzzle, 10);
        String actual = appium.getText(ShopeePayLocators.puzzle);
        String expected = "Verifikasi";
        Assert.assertEquals(actual, expected);
    }

    public void assertRegisterWithPhoneNumberButton() {
        appium.isDisplayed(ShopeePayLocators.registerWithPhoneNumberButton);
    }
}
