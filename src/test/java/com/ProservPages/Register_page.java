package com.ProservPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.Reporter;
import com.wrappers.GenericWrappers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;

public class Register_page extends GenericWrappers{

	public AndroidDriver driver;
//	String username =loadProp("USERNAME");
//	String Lastname =loadProp("LASTNAME");
//	String email =loadProp("EMAILID");
	public String Location;
//	String Password =loadProp("PASSWORD");
//	String Mobilenumber =loadProp("MOBILENUMBER");
	// Locate all elements on the page

	@FindBy(xpath = "//*[@resource-id='sign_up']")
	private WebElement Registerlink;
	@FindBy(xpath = "//*[@resource-id='RegisterTitle']")
	private WebElement Registertitle;
	
	@FindBy(xpath = "//*[@resource-id='first_nameInput']")
	private WebElement Firstnamefield;
	@FindBy(xpath = "//*[@resource-id='last_nameInput']")
	private WebElement Lastnamefield;
	@FindBy(xpath = "//*[@resource-id='mobile_numberInput']")
	private WebElement Mobilenumberfield;
	@FindBy(xpath = "//*[@resource-id='passwordInput']")
	private WebElement Passwordfield;
	@FindBy(xpath = "//*[@resource-id='confirmPasswordInput']")
	private WebElement confirmPasswordfield;
	@FindBy(xpath = "//*[@resource-id='terms_and_condition_link']")
	private WebElement terms_and_condition_link;
	@FindBy(xpath = "//*[@resource-id='CheckBoxfalse']")
	private WebElement Registercheckbox;
	@FindBy(xpath = "//*[@resource-id='RegisterText']")
	private WebElement Registerbutton;
	@FindBy(xpath = "//*[@resource-id='Enter OTPTitle']")
	private WebElement EnterOTPtitle;
	@FindBy(xpath = "//*[@resource-id='otp_input_0']")
	private WebElement OTP1;
	@FindBy(xpath = "//*[@resource-id='otp_input_1']")
	private WebElement OTP2;
	@FindBy(xpath = "//*[@resource-id='otp_input_2']")
	private WebElement OTP3;
	@FindBy(xpath = "//*[@resource-id='otp_input_3']")
	private WebElement OTP4;
	@FindBy(xpath = "//*[@resource-id='resendtext']")
	private WebElement resendtext;
	@FindBy(xpath = "//*[@resource-id='Confirm OTPText']")
	private WebElement Confirm_OTPText;
	@FindBy(xpath = "//*[@resource-id='first_nameError']")
	private WebElement first_nameErrorText;
	@FindBy(xpath = "//*[@resource-id='last_nameError']")
	private WebElement last_nameErrorText;
	@FindBy(xpath = "//*[@resource-id='mobile_numberError']")
	private WebElement mobile_numberErrorText;
	@FindBy(xpath = "//*[@resource-id='passwordError']")
	private WebElement passwordErrorText;
	@FindBy(xpath = "//*[@resource-id='Confirm  LocationTitle']")
	private WebElement ConfirmLocationtitle;
	@FindBy(xpath = "//*[@resource-id='useCurrentLocationButton']")
	private WebElement useCurrentLocationButton;	
	@FindBy(xpath = "//*[@resource-id='more_details_text']")
	private WebElement more_details_btn;
	@FindBy(xpath = "//*[@resource-id='Add detailed addressTitle']")
	private WebElement Add_detailed_addressTitle;
	@FindBy(xpath = "//*[@resource-id='Home']")
	private WebElement Homeicon;
	@FindBy(xpath = "//*[@resource-id='Office']")
	private WebElement Officeicon;
	@FindBy(xpath = "//*[@resource-id='Change_button']")
	private WebElement Change_button;
	@FindBy(xpath = "//*[@resource-id='flat_noInput']")
	private WebElement flat_noInput_field;
	@FindBy(xpath = "//*[@resource-id='near_land_markInput']")
	private WebElement near_land_markInput_field;
	@FindBy(xpath = "//*[@resource-id='SaveButton']")
	private WebElement SaveButton;
	@FindBy(xpath = "//*[@resource-id='Service area zoneTitle']")
	private WebElement Servicearea_zoneTitle;
	@FindBy(xpath = "//*[@resource-id='radius_Slider']")
	private WebElement radius_Slider;
	@FindBy(xpath = "//*[@resource-id='radius_value']")
	private WebElement radius_value;
	@FindBy(xpath = "//*[@resource-id='SaveText']")
	private WebElement SaveText;
	@FindBy(xpath = "//*[@resource-id='Verify your identity with a selfieTitle']")
	private WebElement SelfieTitle;
	@FindBy(xpath = "//*[@resource-id='Take PhotoButton']")
	private WebElement Take_PhotoButton;
	@FindBy(xpath = "//*[@resource-id='Take PhotoText']")
	private WebElement Take_PhotoText;
	@FindBy(xpath = "//*[@resource-id='CameraTitle']")
	private WebElement CameraTitle;
	@FindBy(xpath = "//*[@resource-id='Re-takeText']")
	private WebElement Re_takeText;
	@FindBy(xpath = "//*[@resource-id='Select job categoryTitle']")
	private WebElement Select_job_categoryTitle;
	@FindBy(xpath = "//*[@resource-id='product_name_Button_0']")
	private WebElement product_name_Button_0;
	@FindBy(xpath = "//*[@resource-id='cancel_prompt']")
	private WebElement cancel_btn;
	@FindBy(xpath = "//*[@resource-id='Select_Year_experience_info']")
	private WebElement ExperienceInfoTitle;
	@FindBy(xpath = "//*[@resource-id='0 - 1 yearText']")
	private WebElement yearsExperience;
	@FindBy(xpath = "//*[@resource-id='minimum_text_input']")
	private WebElement ServicechargeField;
	@FindBy(xpath = "//*[@resource-id='minimum_text_input_error']")
	private WebElement ServicechargeField_errmsg;
	@FindBy(xpath = "//*[@resource-id='years_of_experience_0']")
	private WebElement years_of_experience;
	@FindBy(xpath = "//*[@resource-id='Edit_Button']")
	private WebElement Jobcategory_Edit_Button;
	@FindBy(xpath = "//*[@resource-id='AdvertisementSVG']")
	private WebElement Advertisement;
	@FindBy(xpath = "//android.widget.TextView[@text=\"Profile\"]")
	private WebElement ProfileIcon;
	@FindBy(xpath = "//*[@resource-id='LogoutText']")
	private WebElement LogoutBtn;
	@FindBy(xpath = "//*[@resource-id='AccountDeleteButton']")
	private WebElement AccountDeleteButton;
	@FindBy(xpath = "//*[@resource-id='DeleteAccountButton']")
	private WebElement ConnectseiAccountDeleteButton;
	@FindBy(xpath = "//android.widget.Button[@text=\"OK\"]")
	private WebElement PopupOkbtn;
	@FindBy(xpath = "//android.widget.Button[@text=\"CANCEL\"]")
	private WebElement PopupCancelbtn;
	@FindBy(xpath = "//*[@resource-id='remove_text']")
	private WebElement removeBtn;
	@FindBy(xpath = "//*[@resource-id='SubmitText']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//*[@resource-id='mobile_numberInput']")
	private WebElement Connectsei_mobilenofield;
	@FindBy(xpath = "//*[@resource-id='passwordInput']")
	private WebElement Connectsei_Passwordfield;
	@FindBy(xpath = "//*[@resource-id='LoginButton']")
	private WebElement Connectsei_Loginfield;
	@FindBy(xpath = "//*[@resource-id='DeleteAccountText']")
	private WebElement Connectsei_DeleteAccount;
	
	@FindBy(xpath = "//android.widget.Toast[@text=\"You have 3 remaining attempt(s)\"]")
	private WebElement OTPremainingAttemptToast;
	@FindBy(xpath = "//android.widget.Toast[@text=\"Account deleted successfully\"]")
	private WebElement AccountDeletedToast;
	
	@FindBy(xpath = "//*[@resource-id='NewAddress']")
	private WebElement ConfirmLocation_Addresstext;
	@FindBy(xpath = "//*[@resource-id='address']")
	private WebElement Connectsei_Addresstext;
	@FindBy(xpath = "//*[@resource-id='FirstNameText']")
	private WebElement EditAddress_Homebtn_afterregister;
	@FindBy(xpath = "//*[@resource-id='SecondNameText']")
	private WebElement EditAddress_Officebtn_afterregister;
	@FindBy(xpath = "//*[@resource-id='EditedAddress']") 
	private WebElement Home_address;
	@FindBy(xpath = "//*[@resource-id='AddAddressText']") 
	private WebElement EditAddress_AddAddressText_afterregister;
	@FindBy(xpath = "//*[@resource-id='Status_text']") 
	private WebElement HomepageStatustext;
	@FindBy(xpath = "//*[@resource-id='DownArrowSVG']")
	private WebElement AddressDownArrow;
	@FindBy(xpath = "//*[@resource-id='Edit AddressTitle']")
	private WebElement EditAddressTitle;
	@FindBy(xpath = "//*[@resource-id='AddressData0']")
	private WebElement ConnectseiAddressData;
	
	
	private WebElement Productname(int no) {
		return driver.findElement(By.xpath("//*[@resource-id='product_name_"+no+"']"));
		
	}
	
	
//	@FindBy(xpath = "//*[@resource-id='Confirm OTPText']")
//	private WebElement Confirm_OTPText;
	
	
	//android.widget.Button[@resource-id="com.android.permissioncontroller:id/permission_allow_foreground_only_button"]
	
	/*
	 * First Name* Last Name* +91 Mobile Number* Password* Confirm Password
	 **/
//	radius updated successfully
//	Address line added successfully
	
	public Register_page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
//		this.wait=new WebDriverWait(driver, 1);

	}
	
	public void clickRegisterLink() {
		clickbyXpath(Registerlink, "Home page RegisterLInk");
	}
	public void verifyRegisterpage() {
		verifyTextContainsByXpath(Registertitle, "Register","Register page title");
	}
	public void enterFirstName(String username) {
		entervaluebyXpath(Firstnamefield,"FirstnameField", username);
	}
	public void enterLastName(String lastname) {
		entervaluebyXpath(Lastnamefield,"LastnameField",lastname);
		
	}
	public void enterMobileNumber(String mobile) {
		isElementDisplayedCheck(Mobilenumberfield);
		entervaluebyXpath(Mobilenumberfield, "MobilenumberField", mobile);
	}
	public void enterRandomMobileNumber() {
		
		entervaluebyXpath(Mobilenumberfield, "MobilenumberField", setLoadProp("MOBILENUMBER",9+randomnumbers(9)));
	}
	public void enterPassword(String password) {
		entervaluebyXpath(Passwordfield, "Password field ",password );
	}
	public void enterConfirmPassword(String password) {
		entervaluebyXpath(confirmPasswordfield, "Confirm Password field",password );
	}
	public void clickCheckbox() {
		clickbyXpath(Registercheckbox, "Register checkbox");
	}
	public void clickRegisterButton() {
		clickbyXpath(Registerbutton, "Register button");
	}
	public void OTPtitlecheck() {
		verifyTextContainsByXpath(EnterOTPtitle, "Enter OTP", "OTP page");
	}
	public void enterOTP() {

		entervaluebyXpath(OTP1,  "OTP","1");
		entervaluebyXpath(OTP2 ,"OTP","2");
		entervaluebyXpath(OTP3, "OTP" ,"3");
		entervaluebyXpath(OTP4, "OTP", "4");
		
		hidekeyboard();
		
		clickbyXpath(Confirm_OTPText, "Confirm OTP");
	}
	public void clearOTP() {
		
		OTP1.clear();
		OTP2.clear() ;
		OTP3.clear();
		OTP4.clear();
		}
	public void enterIncorrectOTP() {

		entervaluebyXpath(OTP1,  "OTP","1");
		entervaluebyXpath(OTP2 ,"OTP","2");
		entervaluebyXpath(OTP3, "OTP" ,"3");
		entervaluebyXpath(OTP4, "OTP", "0");
		
		hidekeyboard();
		
		clickbyXpath(Confirm_OTPText, "Confirm OTP");
//		verifyTextContainsByXpath(OTPremainingAttemptToast,"You have 3 remaining attempt(s)" ,"Incorrect OTP Toast" );
	}
	public void checkFirstname_errormsg() {
		verifyTextContainsByXpath(first_nameErrorText, "First name is required","First name error text");
	}
	public void checkLastname_errormsg() {
		verifyTextContainsByXpath(last_nameErrorText, "Last name is required","First name error text");
		
	}
	public void checkMobilenum_errormsg() {
		verifyTextContainsByXpath(mobile_numberErrorText, "Mobile number is required","First name error text");
		
	}
	public void checkPassword_errormsg() {
		verifyTextContainsByXpath(passwordErrorText, "Password is required","First name error text");
		
	}
	public void verifyRadiusToast() {
		verifyDynamicContentByXpath("//android.widget.Toast[@text=\"radius updated successfully\"]","radius updated successfully" , "Radius updated Toast");
	}
	public void verifyConfirmLocation() {
		verifyTextContainsByXpath(ConfirmLocationtitle, "Confirm  Location", "Confirm Location Title");
	}
	public void clickMoredetails() {
		isElementDisplayedCheck(more_details_btn);
		clickbyXpath(more_details_btn, "More Details button");
	}
	public void checkAdddetailedAddress() {
		verifyTextContainsByXpath(Add_detailed_addressTitle, "Add detailed address", "Add detailed Address ");
	}
	
	
	public void Flatfield() {
		entervaluebyXpath(flat_noInput_field, "Flat no field","10" );
	}
	public void verifyFlatfield() {
		verifyTextContainsByXpath(flat_noInput_field, "10","Flat no field");
	}
	public void verifyAddressline_Toast() {
		verifyDynamicContentByXpath("//android.widget.Toast[@text=\"Address line added successfully\"]","Address line added successfully" , "Radius updated Toast");
	}
	public void clickSaveBtn() {
		clickbyXpath(SaveButton, "Save button");
	}
	public void verifyServiceAreatitle() {
		verifyTextContainsByXpath(Servicearea_zoneTitle, "Service area zone", "Service Area Zone");
		
	}
	public void scrollSlider() throws Exception {
		
	    
	    String oldtext = radius_value.getText();
		Actions move = new Actions(driver);
		    move.moveToElement(radius_Slider).clickAndHold().moveByOffset(0,250).release().perform();
		    Thread.sleep(3500);
//		    Action action = (Action) move.dragAndDropBy(radius_Slider, 30, 0).build();
//		    ((Actions) action).perform();
		    
		    String newtext = radius_value.getText();
		    
		    setLoadProp("RADIUSRANGE", newtext);
		    if (oldtext!=newtext) {
		    	Reporter.reportStep("Radius Slider is working","PASS");
			}else {
				Reporter.reportStep("Radius Slider is not working","PASS");
				
			}
	}
	
	public void verifySelfietitle() {
		verifyTextContainsByXpath(SelfieTitle, "Verify your identity with a selfie", "Selfie page title");
	}
	public void clickTakePhotoBtn() {
		clickbyXpath(Take_PhotoButton, "Take photo Button");
	}
	
	public void verifyCameratitle() {
		verifyTextContainsByXpath(CameraTitle, "Camera", "Camera title ");
	}
	
	public void verifyFaceRecognized_Toast() {
		verifyDynamicContentByXpath("//android.widget.Toast[@text=\"Face Recognized successfully\"]","Address line added successfully" , "Radius updated Toast");
	}
	
	public void verifyJobCategoryTitle() {
		verifyTextContainsByXpath(Select_job_categoryTitle, "Select job category", "Select job categiry page title ");

	}
	public void clickACjob() {
		clickbyXpath(product_name_Button_0, "AC Product");
	}
	public void verifySelectexperienceTitle() {
		verifyTextContainsByXpath(ExperienceInfoTitle, "Select Year of experience in “AC”", "Experience Pop-up title");
	}
	public void clickYearExperience() {
		clickbyXpath(yearsExperience, "Years Experience 0-1 year");
	}
	public void enterMinimumServiceCharge() {
		entervaluebyXpath(ServicechargeField, "Service charge field", "200");
	}
	public void verifyYearsofExp() {
		verifyTextContainsByXpath(years_of_experience, "(0 - 1 year) Min₹(200)", "Already entered YOE value");
	}
	public void clickEditBtn() {
		clickbyXpath(Jobcategory_Edit_Button, "Edit button");
	}
	public void clickRemoveBtn() {
		clickbyXpath(removeBtn, "Remove Button");
	}
	public void clickSubmitBtn() {
		clickbyXpath(submitBtn, "SubmitBtn");
	}
	
	public void checkHomepageAdvertisement() {
		isElementDisplayed(Advertisement, "Profile Page advertisement");
	}
	public void clickProfileIcon() {
		clickbyXpath(ProfileIcon, "ProfileIcon");
	}
	public void LogoutProserv() {
		clickbyXpath(LogoutBtn, "Logout Button");
	}
	public void popup_okBtn() {
		if(isElementDisplayedCheck(PopupOkbtn)) {
			
			clickbyXpath(PopupOkbtn, "Ok Pop-UP");
		}
	}
	public void DeleteAccount() {
		clickbyXpath(AccountDeleteButton, "DeleteAccount button");
	}
	public void Connectsei_entermobileno(String mobile) {
		isElementDisplayedCheck(Connectsei_mobilenofield);
		entervaluebyXpath(Connectsei_mobilenofield, "Mobile Number",mobile );
	}
	public void Connectsei_enterPassword(String password) {
		isElementDisplayedCheck(Connectsei_Passwordfield);
		entervaluebyXpath(Connectsei_Passwordfield, "Password",password );

	}
	public void Connecsei_clickLogin() {
		clickbyXpath(Connectsei_Loginfield, "login button");
	}
	public void Connecsei_deleteAccount() {
		clickbyXpath(Connectsei_DeleteAccount, "Delete button");
	}
	public void verifydeleteAccountToast() {
		clickbyXpath(AccountDeletedToast, "Account Deleted Toast");
	}
	   public void WifiSwitch(String Wifiname,String Wifipassword,String packages) throws Exception 
	   {
		   
		   connectToWiFi(Wifiname, Wifipassword);
			Runtime.getRuntime().exec("adb shell am force-stop com.android.settings");
		   if (driver.queryAppState(packages) != ApplicationState.RUNNING_IN_FOREGROUND) {
				driver.activateApp(packages); 
				// Bring it back
//				Thread.sleep(3000);
			}
	   }
	   
	   public void saveHomeLocation() {
		 Location = ConfirmLocation_Addresstext.getText();
		 Reporter.reportStep("Analytics value before Start of the session : " + Location, "PASS");
			System.out.println(Location);
			String editeddtext =ConfirmLocation_Addresstext.getText();
			setLoadProp("HOMEADDRESS", editeddtext);
	}
	  
	   public void saveOfficeLocation() {
		   String Officeaddress = Home_address.getText();
		   setLoadProp("OFFICEADDRESS", Officeaddress);
	}
	  
	   public void verifyAlreadyEditedHomeaddress() {
			verifyTextContainsByXpath(Home_address,loadProp("HOMEADDRESS"), "Edited  address: "+loadProp("HOMEADDRESS"));
			}
	  
	   public void verifyAlreadyEditedOfficeAddress() {
		   verifyTextContainsByXpath(Home_address,loadProp("OFFICEADDRESS"), "Edited  address: "+loadProp("OFFICEADDRESS"));
		   
	}
	   public void clickOffice_afterRegisterpage() {
		   	clickbyXpath(EditAddress_Officebtn_afterregister, "Office button");
	}
	   public void clickAddAddress_Officepage() {
		   clickbyXpath(EditAddress_AddAddressText_afterregister, "Add address text");
	}
	   
	   public void checknotificationbutton() {
		  verifyTextContainsByXpath(HomepageStatustext, "Status:", "Home page Status text") ;
	}
	   
	   public void clickAddressarrow() {
			clickbyXpath(AddressDownArrow, "AddressDownArrow");
		}
		public void verifyAddressTitle() {
			verifyTextContainsByXpath(EditAddressTitle, "Edit Address", "Edit Address title");
		}
	   public void deleteAccount() throws Exception {

	
		 clickProfileIcon();
		 DeleteAccount();
		 popup_okBtn();
		
//		 Connectsei_uninstall_reinstall();
//		 Connectsei_entermobileno(loadProp("MOBILENUMBER"));
//		 Connectsei_enterPassword(loadProp("PASSWORD"));
//		 Connecsei_clickLogin();
//		 popup_okBtn();
////		 checknotificationbutton();
//		 clickProfileIcon();
//		 Connecsei_deleteAccount();
//		 popup_okBtn();
	   }
	   
	   public void ConnectseiDeleteAccount() {
		   clickProfileIcon();
		   clickbyXpath(Connectsei_DeleteAccount, "Connectsei DeletAcnt");
			popup_okBtn();
	}
	   public void registeraccount(String username,String Lastname,String Password) {
		  setLoadProp("MOBILENUMBER_CONNECTSEI_2", 9+randomnumbers(9));
		  System.out.println(loadProp("MOBILENUMBER_CONNECTSEI_2"));
		clickRegisterLink();
		enterFirstName(username);
		enterLastName(Lastname);
		enterMobileNumber(loadProp("MOBILENUMBER_CONNECTSEI_2"));
		enterPassword(Password);
		enterConfirmPassword(Password);
		clickCheckbox();
		clickRegisterButton();
		OTPtitlecheck();
		enterOTP();
//		checknotificationbutton();
	}
	   public void Relogin_deletedAcnt() throws Exception {
		    clickMoredetails();
			
			 checkAdddetailedAddress();
			 saveHomeLocation();
			 Flatfield();
			 clickSaveBtn();
			 verifyAddressline_Toast();
			
			 verifyServiceAreatitle();
			 scrollSlider();
			 clickSaveBtn();
			 verifyRadiusToast();
			
			
			 verifySelfietitle();
			 clickTakePhotoBtn();
			 verifyCameratitle();
			 clickTakePhotoBtn();
			 verifyCameratitle();
			 clickSaveBtn();
			 verifyFaceRecognized_Toast();
			
			 verifyJobCategoryTitle();
			 clickACjob();
			 verifySelectexperienceTitle();
			 clickYearExperience();
			 enterMinimumServiceCharge();
			 clickSaveBtn();
			 verifyYearsofExp();
           
			
			 clickEditBtn();
			 clickRemoveBtn();
			 clickACjob();
			 verifySelectexperienceTitle();
			 clickYearExperience();
			 enterMinimumServiceCharge();
			 clickSaveBtn();
			 verifyYearsofExp();
			 clickSubmitBtn();
			//check Address page functonality -already added address -Add new adress 
			 checknotificationbutton();
			 clickAddressarrow();
			 verifyAddressTitle();
			 verifyAlreadyEditedHomeaddress();
			
			//Adding new office address
			 clickOffice_afterRegisterpage();
			 clickAddAddress_Officepage();
			 verifyConfirmLocation();
			 clickMoredetails();
			 saveOfficeLocation();
			 Flatfield();
			 clickSaveBtn();
			 verifyAddressline_Toast();
			
				
			
			 checknotificationbutton();
	}
		
		public void clickonProductName(int num,String Productname) {
			clickbyXpath(Productname(num), Productname);
		}
	  
}
