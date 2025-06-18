package com.Connectsei_testcases_login_module;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import com.Connectsei_Pages.*;

import com.wrappers.MobileAppWrappers;
public class TC02_LoingPage extends MobileAppWrappers {

    LoginPage loginpage;
	MenuBar menuBar;
	RegisterPage registerpage;
	
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - Invalid & Valid Login";
		testDescription = "Login With Invalid & Valid Email & Password";
	}
	

	@Test

	public void Login_Page_UI_And_Functional_Check() throws InterruptedException, Exception, IOException {
		initAndriodDriver();
	   
		registerpage = new RegisterPage(driver);
		loginpage = new LoginPage(driver);
//	    loginpage.clickWhileUsing();
		menuBar = new MenuBar(driver);
	    
//TC01_Invalid Login		
		openapp(loadProp("CONNECTSEI_APP_PACKAGE"));
		loginpage.enterMobileNumber(9+randomnumbers(9));
		loginpage.enterPassword(loadProp("PASSWORD"));
		registerpage.clickEyeIconButton();
		loginpage.clickLoginButton();
	
////TC02_Valid Login
		loginpage.enterMobileNumber(loadProp("MOBILENUMBER"));
		loginpage.enterPassword(loadProp("PASSWORD"));
		loginpage.clickLoginButton();
		
////Without Internet Logout The App
		registerpage.clickProfileIcon();
		loginpage.turnOffWifi();
		Thread.sleep(2000);
		registerpage.clickLogoutButton();
        registerpage.verifyLogoutPopupTopic();
        registerpage.verifyLogoutPopupContent();
        registerpage.clickLogoutPopupCancelButton();
        registerpage.clickLogoutButton();
        registerpage.clickLogoutPopupOkButton();
        
		Thread.sleep(2000);
		loginpage.turnOnWifi();
		registerpage.clickLogoutButton();
        registerpage.verifyLogoutPopupTopic();
        registerpage.verifyLogoutPopupContent();
        registerpage.clickLogoutPopupCancelButton();
        registerpage.clickLogoutButton();
        registerpage.clickLogoutPopupOkButton();
		closeApp(loadProp("CONNECTSEI_APP_PACKAGE"));
		
	}
	
}	