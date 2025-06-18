package com.Connectsei_testcases_login_module;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Connectsei_Pages.*;
import com.ProservPages.Login_Page;
import com.wrappers.MobileAppWrappers;
import io.appium.java_client.android.AndroidDriver;

public class TC04_HomePage extends MobileAppWrappers {

	RegisterPage registerpage;
    LoginPage loginpage;
	MenuBar menuBar;
	HomePage homepage;
	Login_Page login_page;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - Notification Page Navigation Check And Home Page Functionallity Check";
		testDescription = "Notification Page Navigation Check And Home Page Functionallity Check";
	}
	

	@Test

	public void Connectsei_Notification_And_Home_Page_UI_And_Functional_Check() throws InterruptedException, Exception, IOException {
		initAndriodDriver();
		
		
		registerpage = new RegisterPage(driver);
		loginpage = new LoginPage(driver);
//	    loginpage.clickWhileUsing();
		menuBar = new MenuBar(driver);
		homepage = new HomePage(driver);
		login_page = new Login_Page(driver);
		
//Notification Page Navigation Check
		openapp(loadProp("CONNECTSEI_APP_PACKAGE"));
		login_page.login(loadProp("MOBILENUMBER"),loadProp("PASSWORD"));
		homepage.clickNotificationIcon();
		homepage.verifyNotificationTitle();
		homepage.verifyNoNotificationYet();
		homepage.verifyNotificationPageContent();
		Thread.sleep(1000);
		homepage.clickAndScrollThePage();
		Thread.sleep(6000);
		homepage.clickNotificationPageBackButton();
		
//Home Page Functionallity Check
		homepage.clickSearchButton();
		Thread.sleep(2000);
		homepage.clickSearchButton();
		homepage.enterSearchData("7676787679");
		homepage.clickcancelButton();
		homepage.enterSearchData("AC");
		homepage.clickSearchPageWhiteScreen();
		driver.navigate().back();
		
//My Order Page Navigation Check
		homepage.clickMyOrderButton();
		homepage.clickMyOrderPageBackButton();
		loginpage.turnOffWifi();
		Thread.sleep(2000);
		homepage.clickMyOrderButton();
		homepage.clickTryAgainButton();
		Thread.sleep(2000);
		loginpage.turnOnWifi();
		Thread.sleep(2000);
		homepage.clickTryAgainButton();
		homepage.clickPendingButton();
		homepage.clickHistoryButton();
		homepage.clickAcceptedButton();
		Thread.sleep(2000);
		homepage.clickMyOrderPageBackButton();
		Thread.sleep(3000);
		
		closeApp(loadProp("CONNECTSEI_APP_PACKAGE"));
		
		
		
		
	}
}
	