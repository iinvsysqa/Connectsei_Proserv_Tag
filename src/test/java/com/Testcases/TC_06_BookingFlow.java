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

public class TC_06_BookingFlow extends MobileAppWrappers{

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
		testCaseName = "TC_06_BookingFlow";
		testDescription = "check Booking flow of User and Service person for recieved order";
	}
	
	String connectsei_username =loadProp("USERNAME_CONNECTSEI_2");
	String connectsei_Lastname =loadProp("USERNAME_CONNECTSEI_2");
//	String mobilenumber=loadProp("MOBILENUMBER_CONNECTSEI_2");
	String Password =loadProp("PASSWORD");
//	String email =loadProp("EMAILID");
	
	
	
	
	@Test(priority = 5)
	public void TC_06_BookingFlow_Functionality() throws Exception {
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
			//installing connectsei to raising product issue  
			Connectsei_uninstall_reinstall();
			registerpage.registeraccount(connectsei_username, connectsei_Lastname, Password);
			connectseiHomepage.clickACproduct();
			connectseiHomepage.addDescription();
			registerpage.scrollToText("08 - 09 PM");
			connectseiHomepage.clickonDatebutton();
			connectseiHomepage.clickonSlotbutton();
			connectseiHomepage.clickNextbutton();
//			disableWiFi(); //9499812441 Samuel Samuel
			connectseiHomepage.clickBooknow();
//			notificationPage.verifyNointernetMsg();
			
//			enableWiFi();
//			registerpage.WifiSwitch(loadProp("WIFINAME"), loadProp("WIFIPASSWORD"),loadProp("CONNECTSEI_APP_PACKAGE"));
//			notificationPage.clickReloadicon();
//			connectseiHomepage.clickBooknow();
			
			Thread.sleep(3000);
			serviceareazone.tap();//not working 
			connectseiHomepage.Connectsei_SearchInput();
			closeApp(loadProp("CONNECTSEI_APP_PACKAGE"));
			
			//check proserv for recieved job for push notification 
			//check proserv hompage and for recieved job user name and product is same as customer sent or not
			uninstall_reinstall();
			loginpage.login(loadProp("MOBILENUMBER"),loadProp("PASSWORD"));
			registerpage.Relogin_deletedAcnt();
			//verifying KYC
			
			  registerpage.clickProfileIcon(); profilepage.clickonKYC();
			  profilepage.enterAadharno(); profilepage.clickCheckbox();
			  profilepage.clickVerifybtn(); registerpage.OTPtitlecheck();
			  profilepage.enterAadhaarOTP(); profilepage.verifyKYCverificationtitle();
			  
			  registerpage.clickSubmitBtn(); profilepage.checkPanErrormsg();
			  profilepage.checkAccountnoErrormsg(); profilepage.checkIFSCerrormsg();
			  
			  
			  profilepage.enterPANnumber(); profilepage.enterAccountnumber();
			  profilepage.enterIFSCcode(); registerpage.clickSubmitBtn();
			  profilepage.navigateback(); profilepage.verifyMyProfileTitle();
			  
			  homepage.clickHomeicon();
			 
			homepage.checkAvailablejobstitle();
			//change service person location and check that previous job location -jobs are showing or not
			homepage.checkUsersentjob("Ac",connectsei_username);
			 
			//changing another location
			notificationPage.clickAddressarrow();
			serviceareazone.clickLocationchnageButton();
			serviceareazone.enteranotherLocation();
			serviceareazone.swipeup();
			registerpage.clickMoredetails();
			registerpage.Flatfield();
			registerpage.clickSaveBtn();
			serviceareazone.swipedown();
			Thread.sleep(5000);
			homepage.checkOldLocationJob("Ac",connectsei_username);
			
			//if service person changed to current location check that previous locations job showing or not 
			//changing current  location
			notificationPage.clickAddressarrow();
			serviceareazone.clickLocationchnageButton();
			serviceareazone.useCurrentLocation();
			registerpage.clickMoredetails();
			registerpage.Flatfield();
			registerpage.clickSaveBtn();
			serviceareazone.swipedown();
			homepage.checkUsersentjob("Ac",connectsei_username);
			
			//make service person offline and again raise issue from cutomer ,make service person online and check for that job request 
			homepage.changeOffline();
			homepage.checkOfflineTogglestate();
			homepage.checkNojobPlaceholder();
			homepage.changeOnline();
			homepage.confirmAvailablejob("Ac",connectsei_username);
			
			//check interested job details
			homepage.clickMyordericon();
			homepage.clickInterestedText();
			homepage.checkforInterestedOrder("Ac",connectsei_username);
			closeApp(loadProp("APP_PACKAGE"));
			
			/*
			 * //navigate to connectsei and approve the service person
			 * openapp(loadProp("CONNECTSEI_APP_PACKAGE"));
			 * connectseiHomepage.clickMyOrderbutton();
			 * connectseiHomepage.navigatePendingpage();
			 * connectseiHomepage.checkforPendingOrderstatus("AC");
			 * connectseiHomepage.clickAvailableTechnicianButton();
			 * connectseiHomepage.checkservicepersonname_and_accept(loadProp("USERNAMEINAPP"
			 * )); connectseiHomepage.Connectsei_SearchInput();
			 * 
			 * //check for Accepted order in connectseiapp homepage.clickMyordericon();
			 * serviceareazone.swipedown();
			 * connectseiHomepage.checkforPendingOrderstatus("AC");
			 * closeApp(loadProp("CONNECTSEI_APP_PACKAGE"));
			 * 
			 * //check for proserv My order page Accepted order
			 * openapp(loadProp("APP_PACKAGE")); homepage.clickMyordericon();
			 * serviceareazone.swipedown();
			 * homepage.clickonJourneyStarted_Acceptedorder("Ac",connectsei_username );
			 */
			
			
			
			
			 //need to delete connectsei account after issue resolved by service person
			
//			registerpage.deleteAccount();//unable to delete account if service person or user has current job
			
		}catch (Exception e) {
			System.out.println(e);
			logpage.CollectLogOnFailure(testCaseName,testDescription);
		}
	}
			
}
