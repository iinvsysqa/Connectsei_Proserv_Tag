package com.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ProservPages.Login_Page;
import com.ProservPages.Notification_page;
import com.ProservPages.Profile_page;
import com.ProservPages.Register_page;
import com.wrappers.MobileAppWrappers;

public class TC_06_BookingFlow extends MobileAppWrappers{

	Login_Page loginpage;
	Register_page registerpage;
	Notification_page notificationPage;
	Profile_page profilepage;
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01_Login";
		testDescription = "Try to login with username";
	}
	
	String username =loadProp("USERNAME_CONNECTSEI_2");
	String Lastname =loadProp("USERNAME_CONNECTSEI_2");
	String mobilenumber=loadProp("MOBILENUMBER_CONNECTSEI_2");
	String Password =loadProp("PASSWORD");
//	String email =loadProp("EMAILID");
	
	
	
	
	@Test(priority = 4)
	public void removerepair() throws Exception {
		initAndriodDriver();
		loginpage= new Login_Page(driver);
		registerpage = new Register_page(driver);
		notificationPage= new Notification_page(driver);
		profilepage=new Profile_page(driver);
		
		try {
			
			Connectsei_uninstall_reinstall();
			registerpage.registeraccount(username, Lastname, mobilenumber, Password);
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
			
}
