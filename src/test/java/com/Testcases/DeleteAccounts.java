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

public class DeleteAccounts extends MobileAppWrappers{

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
		testCaseName = "TC_08_Delete Connectsei and Proserv Accounts";
		testDescription = "Deleting Connectsei and Proserv Accounts";
	}
	
	String connectsei_username =loadProp("USERNAME_CONNECTSEI_2");
	String connectsei_Lastname =loadProp("USERNAME_CONNECTSEI_2");
//	String mobilenumber=loadProp("MOBILENUMBER_CONNECTSEI_2");
	String Password =loadProp("PASSWORD");
//	String email =loadProp("EMAILID");
	
	
	
	
	@Test(priority = 6)
	public void TC_07_Delete_Connectsei_and_Proserv_Accounts() throws Exception {
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
			openapp(loadProp("CONNECTSEI_APP_PACKAGE"));
			Thread.sleep(3000);
			registerpage.clickProfileIcon();
			registerpage.Connecsei_deleteAccount();
			registerpage.popup_okBtn();
			closeApp(loadProp("CONNECTSEI_APP_PACKAGE"));
			
			openapp(loadProp("APP_PACKAGE"));
			Thread.sleep(3000);
			registerpage.clickProfileIcon();
			registerpage.DeleteAccount();
			registerpage.popup_okBtn();
			
			ConnectseiApp();
			Thread.sleep(3000);
			registerpage.Connectsei_entermobileno(loadProp("MOBILENUMBER"));
			registerpage.Connectsei_enterPassword(Password);
			registerpage.Connecsei_clickLogin();
			registerpage.popup_okBtn();
			connectseiHomepage.Connectsei_SearchInput();
			registerpage.clickProfileIcon();
			registerpage.Connecsei_deleteAccount();
			registerpage.popup_okBtn();
			closeApp(loadProp("APP_PACKAGE"));
			
		}catch (Exception e) {
			System.out.println(e);
			logpage.CollectLogOnFailure(testCaseName,testDescription);
		}
	}
}
