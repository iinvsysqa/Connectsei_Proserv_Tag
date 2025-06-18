package com.Connectsei_Pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import com.wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers {


	private AndroidDriver driver;

	// Locate all elements on the page
	//@FindBy(xpath = "//android.widget.TextView[@text=\"Login\"]")
	//private WebElement loginButton;
                        
	@FindBy(xpath = "//*[@resource-id='mobile_numberInput']")
	private WebElement mobilenumberField;
	
	@FindBy(xpath = "//*[@resource-id='passwordInput']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//*[@resource-id='EyeOpenSVG']")
	private WebElement eyeIcon;
	
	@FindBy(xpath = "//*[@resource-id='LoginButton']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
	private WebElement locationWhileUsingTheAppButton;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement notificationPermission;
	                  
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	private WebElement appInfoPageBackButton;
	
	@FindBy(xpath = "//android.widget.Toast[@text=\"User not found\"]")
	private WebElement userNotFoundToast;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Forgot Password ?\"]")
	private WebElement forgotPasswordButton;
	
	@FindBy(xpath = "//android.widget.EditText[@text=\"Email Id *\"]")
	private WebElement forgotEmailField;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")
	private WebElement forgotSubmitButton;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
	private WebElement forgotPageBackButton;
	
//	@FindBy(xpath = "//android.widget.Toast[@text=\"Invalid Email ld\"]")
//	private WebElement invalidEmailId;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"otp_input_0\"]")
	private WebElement otpBox1;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"otp_input_1\"]")
	private WebElement otpBox2;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"otp_input_2\"]")
	private WebElement otpBox3;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"otp_input_3\"]")
	private WebElement otpBox4;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"otp_input_4\"]")
	private WebElement otpBox5;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Resend?\"]")
	private WebElement resendButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")
	private WebElement otpPageSubmitButton;
	
//	@FindBy(xpath = "")
//	private WebElement ;
	
//	@FindBy(xpath = "")
//	private WebElement ;
	

	// Constructor to initialize the driver and instantiate elements using
	
	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver, 30);
	}

	// Methods to be used as part of loginpage.
	
	public void clickLoginButton() {
		clickbyXpath(loginButton, " Click the Login Button ");
	}

	
	public void enterMobileNumber(String MobileNumber) {
		entervaluebyXpath(mobilenumberField, "Enter The  Mobile Number" , MobileNumber);
		
	}
	
	public void enterPassword(String Password) {
		entervaluebyXpath(passwordField, "Enter The Password" , Password);
		
	}	
	
	//public void clickSubmitButton() {
	//clickbyXpath(submitButton, "Click The Submit Button");
		
//	}	
	
	public void clickWhileUsing() {
		clickbyXpath(locationWhileUsingTheAppButton, "In Location Pop-up Click The While Using The App Option");
		
	}
	
    public void clickNotificationPermission() {
    	expWait(notificationPermission);
		clickbyXpath(notificationPermission, "Click the Go TO Settings Button In Notification Permission Pop-up ");	

	}	
    
    public void clickAppInfoPageBackButton() {
		clickbyXpath(appInfoPageBackButton, "Click the App Info Page Back Button");
		
    }	
	public void checkUserNameNotFoundToast(String content) {
		verifyTextContainsByXpath(userNotFoundToast, content, " The Toast ");
		
	}
	public void clickForgotPasswordButton() {
		clickbyXpath(forgotPasswordButton, " Click the Forgot Password Button ");
		
	}	
	public void enterForgotEmailId(String Email) {
		entervaluebyXpath(forgotEmailField, "Enter The Email ID" , Email);
		
	}	
	public void clickForgotSubmitButton() {
		clickbyXpath(forgotSubmitButton, "Click the Forgot Password Page Submit Button");
		
	}	
	public void clickForgotPageBackButton() {
		clickbyXpath(forgotPageBackButton, "Click the Forgot Password Page Back Button");
		
	}	
//	public void checkInvalidEmailIdToast(String content) {
//		verifyTextContainsByXpath(invalidEmailId, content, " The Invalid Email Toast ");
	
    
	public void enterOTPBox1(String Number) {
		entervaluebyXpath(otpBox1, "Enter The OTP 1" ,Number );
		
	}	
	public void enterOTPBox2(String Number) {
		entervaluebyXpath(otpBox2, "Enter The OTP 2" ,Number );
	
	}
	public void enterOTPBox3(String Number) {
		entervaluebyXpath(otpBox3, "Enter The OTP 3" ,Number );
		
	}
	public void enterOTPBox4(String Number) {
		entervaluebyXpath(otpBox4, "Enter The OTP 4" ,Number );
		
	}
	public void enterOTPBox5(String Number) {
		entervaluebyXpath(otpBox5, "Enter The OTP 5" ,Number );
		
	}
	public void clickOtpSubmitButton() {
		clickbyXpath(otpPageSubmitButton, "Click the OTP Page Submit Button");
		
	}	
	public void clickResendButton() {
		clickbyXpath(resendButton, "Click the OTP Page Resend Button");
		
	}	
	public void turnOffWifi() {

		try {

		Runtime.getRuntime().exec("adb shell svc wifi disable");

		} catch (IOException e) {

		e.printStackTrace();

		}

		}
	public void turnOnWifi() throws Exception {

		try {
			Runtime.getRuntime().exec("adb shell svc wifi enable");
			
			Thread.sleep(3000);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}

