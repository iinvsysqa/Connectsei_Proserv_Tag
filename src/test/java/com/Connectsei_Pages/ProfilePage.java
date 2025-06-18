package com.Connectsei_Pages;

import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import com.wrappers.GenericWrappers;

public class ProfilePage extends GenericWrappers {


	private AndroidDriver driver;

	// Locate all elements on the page
	
	@FindBy(xpath = "//*[@resource-id='My ProfileTitle']") 
	private WebElement myProfilePageTitle;
	
	@FindBy(xpath = "//*[@resource-id='UserName']")
	private WebElement checkRegisterSameUserName;
	
	@FindBy(xpath = "//*[@resource-id='MobileNumber']")
	private WebElement checkRegisterSameMobileNo;
	
	@FindBy(xpath = "//*[@resource-id='CardTitleName0']")
	private WebElement yourProfileTitle;
	
	@FindBy(xpath = "//*[@resource-id='CardDescription0']")
	private WebElement yourProfileDescription;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
	private WebElement profilePageBackButton;
	
	@FindBy(xpath = "//*[@resource-id='ProfileTitle']")
	private WebElement profilePageTitle;
	
	@FindBy(xpath = "//*[@resource-id='NameFirstLetter']")
	private WebElement nameFirstLetterInCircle;
	
	@FindBy(xpath = "//*[@resource-id='EditProfileData0']")
	private WebElement registerSameNameCheck;
	
	@FindBy(xpath = "//*[@resource-id='EditProfileData1']")
	private WebElement addYourEmailID;
	
	@FindBy(xpath = "//*[@resource-id='EditProfileData2']")
	private WebElement registerSameMobileNoCheck;
	
	@FindBy(xpath = "//*[@resource-id='EditButton0']")
	private WebElement nameFieldEditButton;
	
	@FindBy(xpath = "//*[@resource-id='EditButton1']")
	private WebElement emailFieldEditButton;
	
	@FindBy(xpath = "//*[@resource-id='EditButton2']")
	private WebElement mobileNoFieldEditButton;
	
	@FindBy(xpath = "//*[@resource-id='EditButton3']")
	private WebElement passwordFieldEditButton;
	
	@FindBy(xpath = "//*[@resource-id='BackIconSVG']")
	private WebElement editNamePageBackButton;
	
	@FindBy(xpath = "//*[@resource-id='Edit NameTitle']")
	private WebElement editNamePageTitle;
	
	@FindBy(xpath = "//*[@resource-id='first_nameInput']")  
	private WebElement editNamePageFirstNameField;
	
	@FindBy(xpath = "//*[@resource-id='last_nameInput']")
	private WebElement editNamePageLastNameField;
	
	@FindBy(xpath = "//*[@resource-id='first_nameError']")
	private WebElement firstNameFieldError;
	
	@FindBy(xpath = "//*[@resource-id='last_nameError']")
	private WebElement lastNameFieldError;
	
	@FindBy(xpath = "//*[@resource-id='SaveButton']")
	private WebElement editNamePageSaveButton;
	
	@FindBy(xpath = "//*[@resource-id='BackIconSVG']")
	private WebElement editEmailPageBackButton;
	
	@FindBy(xpath = "//*[@resource-id='Edit EmailTitle']")
	private WebElement editEmailPageTitle;
	
	@FindBy(xpath = "//*[@resource-id='Generate OTPButton']")
	private WebElement editEmailPageGenerateOTPButton;
	
	@FindBy(xpath = "//*[@resource-id='emailError']")
	private WebElement editEmailPageError;
	
	@FindBy(xpath = "//*[@resource-id='emailInput']")
	private WebElement editEmailField;
	
	@FindBy(xpath = "//*[@resource-id='Edit Mobile NumberTitle']")
	private WebElement editMobileNoPageTitle;
	
	@FindBy(xpath = "//*[@resource-id='BackIconSVG']")
	private WebElement editMobileNoPageBackButton;
	
	@FindBy(xpath = "//*[@resource-id='mobile_numberInput']")
	private WebElement editMobileNoField;
	
	@FindBy(xpath = "//*[@resource-id='mobile_numberError']")
	private WebElement mobileNoFieldError;  
	
	@FindBy(xpath = "//*[@resource-id='Generate OTPButton']")
	private WebElement editMobileNoGenerateOTPButton;
	
	@FindBy(xpath = "//*[@resource-id='Edit PasswordTitle']")
	private WebElement editPasswordPageTital;
	
	@FindBy(xpath = "//*[@resource-id='passwordInput']")
	private WebElement editPasswordPagePasswordField;
	
	@FindBy(xpath = "//*[@resource-id='confirmPasswordInput']")
	private WebElement editPasswordPageConfirmPasswordField;   
	
	@FindBy(xpath = "//*[@resource-id='passwordError']")
	private WebElement editPasswordPagePasswordFieldRequiredError;   
	
	@FindBy(xpath = "//*[@resource-id='confirmPasswordError']")
	private WebElement editPasswordPageConfirmPasswordFieldRequiredError; 
	
	@FindBy(xpath = "//*[@resource-id='confirmPasswordError']")
	private WebElement editPasswordPageConfirmPasswordFieldError; 
	
	@FindBy(xpath = "//*[@resource-id='EyeOpenSVG']")
	private WebElement confirmPasswordFieldEyeIcon;
	
	@FindBy(xpath = "//*[@resource-id='SaveButton']")
	private WebElement editPasswordPageSaveButton;
	
	@FindBy(xpath = "//*[@resource-id='CardTitleName1']")
	private WebElement addressesTitle;
	
	@FindBy(xpath = "//*[@resource-id='CardDescription1']")
	private WebElement addressesDescription;
	
	@FindBy(xpath = "//*[@resource-id='AddressesTitle']")
	private WebElement addressesPageTitle;
	
	@FindBy(xpath = "//com.horcrux.svg.MaskView")
	private WebElement addressesPageBackButton;
	
	@FindBy(xpath = "//*[@resource-id='AddAddressText']") 
	private WebElement addAddressesButton;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Constructor to initialize the driver and instantiate elements using
	
		public ProfilePage(AndroidDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			this.wait=new WebDriverWait(driver, 30);
		}

		// Methods to be used as part of loginpage.
		
		public void verifyMyProfilePageTitle() {
			verifyTextContainsByXpath(myProfilePageTitle, "My Profile", " Page Title ");
		}
		
		public void verifyRegisterSameName(String username) {
			verifyTextContainsByXpath(checkRegisterSameUserName, username, " Same Name ");
		}
		
		public void verifyRegisterSameMobileNo() {
			verifyTextContainsByXpath(checkRegisterSameMobileNo, "7871987895", " Same Mobile No ");
		}
		
		public void verifyYourProfilefieldTitle() {
			verifyTextContainsByXpath(yourProfileTitle, "Your Profile", " Title ");
		}
		
		public void verifyYourProfilefieldDescription() {
			verifyTextContainsByXpath(yourProfileDescription, "Manage your profile", " Description ");
		}
		
		public void clickYourProfileButton() {
			clickbyXpath(yourProfileDescription, " Click the Your Profile Button ");
		}
		
		public void clickProfilePageBackButton() {
			clickbyXpath(profilePageBackButton, " Click the Profile Page Back Button ");
		}
		
		public void verifyProfilePageTitle() {
			verifyTextContainsByXpath(profilePageTitle, "Profile", " Title ");
		}
		
		public void verifyProfilePageNameFirstLetter() {
			verifyTextContainsByXpath(nameFirstLetterInCircle, "S", " Name First Letter In Circle ");
		}
		
		public void verifyProfilePageNameFirstCheck() {
			verifyTextContainsByXpath(registerSameNameCheck, "Saran Kumar", " Same Name ");
		}
		
		public void verifyProfilePageEmailPlaceholderText() {
			verifyTextContainsByXpath(addYourEmailID, "Add your email ID", " Placeholder Text ");
		}
		
		public void verifyProfilePageMobileNoCheck() {
			verifyTextContainsByXpath(registerSameMobileNoCheck, "7871987895", " Same Mobile No ");
		}
		
		public void clickProfilePageNameFieldEditButton() {
			clickbyXpath(nameFieldEditButton, " Click the Profile Page Name Field Edit Button ");
		}
		
		public void clickEditNamePageBackButton() {
			clickbyXpath(editNamePageBackButton, " Click the Edit Name Page Back Button ");
		}
		
		public void verifyEditPageFirstNameCheck() {
			verifyTextContainsByXpath(editNamePageFirstNameField, "Saran", " Same First Name ");
		}
		
		public void verifyEditNamePageTitle() {
			verifyTextContainsByXpath(editNamePageTitle, "Edit Name", "Title");
		}
		
		public void verifyEditPageLastNameCheck() {
			verifyTextContainsByXpath(editNamePageLastNameField, "Kumar", " Same Last Name ");
		}
		
		public void enterEditFirstName(String EditFirstName) {
			entervaluebyXpath(editNamePageFirstNameField, "Edit The First Name" , EditFirstName);	
		}
		
		public void enterEditLastName(String EditLastName) {
			entervaluebyXpath(editNamePageLastNameField, "Edit The Last Name" , EditLastName);	
		}
		
		public void clearFirstname() {
			editNamePageFirstNameField.clear();	
		}
		
		public void clearLastname() {
			editNamePageLastNameField.clear();
		}
		
		public void verifyEditPageFirstNameError() {
			verifyTextContainsByXpath(firstNameFieldError, "First name is required", " First Name Field Error ");
		}
		
		public void verifyEditPageLastNameError() {
			verifyTextContainsByXpath(lastNameFieldError, "Last name is required", " Last Name Field Error ");
		}
		
		public void clickEditNamePageSaveButton() {
			clickbyXpath(editNamePageSaveButton, " Click the Edit Name Page Save Button ");
		}
		
		public void clickEmailFieldEditButton() {
			clickbyXpath(emailFieldEditButton, " Click the Email Field Edit Button ");
		}
		
		public void clickEditEmailPageBackButton() {
			clickbyXpath(editEmailPageBackButton, " Click the Edit Email Page Back Button ");
		}
		
		public void verifyEditEmailTitle() {
			verifyTextContainsByXpath(editEmailPageTitle, "Edit Email", " Title ");
		}
		
		public void enterTheEmail(String EnterTheEmail) {
			entervaluebyXpath(editEmailField, "Enter The Email" , EnterTheEmail);	
		}
		
		public void clickEditEmailPageGenerateOTPButton() {
			clickbyXpath(editEmailPageGenerateOTPButton, " Click the Edit Email Page GenerateOTP Button ");
		}
		
		public void verifyEditEmailFieldError() {
			verifyTextContainsByXpath(editEmailPageError, "Email is required", " Error ");
		}
		
		public void clickMobileNoFieldEditButton() {
			clickbyXpath(mobileNoFieldEditButton, " Click the Mobile No Field Edit Button ");
		}
		
		public void clickEditMobileNoPageBackButton() {
			clickbyXpath(editMobileNoPageBackButton, " Click the Edit Mobile No Page Back Button ");
		}
		
		public void verifyEditMobileNoPageTitle() {
			verifyTextContainsByXpath(editMobileNoPageTitle, "Edit Mobile Number", " Title ");
		}
		
		public void verifyPreviousMobileNoCheck() {
			verifyTextContainsByXpath(editMobileNoField, "7871987895", " Previous Number ");
		}
		
		public void clearMobilenumber() {
			editMobileNoField.clear();	
		}
		
		public void verifyMobileNoFieldError() {
			verifyTextContainsByXpath(mobileNoFieldError, "Mobile number is required", " Error ");
		}
		
		public void clickEditMobileNoPageGenerateOTPButton() {
			clickbyXpath(editMobileNoGenerateOTPButton, " Click the Edit Mobile No Page GenerateOTP Button ");
		}
		
		public void enterEditMobileNo(String EditMobileNo) {
			entervaluebyXpath(editMobileNoField, "Edit The Mobile No" , EditMobileNo);	
		}
		
		public void clickPasswordFildeEditButton() {
			clickbyXpath(passwordFieldEditButton, " Click the Password Field Edit Button ");
		}
		
		public void verifyEditPasswordPageTitle() {
			verifyTextContainsByXpath(editPasswordPageTital, "Edit Password", " Title ");
		}
		
		public void enterEditPassword(String EditPassword) {
			entervaluebyXpath(editPasswordPagePasswordField, "Edit The Password" , EditPassword);	
		}
		
		public void enterEditConfirmPassword(String EditConfirmPassword) {
			entervaluebyXpath(editPasswordPageConfirmPasswordField, "Edit The Confirm Password" , EditConfirmPassword);	
		}
		
		public void clickConfirmPasswordFildeEyeIcon() {
			clickbyXpath(confirmPasswordFieldEyeIcon, " Click the Confirm Password Field Eye Icon ");
		}
		
		public void verifyPasswordFieldError() {
			verifyTextContainsByXpath(editPasswordPagePasswordFieldRequiredError, "Password is required", " Error ");
		}
		
		public void verifyConfirmPasswordFieldError() {
			verifyTextContainsByXpath(editPasswordPageConfirmPasswordFieldRequiredError, "Confirm password is required", " Error ");
		}
		
		public void verifyConfirmPasswordFieldMismatchError() {
			verifyTextContainsByXpath(editPasswordPageConfirmPasswordFieldError, "Password mismatch.", " Error ");
		}
		
		public void clickEditPasswordPageSaveButton() {
			clickbyXpath(editPasswordPageSaveButton, " Click the Edit Password Page Save Button ");
		}
		
		public void verifyAddressesTitle() {
			verifyTextContainsByXpath(addressesTitle, "Addresses", " Title ");
		}
		
		public void verifyAddressesDescription() {
			verifyTextContainsByXpath(addressesDescription, "Manage your saved addresses", " Description ");
		}
		
		public void clickAddressesButton() {
			clickbyXpath(addressesDescription, " Click the Addresses Button ");
		}
		
		public void verifyAddressesPageTitle() {
			verifyTextContainsByXpath(addressesPageTitle, "Addresses", " Title ");
		}
		
		public void clickAddressesPageBackButton() {
			clickbyXpath(addressesPageBackButton, " Click the Addresses Page Back Button ");
		}
		
		public void clickAddAddressesButton() {
			clickbyXpath(addAddressesButton, " Click the Add Addresses Button ");
		}
		
}

