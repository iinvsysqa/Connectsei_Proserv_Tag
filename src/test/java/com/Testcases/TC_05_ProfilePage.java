package com.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ProservPages.Login_Page;
import com.ProservPages.Notification_page;
import com.ProservPages.Profile_page;
import com.ProservPages.Register_page;
import com.wrappers.MobileAppWrappers;

public class TC_05_ProfilePage extends MobileAppWrappers{

	Login_Page loginpage;
	Register_page registerpage;
	Notification_page notificationPage;
	Profile_page profilepage;
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01_Login";
		testDescription = "Try to login with username";
	}
	
	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String Password =loadProp("PASSWORD");
	String Mobilenumber =loadProp("MOBILENUMBER");
	String email =loadProp("EMAILID");
	String radius =loadProp("RADIUS");
	String address =loadProp("ADDRESS");
	
	@Test(priority = 0)
	public void removerepair() throws Exception {
		initAndriodDriver();
		loginpage= new Login_Page(driver);
		registerpage = new Register_page(driver);
		notificationPage= new Notification_page(driver);
		profilepage=new Profile_page(driver);
		
		try {
			
			uninstall_reinstall();
			loginpage.login();//comment this
			registerpage.clickProfileIcon();
			profilepage.verifyProfilepageName();
			profilepage.verifyProfilepageMobileNo();
			profilepage.clickonYourProfile();
			profilepage.clickProfile_Usernameediticon();
			profilepage.clearandmodifyFirstname(username);
			profilepage.clearandmodifyLastname(Lastname);
			registerpage.clickSaveBtn();
			profilepage.verifyusernameToast();
			profilepage.clickProfile_Emailidediticon();
			profilepage.clearEmailfield();
			profilepage.clickGenerateOTPbtn();
			profilepage.verifyOTPfielderrormsg();
			profilepage.enteremailID(email);
			profilepage.clickGenerateOTPbtn();
			profilepage.verifyOTPtitle();
			profilepage.enterOTP();
			profilepage.verifyProfileTitle();
			
			profilepage.clickProfile_mobilenoediticon();
//			profilepage.clickGenerateOTPbtn(),,;
//			profilepage.verifyOTPfielderrormsg(),,;
			profilepage.clearMobilenoField();
			profilepage.verifyMobilenoErrormsg();
			registerpage.enterRandomMobileNumber();
			profilepage.clickGenerateOTPbtn();
			profilepage.verifyOTPtitle();
			profilepage.enterOTP();
			profilepage.verifyProfileTitle();
			
			profilepage.clickProfile_Passwordediticon();
			registerpage.clickSaveBtn();
			registerpage.checkPassword_errormsg();
			profilepage.verifyConfirmpassword_Errmsg();
			registerpage.enterPassword(Password);
			registerpage.enterConfirmPassword(Password);
			registerpage.clickSaveBtn();
			profilepage.verifyProfileTitle();
			profilepage.navigateback();
			
			profilepage.clickonJobserviceList();
			registerpage.verifyYearsofExp();
			registerpage.clickSubmitBtn();
			profilepage.verifyMyProfileTitle();
			
			profilepage.clickonServiceProvidingAreaZone();
			profilepage.checkSavedRadius(radius);
			registerpage.clickSaveBtn();
			profilepage.verifyMyProfileTitle();
			
			
			profilepage.clickonSavedAddress();
			profilepage.checkEditedAddresspage(address);
			registerpage.verifyFlatfield();
			registerpage.clickSaveBtn();
			profilepage.verifyMyProfileTitle();
			
			profilepage.clickonKYC();
			profilepage.enterAadharno();
			profilepage.clickCheckbox();
			profilepage.clickVerifybtn();
			registerpage.OTPtitlecheck();
			profilepage.enterAadhaarOTP();
			profilepage.verifyKYCverificationtitle();
			
			registerpage.clickSubmitBtn();
			profilepage.checkPanErrormsg();
			profilepage.checkAccountnoErrormsg();
			profilepage.checkIFSCerrormsg();
			
			
			profilepage.enterPANnumber();
			profilepage.enterAccountnumber();
			profilepage.enterIFSCcode();
			profilepage.clickCheckbox();
			profilepage.clickVerifybtn();
			registerpage.clickSubmitBtn();
			profilepage.verifyMyProfileTitle();
			
			profilepage.clickonAwards_Certificate();
			profilepage.navigateback();
			profilepage.verifyMyProfileTitle();
			
			//logout 
			registerpage.LogoutProserv();
			registerpage.popup_okBtn();
			
			loginpage.login();
			registerpage.deleteAccount();
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
