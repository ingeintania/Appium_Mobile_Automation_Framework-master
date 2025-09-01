package com.company.project.android.shopeepay;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ShopeePayLocators {

    //Register
    public static final By registerWithPhoneNumberButton = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.shopeepay.id:id/btn_signup_with_mobile_number\"]");
    public static final By registerPageTitleLabel = AppiumBy.xpath("//android.widget.TextView[@text=\"Daftar dengan No. HP\"]");
    public static final By registerPageSubtitleLabel = AppiumBy.xpath("//android.widget.TextView[@text=\"Kode OTP akan dikirim ke nomor ini\"]");
    public static final By registerPageSudahPunyaAkunTextLabel = AppiumBy.id("com.shopeepay.id:id/tvSignupReminder");
    public static final By registerPageFooterLabel = AppiumBy.id("com.shopeepay.id:id/text");
    public static final By phoneNumberEditText = AppiumBy.className("android.widget.EditText");
    public static final By LanjutButton = AppiumBy.id("com.shopeepay.id:id/btnContinue");
    public static final By errorPhoneNumberMessageLabel = AppiumBy.id("com.shopeepay.id:id/textinput_helper_text");
    public static final By puzzle = AppiumBy.xpath("//android.widget.TextView[1]");
}

