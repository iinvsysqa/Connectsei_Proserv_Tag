package com.Connectsei_testcases_login_module;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Connectsei_Pages.*;
import com.ProservPages.ConnectSei_Home_page;
import com.ProservPages.Login_Page;

import io.appium.java_client.android.AndroidDriver;
import com.wrappers.MobileAppWrappers;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;

public class TC03_ForgotPasswordPage extends MobileAppWrappers { 
	
	    Login_Page loginpage;
		MenuBar menuBar;
		RegisterPage registerpage;
		ForgotPasswordPage forgotPasswordpage;
		ConnectSei_Home_page connectseiHomepage;
		
		
		@BeforeClass
		public void startTestCase() {
			testCaseName = "TC01 - Invalid Mobile No and Valid Mobile No check";
			testDescription = "Invalid and Valid Mobile No In Forgot Password Page";
		}
		

		@Test
		public void Connectsei_Forgot_Password_Field_UI_And_Functional_Check() throws InterruptedException, Exception, IOException {
			initAndriodDriver();
		   
			registerpage = new RegisterPage(driver);
			loginpage = new Login_Page(driver);
//		    loginpage.clickWhileUsing();
			menuBar = new MenuBar(driver);
			forgotPasswordpage = new ForgotPasswordPage(driver);
			connectseiHomepage=new ConnectSei_Home_page(driver);
			
//Invalid Mobile No In Forgot Password Page
			openapp(loadProp("CONNECTSEI_APP_PACKAGE"));
			
			
			forgotPasswordpage.clickForgotPasswordButton();
			forgotPasswordpage.verifyForgotPasswordPageTitle();
			forgotPasswordpage.verifyForgotPasswordPageContent();
			forgotPasswordpage.enterMobileNo(9+randomnumbers(9));
			forgotPasswordpage.clickForgotSubmitButton();
			Thread.sleep(2000);
			
//Valid Mobile No In Forgot Password Page
			forgotPasswordpage.enterMobileNo(loadProp("MOBILENUMBER"));
			forgotPasswordpage.clickForgotSubmitButton();
			Thread.sleep(1000);
			registerpage.enterOTPBox1("2");
			registerpage.enterOTPBox2("3");
			registerpage.enterOTPBox3("6");
			registerpage.enterOTPBox4("8");
			registerpage.clickWhiteScreen();
			registerpage.clickConfirmOTPButton();
			Thread.sleep(180000);
			registerpage.clickResendButton();
			Thread.sleep(2000);
			registerpage.enterOTPBox1("1");
			registerpage.enterOTPBox2("2");
			registerpage.enterOTPBox3("3");
			registerpage.enterOTPBox4("4");
			registerpage.clickWhiteScreen();
			registerpage.clickConfirmOTPButton();
			
//Reset Password Page
			forgotPasswordpage.verifyResetPasswordPageTitle();
			forgotPasswordpage.verifyResetPasswordPageContent();
			forgotPasswordpage.enterPassword("Welcome@123");
			forgotPasswordpage.enterConfirmPassword("Welcome@123");
			forgotPasswordpage.clickEyeIcon();
			forgotPasswordpage.clickSubmitButton();
			
			closeApp(loadProp("CONNECTSEI_APP_PACKAGE"));
		}
}
