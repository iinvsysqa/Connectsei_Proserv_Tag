package com.Connectsei_testcases_login_module;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Connectsei_Pages.*;
import com.ProservPages.*;
import com.wrappers.MobileAppWrappers;

public class TC05_ProfilePage extends MobileAppWrappers {
	
	RegisterPage registerpage;
	LoginPage loginpage;
    MenuBar menuBar;
	ProfilePage profilepage;
	Profile_page profilePage;
	Register_page register_page;
	Login_Page login_page;
	
	
	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String Password =loadProp("PASSWORD");
	String Mobilenumber =loadProp("MOBILENUMBER");
	String email =loadProp("EMAILID");
	String radius =loadProp("RADIUSRANGE");
	String address =loadProp("HOMEADDRESS");
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01 - Profile Details Editable or Not And Edited Profile Details View Check ";
		testDescription = "Check Profile Details Editable or Not And Edited Profile Details View Check";
	}
	

	@Test

	public void Connectsei_Profile_Page_UI_And_Functional_Check() throws InterruptedException, Exception, IOException {
		initAndriodDriver();
		
		
		registerpage = new RegisterPage(driver);
		loginpage = new LoginPage(driver);
//	    loginpage.clickWhileUsing();
		menuBar = new MenuBar(driver);
		profilepage = new ProfilePage(driver);
		profilePage = new Profile_page(driver);
		register_page = new Register_page(driver);
		 login_page = new Login_Page(driver);
		 
//TC01 - Profile Details Editable or not
		openapp(loadProp("CONNECTSEI_APP_PACKAGE"));
		registerpage.clickProfileIcon();
		Thread.sleep(1000);
		profilepage.verifyMyProfilePageTitle();
		profilePage.verifyProfilepageName();
		profilePage.verifyConnectsei_ProfilepageMobileNo();
		profilepage.verifyYourProfilefieldTitle();
		profilepage.verifyYourProfilefieldDescription();
		profilepage.clickYourProfileButton();
		
		profilePage.ConnectseiclickProfile_Usernameediticon();
		profilePage.clearandmodifyFirstname(username);
		profilePage.clearandmodifyLastname(Lastname);
		register_page.clickSaveBtn();
//		profilePage.verifyusernameToast();
		profilePage.ConnectseiclickProfile_Emailidediticon();
		profilePage.clearEmailfield();
		profilePage.clickGenerateOTPbtn();
		profilePage.ConnectseiverifyOTPfielderrormsg();
		profilePage.enteremailID(email);
		profilePage.clickGenerateOTPbtn();
		profilePage.verifyOTPtitle();
		profilePage.enterOTP();
		profilePage.verifyProfileTitle();
		
		profilePage.ConnectseiclickProfile_mobilenoediticon();
//		profilePage.clickGenerateOTPbtn(),,;
//		profilePage.verifyOTPfielderrormsg(),,;
		profilePage.clearMobilenoField();
		profilePage.clickGenerateOTPbtn();
		profilePage.verifyMobilenoErrormsg();
		register_page.enterRandomMobileNumber();
		profilePage.clickGenerateOTPbtn();
		profilePage.verifyOTPtitle();
		profilePage.enterOTP();
		profilePage.verifyProfileTitle();
		
		profilePage.ConnectseiclickProfile_Passwordediticon();
		register_page.clickSaveBtn();
		register_page.checkPassword_errormsg();
		profilePage.verifyConfirmpassword_Errmsg();
		registerpage.enterPassword(Password);
		registerpage.enterConfirmPassword(Password);
		register_page.clickSaveBtn();
		profilePage.verifyProfileTitle();
		profilePage.navigateback();
		
		//addding address line
		profilePage.clickConnectseiAddressesbutton();
		profilepage.clickAddAddressesButton();
		register_page.verifyConfirmLocation();
		register_page.clickMoredetails();
		
		register_page.Flatfield();
		register_page.clickSaveBtn();
		register_page.verifyAddressline_Toast();
		
		
		register_page.checkforLogoutandclickback();
		register_page.popup_okBtn();
		
		login_page.login(loadProp("MOBILENUMBER"),loadProp("PASSWORD"));
		register_page.Connecsei_deleteAccount();
		closeApp(loadProp("CONNECTSEI_APP_PACKAGE"));
		
		
		
}
	}
