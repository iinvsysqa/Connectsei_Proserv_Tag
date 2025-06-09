package com.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ProservPages.Login_Page;
import com.ProservPages.Register_page;
import com.ProservPages.StoreLogPage;
import com.wrappers.MobileAppWrappers;

public class TC_02_Login extends MobileAppWrappers{

	Login_Page loginpage;
	Register_page registerpage;
	StoreLogPage logpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC02_Login";
		testDescription = "Try to login with already registered username";
	}
	
	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String Password =loadProp("PASSWORD");
	String Mobilenumber =loadProp("MOBILENUMBER");
	
	
	@Test(priority = 1)
	public void removerepair() throws Exception {
		initAndriodDriver();
		loginpage= new Login_Page(driver);
		registerpage = new Register_page(driver);
		logpage= new StoreLogPage(driver);
		
		try {
			registerpage.WifiSwitch(loadProp("WIFINAME"), loadProp("WIFIPASSWORD"),loadProp("APP_PACKAGE"));
			uninstall_reinstall();
			loginpage.enterMobileno(randomnumbers(10));
			loginpage.enterPassword("User"+"@#"+randomnumbers(3));
			loginpage.clickLogin();
			loginpage.checkMobilenoToast();
			
			loginpage.enterMobileno(Mobilenumber);
			loginpage.enterPassword(Password);
			loginpage.clickLogin();
			loginpage.checkOKbtuton();
			registerpage.checknotificationbutton();;
			
			
		
		}catch (Exception e) {
			System.out.println(e);
			logpage.CollectLogOnFailure(testCaseName,testDescription);
		}
	}
	
}
