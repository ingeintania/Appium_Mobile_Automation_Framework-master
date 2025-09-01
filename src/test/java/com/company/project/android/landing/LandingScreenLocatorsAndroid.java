package com.company.project.android.landing;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LandingScreenLocatorsAndroid {
    public static final By LandingScreenTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"TheApp\")");

    //Navigate to
    public static final By echoBoxNavigationLinkFromLanding = AppiumBy.id("com.shopeepay.id:id/btn_signup_with_mobile_number");

}
