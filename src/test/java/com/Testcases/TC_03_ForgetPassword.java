package com.Testcases;

import org.apache.tools.ant.types.resources.FileResourceIterator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ProservPages.Login_Page;
import com.ProservPages.Register_page;
import com.ProservPages.StoreLogPage;
import com.wrappers.MobileAppWrappers;

public class TC_03_ForgetPassword extends MobileAppWrappers{

	Login_Page loginpage;
	Register_page registerpage;
	StoreLogPage logpage;
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC03_ForgetPassword";
		testDescription = "Try to change the password of the already registered user";
	}
	
	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String Password =loadProp("PASSWORD");
	
	
	@Test(priority = 2)
	public void removerepair() throws Exception {
		initAndriodDriver();
		loginpage= new Login_Page(driver);
		registerpage = new Register_page(driver);
		logpage= new StoreLogPage(driver);
		
		try {
			uninstall_reinstall();
			loginpage.Clickforgetpasswordlink();
			registerpage.enterMobileNumber(loadProp("MOBILENUMBER"));
			loginpage.clickGetOTPbtn();
			registerpage.OTPtitlecheck();
			registerpage.enterIncorrectOTP();
			registerpage.clearOTP();
			registerpage.enterOTP();
			
			loginpage.verifyResetPasswordtitle();
			registerpage.enterPassword(Password);
			registerpage.enterConfirmPassword(Password);
			registerpage.clickSubmitBtn();
			
			//logout
			loginpage.enterMobileno(loadProp("MOBILENUMBER"));
			loginpage.enterPassword(Password);
			loginpage.clickLogin();
			loginpage.checkOKbtuton();
			registerpage.checknotificationbutton();;
			registerpage.clickProfileIcon();
			loginpage.turnOffWifi();
			loginpage.clickLogoutbtn();
			registerpage.popup_okBtn();
			loginpage.verifyMyProfiletitle();
			
			loginpage.turnOnWifi();
			registerpage.WifiSwitch(loadProp("WIFINAME"), loadProp("WIFIPASSWORD"),loadProp("APP_PACKAGE"));
			loginpage.clickLogoutbtn();
			registerpage.popup_okBtn();
			loginpage.verifyLogoutToast();
		
		}catch (Exception e) {
			System.out.println(e);
			logpage.CollectLogOnFailure(testCaseName,testDescription);
		}
		}
}
