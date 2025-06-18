package com.Connectsei_testcases_login_module;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Connectsei_Pages.*;

import com.wrappers.MobileAppWrappers;

import io.appium.java_client.android.AndroidDriver;

public class TC01_RegisterPage extends MobileAppWrappers {

	RegisterPage registerpage;
    LoginPage loginpage;
	MenuBar menuBar;
	
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - Connectsei Invalid & Valid Register";
		testDescription = "Register With Invalid And Valid Mobile Number";
	}
	

	@Test

	public void Connectsei_Register_Page_UI_And_Functional_Check() throws InterruptedException, Exception, IOException {
		initAndriodDriver();
		
		
		registerpage = new RegisterPage(driver);
		loginpage = new LoginPage(driver);
//	    loginpage.clickWhileUsing();
		menuBar = new MenuBar(driver);
	   
	    
//TC01_Valid Register	
		Connectsei_uninstall_reinstall();
		setLoadProp("MOBILENUMBER",9+randomnumbers(9));
		
		registerpage.clickRegisterButton();
		
		Thread.sleep(3000);
		registerpage.clickRegister2Button();
		Thread.sleep(6000);
		registerpage.verifyFirstnameErrorToast();
		registerpage.verifyLastnameErrorToast();
		registerpage.verifyMobilenumberErrorToast();
		registerpage.verifyPasswordErrorToast();
		registerpage.verifyConfirmpasswordErrorToast();
		registerpage.enterFirstName(loadProp("USERNAME"));
		registerpage.enterLastName(loadProp("LASTNAME"));
		registerpage.enterMobileNumber(loadProp("MOBILENUMBER"));
		Thread.sleep(1000);
		registerpage.enterPassword(loadProp("PASSWORD"));
		registerpage.enterConfirmPassword(loadProp("PASSWORD"));
		registerpage.clickEyeIconButton();
		registerpage.clickPrivacyPolicyButton();
		Thread.sleep(1000);
		registerpage.clickAndScrollThePage();
		registerpage.clickPrivacyPolicyBackButton();
		Thread.sleep(1000);
		registerpage.clickCheckBoxTickButton();
		Thread.sleep(1000);
		registerpage.clickRegister2Button();
		Thread.sleep(1000);
		
//Enter Invalid OTP Check	
		//registerpage.verifyRegisteredSameMobileNo();
		registerpage.enterOTPBox1("3");
		registerpage.enterOTPBox2("4");
		registerpage.enterOTPBox3("5");
		registerpage.enterOTPBox4("6");
		registerpage.clickWhiteScreen();
		registerpage.clickConfirmOTPButton();
		Thread.sleep(5000);
		
//Again Invalid OTP Check		
		registerpage.enterOTPBox1("9");
		registerpage.enterOTPBox2("4");
		registerpage.enterOTPBox3("5");
		registerpage.enterOTPBox4("6");
		registerpage.clickWhiteScreen();
		registerpage.clickConfirmOTPButton();
		
//Enter a Valid OTP Check	
		Thread.sleep(180000);
		registerpage.clickResendButton();
		Thread.sleep(1000);
		registerpage.enterOTPBox1("1");
		registerpage.enterOTPBox2("2");
		registerpage.enterOTPBox3("3");
		registerpage.enterOTPBox4("4");
		registerpage.clickWhiteScreen();
		registerpage.clickConfirmOTPButton();
    	Thread.sleep(2000);
   	registerpage.clickWhileUsing();
   	registerpage.clickNotificationPermissionAllow();
	
//Try To Logout 
    	Thread.sleep(6000);
        registerpage.clickProfileIcon();
        registerpage.clickLogoutButton();
        registerpage.verifyLogoutPopupTopic();
        registerpage.verifyLogoutPopupContent();
        registerpage.clickLogoutPopupCancelButton();
        registerpage.clickLogoutButton();
        registerpage.clickLogoutPopupOkButton();
		Thread.sleep(2000);
//		
//Try Register With Already Registered Mobile Number
		registerpage.clickRegisterButton();
		registerpage.enterFirstName(loadProp("USERNAME"));
		registerpage.enterLastName(loadProp("LASTNAME"));
		registerpage.enterMobileNumber(loadProp("MOBILENUMBER"));
		registerpage.enterPassword(loadProp("PASSWORD"));
		registerpage.enterConfirmPassword(loadProp("PASSWORD"));
		registerpage.clickEyeIconButton();
		registerpage.clickPrivacyPolicyButton();
		registerpage.clickPrivacyPolicyBackButton();
		registerpage.clickCheckBoxTickButton();
		registerpage.clickRegister2Button();
		registerpage.verifyMobileNumberAlreadyRegisteredToast();
		closeApp(loadProp("CONNECTSEI_APP_PACKAGE"));
	}
	
}	