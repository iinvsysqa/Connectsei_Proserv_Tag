package com.Testcases;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ProservPages.Login_Page;
import com.ProservPages.Notification_page;
import com.ProservPages.Register_page;
import com.ProservPages.StoreLogPage;
import com.wrappers.MobileAppWrappers;

public class TC_01_Register extends MobileAppWrappers{

	Login_Page loginpage;
	Register_page registerpage;
	Notification_page notificationPage;
	StoreLogPage logpage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01_Register";
		testDescription = "Try to Register a new service person ";
	}
	
	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String Password =loadProp("PASSWORD");
//	String Mobilenumber =loadProp("MOBILENUMBER");
	
	
	@Test(priority = 0)
	public void removerepair() throws Exception {
		initAndriodDriver();
		loginpage= new Login_Page(driver);
		registerpage = new Register_page(driver);
		notificationPage= new Notification_page(driver);
		logpage= new StoreLogPage(driver);
		
		try {
			registerpage.WifiSwitch(loadProp("WIFINAME"), loadProp("WIFIPASSWORD"),loadProp("APP_PACKAGE"));
			//check for error toast 
			uninstall_reinstall();
			setLoadProp("MOBILENUMBER",9+randomnumbers(9));
			System.out.println(loadProp("MOBILENUMBER"));
			registerpage.clickRegisterLink();
			registerpage.clickRegisterButton();
			registerpage.checkFirstname_errormsg();
			registerpage.checkLastname_errormsg();
			registerpage.checkMobilenum_errormsg();
			registerpage.checkPassword_errormsg();
			
			//register with all valid details 
			registerpage.enterFirstName(username);
			registerpage.enterLastName(Lastname);
			registerpage.enterMobileNumber(loadProp("MOBILENUMBER"));
			registerpage.enterPassword(Password);
			registerpage.enterConfirmPassword(Password);
			registerpage.clickCheckbox();
			registerpage.clickRegisterButton();
			registerpage.OTPtitlecheck();
			registerpage.enterOTP();
			
//			//check ConfirmLocation page
			registerpage.verifyConfirmLocation();
			registerpage.clickMoredetails();
			
			registerpage.checkAdddetailedAddress();
			registerpage.saveHomeLocation();
			registerpage.Flatfield();
			registerpage.clickSaveBtn();
			registerpage.verifyAddressline_Toast();
			
			registerpage.verifyServiceAreatitle();
			registerpage.scrollSlider();
			registerpage.clickSaveBtn();
			registerpage.verifyRadiusToast();
			
			
			registerpage.verifySelfietitle();
			registerpage.clickTakePhotoBtn();
			registerpage.verifyCameratitle();
			registerpage.clickTakePhotoBtn();
			registerpage.verifyCameratitle();
			registerpage.clickSaveBtn();
			registerpage.verifyFaceRecognized_Toast();
			
			registerpage.verifyJobCategoryTitle();
			registerpage.clickACjob();
			registerpage.verifySelectexperienceTitle();
			registerpage.clickYearExperience();
			registerpage.enterMinimumServiceCharge();
			registerpage.clickSaveBtn();
			registerpage.verifyYearsofExp();
            
			
			registerpage.clickEditBtn();
			registerpage.clickRemoveBtn();
			registerpage.clickACjob();
			registerpage.verifySelectexperienceTitle();
			registerpage.clickYearExperience();
			registerpage.enterMinimumServiceCharge();
			registerpage.clickSaveBtn();
			registerpage.verifyYearsofExp();
			registerpage.clickSubmitBtn();
			//check Address page functonality -already added address -Add new adress 
			registerpage.checknotificationbutton();
			notificationPage.clickAddressarrow();
			notificationPage.verifyAddressTitle();
			registerpage.verifyAlreadyEditedHomeaddress();
			
			//Adding new office address
			registerpage.clickOffice_afterRegisterpage();
			registerpage.clickAddAddress_Officepage();
			registerpage.verifyConfirmLocation();
			registerpage.clickMoredetails();
			registerpage.saveOfficeLocation();
			registerpage.Flatfield();
			registerpage.clickSaveBtn();
			registerpage.verifyAddressline_Toast();
			
				
			
			registerpage.checknotificationbutton();
			notificationPage.clickAddressarrow();
			registerpage.clickOffice_afterRegisterpage();
			registerpage.verifyAlreadyEditedOfficeAddress();
//			registerpage.clickProfileIcon();
//			registerpage.DeleteAccount();
//			registerpage.popup_okBtn();
			
//			ConnectseiApp();
//			registerpage.Connectsei_entermobileno(Mobilenumber);
//			registerpage.Connectsei_enterPassword(Password);
//			registerpage.Connecsei_clickLogin();
////			registerpage.popup_okBtn,();
//			registerpage.checkHomepageAdvertisement();
//			registerpage.clickProfileIcon();
//			registerpage.Connecsei_deleteAccount();
//			registerpage.popup_okBtn();
			
			
		} catch (Exception e) {
			System.out.println(e);
			logpage.CollectLogOnFailure(testCaseName,testDescription);
		}
	
	}
}
