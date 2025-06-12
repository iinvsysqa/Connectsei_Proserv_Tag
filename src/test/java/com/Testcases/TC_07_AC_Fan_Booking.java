package com.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ProservPages.ConnectSei_Home_page;
import com.ProservPages.Home_page;
import com.ProservPages.Login_Page;
import com.ProservPages.Notification_page;
import com.ProservPages.Profile_page;
import com.ProservPages.Register_page;
import com.ProservPages.Serviceareazone_page;
import com.ProservPages.StoreLogPage;
import com.wrappers.MobileAppWrappers;

public class TC_07_AC_Fan_Booking extends MobileAppWrappers{

	Login_Page loginpage;
	Register_page registerpage;
	Notification_page notificationPage;
	Profile_page profilepage;
	ConnectSei_Home_page connectseiHomepage;
	Home_page homepage;
	Serviceareazone_page serviceareazone;
	StoreLogPage logpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_07_AC_Fan_Booking";
		testDescription = "check Booking flow of User and Service person for recieved order";
	}
	
	String connectsei_username =loadProp("USERNAME_CONNECTSEI_2");
	String connectsei_Lastname =loadProp("USERNAME_CONNECTSEI_2");
//	String mobilenumber=loadProp("MOBILENUMBER_CONNECTSEI_2");
	String Password =loadProp("PASSWORD");
//	String email =loadProp("EMAILID");
	
	
	
	
	@Test(priority = 6)
	public void TC_07_AC_Fan_Booking_Functionality() throws Exception {
		initAndriodDriver();
		loginpage= new Login_Page(driver);
		registerpage = new Register_page(driver);
		notificationPage= new Notification_page(driver);
		profilepage=new Profile_page(driver);
		connectseiHomepage=new ConnectSei_Home_page(driver);
		homepage = new Home_page(driver);
		serviceareazone = new Serviceareazone_page(driver);
		logpage= new StoreLogPage(driver);
		try {
	//change the service person job from AC-FAN and from user send AC service request and check service person recieving that job or not
			
			//login proserv change serviceperson job from AC to FAN and check ac job should not display 
			uninstall_reinstall();
			loginpage.login(loadProp("MOBILENUMBER"),loadProp("PASSWORD"));
			registerpage.clickProfileIcon();
			profilepage.clickonJobserviceList();
			
			//removing AC job and adding FAN job
			registerpage.clickEditBtn();
			registerpage.clickRemoveBtn();
			registerpage.clickonProductName(1, "Fan product");
			registerpage.verifySelectexperienceTitle();
			registerpage.clickYearExperience();
			registerpage.enterMinimumServiceCharge();
			registerpage.clickSaveBtn();
			registerpage.verifyYearsofExp();
			registerpage.clickSubmitBtn();
			
			//refreshing 
			homepage.clickHomeicon();
			serviceareazone.swipedown();
			homepage.checkOldLocationJob("AC", connectsei_username+connectsei_username);
			
			
			//from connectsei book fan 
			Connectsei_uninstall_reinstall();
			loginpage.login(loadProp("MOBILENUMBER_CONNECTSEI_2"),loadProp("PASSWORD"));
			connectseiHomepage.clickonProducttext(1, "FAN Product");
			connectseiHomepage.addDescription();
			registerpage.scrollToText("08 - 09 PM");
			connectseiHomepage.clickonDatebutton();
			connectseiHomepage.clickonSlotbutton();
			connectseiHomepage.clickNextbutton();
			connectseiHomepage.clickBooknow();
			Thread.sleep(3000);
			serviceareazone.tap();//not working 
			connectseiHomepage.Connectsei_SearchInput();
			
			//from proserv check for fan product job 
			initAndriodDriver();
			Thread.sleep(3000);
			serviceareazone.swipedown();
			homepage.checkOldLocationJob("AC", connectsei_username+connectsei_username);
			
			
		}catch (Exception e) {
			System.out.println(e);
			logpage.CollectLogOnFailure(testCaseName,testDescription);
		}
	}
}
