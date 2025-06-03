package com.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ProservPages.ConnectSei_Home_page;
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
	ConnectSei_Home_page connectseiHomepage;
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_06_BookingFlow";
		testDescription = "check Booking flow of User and Service person for recieved order";
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
		connectseiHomepage=new ConnectSei_Home_page(driver);
		
		try {
			//installing connectsei to raising product issue  
			Connectsei_uninstall_reinstall();
			registerpage.registeraccount(username, Lastname, mobilenumber, Password);
			connectseiHomepage.clickACproduct();
			connectseiHomepage.addDescription();
			registerpage.scrollToText("08 - 09 PM");
			connectseiHomepage.clickonDatebutton();
			connectseiHomepage.clickonSlotbutton();
			connectseiHomepage.clickNextbutton();
			disableWiFi();
			connectseiHomepage.clickBooknow();
			notificationPage.verifyNointernetMsg();
			
			enableWiFi();
			registerpage.WifiSwitch(loadProp("WIFINAME"), loadProp("WIFIPASSWORD"));
			notificationPage.clickReloadicon();
			connectseiHomepage.clickBooknow();
			
			connectseiHomepage.clickPop_upOk();
			registerpage.checknotificationbutton();
			
			//check proserv for recieved job for push notification 
			//check proserv hompage and for recieved job user name and product is same as customer sent or not
			//make service person offline and again raise issue from cutomer ,make service person online and check for that job request 
			//change service person location and check that previous job location jobs are showing or not
			//
			 //need to delete connectsei account after issue resolved by service person
			
			registerpage.deleteAccount();
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
			
}
