package com.ProservPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Base64;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import com.wrappers.GenericWrappers;

import io.appium.java_client.android.AndroidDriver;

public class Profile_page  extends GenericWrappers{

	public Profile_page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public AndroidDriver driver;
//	Register_page rp= new Register_page(driver);
	
	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String email =loadProp("EMAILID");
	String mobilenumber=loadProp("MOBILENUMBER");
	String state;
	// Locate all elements on the page

	@FindBy(xpath = "//android.widget.TextView[@text=\"Profile\"]")
	private WebElement ProfileIcon;
	@FindBy(xpath = "//*[@resource-id='ProfileTitleName0']")
	private WebElement YourProfileIcon;
	@FindBy(xpath = "//*[@resource-id='My ProfileTitle']")
	private WebElement ConnectseiYourProfileIcon;
	@FindBy(xpath = "//*[@resource-id='ProfileTitleName1']")
	private WebElement JobServcieListIcon;
	@FindBy(xpath = "//*[@resource-id='ProfileTitleName2']")
	private WebElement ServiceProvidingAreaZoneIcon;
	@FindBy(xpath = "//*[@resource-id='ProfileTitleName3']")
	private WebElement SavedAddressIcon;
	@FindBy(xpath = "//*[@resource-id='ProfileTitleName4']")
	private WebElement KYCIcon;
	@FindBy(xpath = "//*[@resource-id='ProfileTitleName5']")
	private WebElement AwardsandCertificateIcon;
	@FindBy(xpath = "//*[@resource-id='LogoutText']")
	private WebElement LogoutIcon;
	@FindBy(xpath = "//*[@resource-id='AccountDeleteText']")
	private WebElement AccountDeleteIcon;
	@FindBy(xpath = "//*[@resource-id='UserName']")
	private WebElement Profilepage_Username;
	@FindBy(xpath = "//*[@resource-id='mobile_number']")
	private WebElement Profilepage_MobileNumber;
	
	@FindBy(xpath = "//*[@resource-id='MobileNumber']")
	private WebElement Connectsei_Profilepage_MobileNumber;
	
	@FindBy(xpath = "//*[@resource-id='ProfileImage']")
	private WebElement Profilepage_ProfileImage;
	@FindBy(xpath = "//android.widget.Toast[@text=\"Account deleted successfully\"]")
	private WebElement AccountDeletedToast;
	@FindBy(xpath = "//android.widget.Button[@text=\"OK\"]")
	private WebElement PopupOkbtn;
	@FindBy(xpath = "//*[@resource-id='UserDetails0']")
	private WebElement Profile_username;
	@FindBy(xpath = "//*[@resource-id='UserDetails2']")
	private WebElement Profile_mobilenumber;
	@FindBy(xpath = "//*[@resource-id='UserDetails1']")
	private WebElement Profile_Emailid;
	@FindBy(xpath = "//*[@resource-id='UserDetailsEditIconButton0']")
	private WebElement Profile_username_editicon;
	@FindBy(xpath = "//*[@resource-id='UserDetailsEditIconButton1']")
	private WebElement Profile_emailid_editicon;
	@FindBy(xpath = "//*[@resource-id='UserDetailsEditIconButton2']")
	private WebElement Profile_mobileno_editicon;
	@FindBy(xpath = "//*[@resource-id='UserDetailsEditIconButton3']")
	private WebElement Profile_Password_editicon;
	@FindBy(xpath = "//*[@resource-id='EditButton0']")
	private WebElement ConnectseiProfile_username_editicon;
	@FindBy(xpath = "//*[@resource-id='EditButton1']")
	private WebElement ConnectseiProfile_emailid_editicon;
	@FindBy(xpath = "//*[@resource-id='EditButton2']")
	private WebElement ConnectseiProfile_mobileno_editicon;
	@FindBy(xpath = "//*[@resource-id='EditText3']")
	private WebElement ConnectseiProfile_Password_editicon;
	@FindBy(xpath = "//*[@resource-id='EditIconButton']")
	private WebElement Profile_Profileediticon;
	@FindBy(xpath = "//*[@resource-id='first_nameInput']")
	private WebElement Profile_editnamepage_firstnameinput;
	@FindBy(xpath = "//*[@resource-id='last_nameInput']")
	private WebElement Profile_editnamepage_lastnameinput;
	@FindBy(xpath = "//android.widget.Toast[@text=\"User name updated successfully\"]")
	private WebElement usernameUpdatedToastmessage;
	@FindBy(xpath = "//*[@resource-id='emailInput']")
	private WebElement EditemailIDfield;
	@FindBy(xpath = "//*[@resource-id='Generate OTPButton']")
	private WebElement Generate_OTPButton;
	@FindBy(xpath = "//*[@resource-id='emailError']")
	private WebElement EmailIderrormsg;
	@FindBy(xpath = "//*[@resource-id='Enter OTPTitle']")
	private WebElement OTPtitle;
	@FindBy(xpath = "//*[@resource-id='otp_input_0']")
	private WebElement OTP1;
	@FindBy(xpath = "//*[@resource-id='otp_input_1']")
	private WebElement OTP2;
	@FindBy(xpath = "//*[@resource-id='otp_input_2']")
	private WebElement OTP3;
	@FindBy(xpath = "//*[@resource-id='otp_input_3']")
	private WebElement OTP4;
	@FindBy(xpath = "//*[@resource-id='otp_input_4']")
	private WebElement OTP5;
	@FindBy(xpath = "//*[@resource-id='otp_input_5']")
	private WebElement OTP6;
	@FindBy(xpath = "//*[@resource-id='resendtext']")
	private WebElement resendtext;
	@FindBy(xpath = "//*[@resource-id='Confirm OTPText']")
	private WebElement Confirm_OTPText;
	@FindBy(xpath = "//*[@resource-id='ProfileTitle']")
	private WebElement ProfileTitle;
	@FindBy(xpath = "//*[@resource-id='mobile_numberInput']")
	private WebElement Mobilenumberfield;
	@FindBy(xpath = "//*[@resource-id='mobile_numberError']")
	private WebElement mobileNoErrmsg;
	@FindBy(xpath = "//*[@resource-id='confirmPasswordError']")
	private WebElement confirmPassworderromsg;
	@FindBy(xpath = "//*[@resource-id='radius_value']")
	private WebElement radius_value;
	@FindBy(xpath = "//*[@resource-id='EditedAddress']")
	private WebElement EditedAddress;
	@FindBy(xpath = "//*[@resource-id='AadharNumberInput']")
	private WebElement Aadharinputfield;
	@FindBy(xpath = "//*[@resource-id='pan_numberInput']")
	private WebElement Paninputfield;
	@FindBy(xpath = "//*[@resource-id='account_numberInput']")
	private WebElement Accountnoinputfield;
	@FindBy(xpath = "//*[@resource-id='ifsc_codeInput']")
	private WebElement ifsc_codeInputfield;
	@FindBy(xpath = "//*[@resource-id='AadharVerifyButton']")
	private WebElement AadharVerifyButton;
	@FindBy(xpath = "//*[@resource-id='CheckBoxfalse']")
	private WebElement Checkbox;
	@FindBy(xpath = "//*[@resource-id='pan_numberError']")
	private WebElement pan_numberErrormsg;
	@FindBy(xpath = "//*[@resource-id='account_numberError']")
	private WebElement account_numberErrormsg;
	@FindBy(xpath = "//*[@resource-id='ifsc_codeError']")
	private WebElement ifsc_codeErrormsg;
	@FindBy(xpath = "//*[@resource-id='BackIconSVG']")
	private WebElement backIcon;
	@FindBy(xpath = "//*[@resource-id='My ProfileTitle']")
	private WebElement MyProfileTitle;
	@FindBy(xpath = "//*[@resource-id='KYC VerificationTitle']")
	private WebElement KYCVerificationTitle;
	@FindBy(xpath = "//*[@resource-id='GalaryButton']")
	private WebElement uploadImage;
	@FindBy(xpath = "//*[@resource-id='CardTitleName1']")
	private WebElement ConnectseiAddressesbutton;
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
	
	public void verifydeleteAccountToast() {
		clickbyXpath(AccountDeletedToast, "Account Deleted Toast");
	}
	public void DeleteAccount() {
		clickbyXpath(AccountDeleteIcon, "DeleteAccount button");
	}
	public void LogoutProserv() {
		clickbyXpath(LogoutIcon, "Logout Button");
	}
	public void popup_okBtn() {
		clickbyXpath(PopupOkbtn, "Ok Pop-UP");
	}
	public void verifyProfilepageName() {
		verifyTextContainsByXpath(Profilepage_Username, username, "Profilepage_Username");

	}
	public void verifyProfilepageMobileNo() {
		verifyTextContainsByXpath(Profilepage_MobileNumber,mobilenumber , "Profilepage_MobileNumber");
		
	}
	public void verifyConnectsei_ProfilepageMobileNo() {
		verifyTextContainsByXpath(Connectsei_Profilepage_MobileNumber,mobilenumber , "Profilepage_MobileNumber");
		
	}
	public void clickonYourProfile() {
		clickbyXpath(YourProfileIcon, "YourProfileIcon");
	}
	
	public void clickonJobserviceList() {
		clickbyXpath(JobServcieListIcon, "JobServcieListIcon");
		

	}
	public void clickonServiceProvidingAreaZone() {
		clickbyXpath(ServiceProvidingAreaZoneIcon, "ServiceProvidingAreaZoneIcon");
		

	}
	public void clickonSavedAddress() {
		clickbyXpath(SavedAddressIcon, "SavedAddressIcon");
		

	}
	public void clickonKYC() {
		clickbyXpath(KYCIcon, "KYCIcon");
		

	}
	public void clickonAwards_Certificate() {
		clickbyXpath(AwardsandCertificateIcon, "AwardsandCertificateIcon");
		

	}
	
	public void clickProfileediticon() {
		clickbyXpath(Profile_Profileediticon, "Profile_Profileediticon");
	}
	
	public void clickProfile_Usernameediticon() {
		clickbyXpath(Profile_username_editicon, "Profile_username_editicon");

	}
	public void ConnectseiclickProfile_Usernameediticon() {
		clickbyXpath(ConnectseiProfile_username_editicon, "Profile_username_editicon");
		
	}
	public void clickProfile_Emailidediticon() {
		clickbyXpath(Profile_emailid_editicon, "Profile_emailid_editicon");
		

	}
	public void ConnectseiclickProfile_Emailidediticon() {
		clickbyXpath(ConnectseiProfile_emailid_editicon, "Profile_emailid_editicon");
		
		
	}
	public void clickProfile_mobilenoediticon() {
		clickbyXpath(Profile_mobileno_editicon, "Profile_mobileno_editicon");
		

	}
	public void ConnectseiclickProfile_mobilenoediticon() {
		clickbyXpath(ConnectseiProfile_mobileno_editicon, "Profile_mobileno_editicon");
		
		
	}
	public void clickProfile_Passwordediticon() {
		clickbyXpath(Profile_Password_editicon, "Profile_Password_editicon");

	}
	public void ConnectseiclickProfile_Passwordediticon() {
		clickbyXpath(ConnectseiProfile_Password_editicon, "Profile_Password_editicon");
		
	}
	public void clearandmodifyFirstname(String firstname) {
		Profile_editnamepage_firstnameinput.clear();
		entervaluebyXpath(Profile_editnamepage_firstnameinput, "Firstname", firstname);

	}
	public void clearandmodifyLastname(String lastname) {
		Profile_editnamepage_lastnameinput.clear();
		entervaluebyXpath(Profile_editnamepage_lastnameinput, "", lastname);

	}
	public void verifyusernameToast() {
		verifyTextContainsByXpath(usernameUpdatedToastmessage, "User name updated successfully", "Username updated successfully toast");
	}
	public void enteremailID(String email) {
		entervaluebyXpath(EditemailIDfield,"Email field" , email);
	}
	public void clearEmailfield() {
		EditemailIDfield.clear();
	}
	
	public void clickGenerateOTPbtn() {
		clickbyXpath(Generate_OTPButton, "Generate OTPButton");
	}
	public void verifyOTPfielderrormsg() {
		verifyTextContainsByXpath(EmailIderrormsg, "Email is required.", "Email error message");
		
	}
	public void ConnectseiverifyOTPfielderrormsg() {
		verifyTextContainsByXpath(EmailIderrormsg, "Email is required", "Email error message");
		
	}
	public void verifyOTPtitle() {
		verifyTextContainsByXpath(OTPtitle, "Enter OTP", "OTP title");
	}
	public void enterOTP() {

		entervaluebyXpath(OTP1,  "OTP","1");
		entervaluebyXpath(OTP2 ,"OTP","2");
		entervaluebyXpath(OTP3, "OTP" ,"3");
		entervaluebyXpath(OTP4, "OTP", "4");
		
		hidekeyboard();
		
		clickbyXpath(Confirm_OTPText, "Confirm OTP");
	}
	public void verifyProfileTitle() {
		isElementDisplayed(ProfileTitle,"ProfileTitle");
		verifyTextContainsByXpath(ProfileTitle, "Profile", "Profile title");
	}
	public void clearMobilenoField() {
		Mobilenumberfield.clear();
	}
	public void verifyMobilenoErrormsg() {
		verifyTextContainsByXpath(mobileNoErrmsg, "Mobile number is required", "Mobile number error msg");
	}
	public void verifyConfirmpassword_Errmsg() {
		verifyTextContainsByXpath(confirmPassworderromsg, "Confirm password is required", "Confirm password error msg");
	}
	public void checkSavedRadius(String radius) {
		
		verifyTextContainsByXpath(radius_value, radius, "Saved Radius value");
	}
	public void checkEditedAddresspage(String address) {
		verifyTextContainsByXpath(EditedAddress, address, "Edited address");
	}
	public void enterAadharno() {
		entervaluebyXpath(Aadharinputfield, "Addhar field", randomnumbers(12));
	}
	public void clickCheckbox() {
		clickbyXpath(Checkbox, "Checkbox");
	}
	public void clickVerifybtn() {
		clickbyXpath(AadharVerifyButton, "Verify button");
	}
	public void enterAadhaarOTP() {
		entervaluebyXpath(OTP1, "OTP","1");
		entervaluebyXpath(OTP2,"OTP","2");
		entervaluebyXpath(OTP3, "OTP" ,"3");
		entervaluebyXpath(OTP4, "OTP", "4");
		entervaluebyXpath(OTP5, "OTP", "5");
		entervaluebyXpath(OTP6, "OTP", "6");
		
		hidekeyboard();
		
		clickbyXpath(Confirm_OTPText, "Confirm OTP");
	}
	public void checkPanErrormsg() {
		verifyTextContainsByXpath(pan_numberErrormsg,"PAN number is required" , "Pan field error msg");
	}
	public void checkAccountnoErrormsg() {
		verifyTextContainsByXpath(account_numberErrormsg, "Account number is required","Account number error msg" );

	}
	public void checkIFSCerrormsg() {
		verifyTextContainsByXpath(ifsc_codeErrormsg,"IFSC code is required" ,"IFSC error msg" );

	}
	public void enterPANnumber() {
		entervaluebyXpath(Paninputfield, "Pan Inputfield", "ABCDE"+randomnumbers(4)+"A");
	}
	public void enterAccountnumber() {
		entervaluebyXpath(Accountnoinputfield, "Accountnumber Inputfield",randomnumbers(9));
	}
	public void enterIFSCcode() {
		entervaluebyXpath(ifsc_codeInputfield, "IFSC Inputfield","HDFC"+"000"+randomnumbers(4));
	}
	public void navigateback() {
		clickbyXpath(backIcon, "Back icon");
	}
	public void verifyMyProfileTitle() {
		verifyTextContainsByXpath(MyProfileTitle, "My Profile", "My profiel page");
	}
	public void verifyKYCverificationtitle() {
		verifyTextContainsByXpath(KYCVerificationTitle, "KYC Verification", "KYC Verification");
	}
	
	public String convertImageToBase64(String imagePath) throws IOException {
        // Read all bytes from the image file
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        
        // Encode the bytes to Base64
        return Base64.getEncoder().encodeToString(imageBytes);
    }
    
    public void uploadImage(String imagePath, WebElement element) throws IOException {
        String base64Image = convertImageToBase64(imagePath);
        
        // Set the Base64 string as the element's value
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value = arguments[1];", element, base64Image);
    }
    public void clickConnectseiAddressesbutton() {
    	clickbyXpath(ConnectseiAddressesbutton, "Connectsei Addresses button");
	}
	
}
