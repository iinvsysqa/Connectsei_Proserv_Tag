package com.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ProservPages.Login_Page;
import com.ProservPages.Notification_page;
import com.ProservPages.Register_page;
import com.wrappers.MobileAppWrappers;

public class TC_04_HOMEPAGE extends MobileAppWrappers{

	Login_Page loginpage;
	Register_page registerpage;
	Notification_page notificationPage;
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01_Login";
		testDescription = "Try to login with username";
	}
	
	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String Password =loadProp("PASSWORD");
	String Mobilenumber =loadProp("MOBILENUMBER");
	
	
	@Test(priority = 3)
	public void removerepair() throws Exception {
		initAndriodDriver();
		loginpage= new Login_Page(driver);
		registerpage = new Register_page(driver);
		notificationPage= new Notification_page(driver);
		
		try {
			uninstall_reinstall();
			loginpage.login();
			notificationPage.clickNotificationIcon();
			notificationPage.verifyNotificationtitle();
			notificationPage.verifyNotificationPlaceholder();
			notificationPage.clickbackbutton();
			registerpage.checknotificationbutton();
			
			
			notificationPage.clickMyorderIcon();
			notificationPage.verifyMyOrderTitle();
			notificationPage.clickbackbutton();
			registerpage.checknotificationbutton();
			registerpage.disableWiFi();
			notificationPage.clickMyorderIcon();
			notificationPage.verifyNointernetMsg();
			
			registerpage.enableWiFi();
			registerpage.WifiSwitch(loadProp("WIFINAME"), loadProp("WIFIPASSWORD"));
			notificationPage.clickReloadicon();
			notificationPage.clickMyorderIcon();
			notificationPage.verifyMyOrderTitle();
			
//			notificationPage
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
