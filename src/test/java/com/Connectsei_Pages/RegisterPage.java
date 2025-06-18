package com.Connectsei_Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import com.wrappers.GenericWrappers;

public class RegisterPage extends GenericWrappers {


	private AndroidDriver driver;

	// Locate all elements on the page
	@FindBy(xpath = "//*[@resource-id='sign_up']")
	private WebElement registerButton;
                        
	@FindBy(xpath = "//*[@resource-id='first_nameInput']")
	private WebElement firstnameField;
	
	@FindBy(xpath = "//*[@resource-id='last_nameInput']")
	private WebElement lastnameField;
	
	@FindBy(xpath = "//*[@resource-id='mobile_numberInput']")
	private WebElement mobilenumberField;
	
	@FindBy(xpath = "//*[@resource-id='passwordInput']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//*[@resource-id='confirmPasswordInput']")
	private WebElement confirmpasswordField;
	
	@FindBy(xpath = "//com.horcrux.svg.PathView")
	private WebElement eyeiconButton;
	
	@FindBy(xpath = "//*[@resource-id='terms_and_condition_text']")
	private WebElement privacypolicyButton;
	
	@FindBy(xpath = "//com.horcrux.svg.SvgView")
	private WebElement privacypolicybackButton;
	
	@FindBy(xpath = "//*[@resource-id='CheckBoxfalse']")
	private WebElement checkboxtickButton;
	
	@FindBy(xpath = "//*[@resource-id='RegisterButton']")
	private WebElement register2Button;
	
//	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.ConnectSei:id/terms_and_condition_text\"]")
//	private WebElement mobileNumberAlreadyRegisteredToast;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
	private WebElement locationWhileUsingTheAppButton;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement notificationPermission;
	
	@FindBy(xpath = "//*[@resource-id='otp_input_0']")
	private WebElement otpBox1;
	
	@FindBy(xpath = "//*[@resource-id='otp_input_1']")
	private WebElement otpBox2;
	
	@FindBy(xpath = "//*[@resource-id='otp_input_2']")
	private WebElement otpBox3;
	
	@FindBy(xpath = "//*[@resource-id='otp_input_3']")
	private WebElement otpBox4;
	
	@FindBy(xpath = "//*[@resource-id='Confirm OTPButton']")
	private WebElement confirmOTPButton;
	
	@FindBy(xpath = "//*[@resource-id='resend_otp_text']")
	private WebElement otpPageResendButton;
	
	@FindBy(xpath = "//*[@resource-id='first_nameError']")
	private WebElement firstNameFieldErrorMessage;
	
	@FindBy(xpath = "//*[@resource-id='last_nameError']")
	private WebElement lastNameFieldErrorMessage;
	
	@FindBy(xpath = "//*[@resource-id='mobile_numberError']")
	private WebElement mobileNoFieldErrorMessage;
	
	@FindBy(xpath = "//*[@resource-id='passwordError']")
	private WebElement passwordFieldErrorMessage;
	
	@FindBy(xpath = "//*[@resource-id='confirmPasswordError']")
	private WebElement confirmPasswordFieldErrorMessage;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.ConnectSei:id/otp_info_text\"]")
	private WebElement registeredSameMobileNo;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Profile\"]")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//*[@resource-id='LogoutText']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//*[@resource-id='android:id/alertTitle']")
	private WebElement logoutPopuptopic;
	
	@FindBy(xpath = "//*[@resource-id='android:id/message']")
	private WebElement logoutPopupContent;
	
	@FindBy(xpath = "//*[@resource-id='android:id/button2']")
	private WebElement logoutPopupcCancelButton;
	
	@FindBy(xpath = "//*[@resource-id='android:id/button1']")
	private WebElement logoutPopupcOkButton;
	
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup")
	private WebElement whiteScreen;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.android.permissioncontroller:id/permission_message\"]")
	private WebElement notificationPopupContent;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
	private WebElement notificationPopupAllowButton;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
	private WebElement notificationPopupDontallowButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"8. CONTACT US\"]")
	private WebElement scrollToText;
	
//	@FindBy(xpath = "")
//	private WebElement ;
	
//	@FindBy(xpath = "")
//	private WebElement ;
	
//	@FindBy(xpath = "")
//	private WebElement ;
	
//	@FindBy(xpath = "")
//	private WebElement ;
	

	// Constructor to initialize the driver and instantiate elements using
	
	public RegisterPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver, 30);
	}

	// Methods to be used as part of loginpage.
	
	public void clickRegisterButton() {
		clickbyXpath(registerButton, " Click the Register Button ");
	}
	
	public void verifyFirstnameErrorToast() {
		verifyTextContainsByXpath(firstNameFieldErrorMessage, "First name is required", " The Error ");
	}
	
	public void verifyLastnameErrorToast() {
		verifyTextContainsByXpath(lastNameFieldErrorMessage, "Last name is required", " The Error ");
	}
	
	public void verifyMobilenumberErrorToast() {
		verifyTextContainsByXpath(mobileNoFieldErrorMessage, "Mobile number is required", " The Error ");
	}
	
	public void verifyPasswordErrorToast() {
		verifyTextContainsByXpath(passwordFieldErrorMessage, "Password is required", " The Error ");
	}
	
	public void verifyConfirmpasswordErrorToast() {
		verifyTextContainsByXpath(confirmPasswordFieldErrorMessage, "Confirm password is required", " The Error ");
	}
	
	
	public void enterFirstName(String FirstName) {
		entervaluebyXpath(firstnameField, "Enter The First Name" , FirstName);
		
	}
	
	public void enterLastName(String LastName) {
		entervaluebyXpath(lastnameField, "Enter The Last Name" , LastName);
		
	}
	
	public void enterMobileNumber(String MobileNumber) {
		entervaluebyXpath(mobilenumberField, "Enter The  Mobile Number" , MobileNumber);
		
	}
	
	public void enterPassword(String Password) {
		entervaluebyXpath(passwordField, "Enter The Password" , Password);
		
	}	
	
	public void enterConfirmPassword(String ConfirmPassword) {
		entervaluebyXpath(confirmpasswordField, "Enter The Confirm Password" , ConfirmPassword);
		
	}	
	
	public void clickEyeIconButton() {
		clickbyXpath(eyeiconButton, " Click the Eye Icon Button ");
	}
	
	public void clickPrivacyPolicyButton() {
		clickbyXpath(privacypolicyButton, " Click the Privacy Policy Button ");
	}
	
	public void clickAndScrollThePage() {
		scrollToText("8. CONTACT US");
		
	}
	public void clickPrivacyPolicyBackButton() {
		clickbyXpath(privacypolicybackButton, " Click the Privacy Policy Back Button ");
	}
	
	public void clickCheckBoxTickButton() {
		clickbyXpath(checkboxtickButton, " Click the Privacy Policy Check Box Tick Button ");
	}
	
	public void clickRegister2Button() {
		clickbyXpath(register2Button, " Click the Register Button ");
	}
	
	public void verifyMobileNumberAlreadyRegisteredToast(){
		verifyDynamicContentByXpath("//android.widget.Toast[@text=\"Mobile number already registered\"]","Mobile number already registered" , "Mobile number already registered Toast");
		
	}
	
	//public void clickSubmitButton() {
	//clickbyXpath(submitButton, "Click The Submit Button");
		
//	}	
	
	public void clickWhileUsing() {
		if (isElementDisplayedCheck(locationWhileUsingTheAppButton)) {
			clickbyXpath(locationWhileUsingTheAppButton, "In Location Pop-up Click The While Using The App Option");
			}
	
	}
	
    public void clickNotificationPermission() {
    	expWait(notificationPermission);
		clickbyXpath(notificationPermission, "Click the Go TO Settings Button In Notification Permission Pop-up ");	
		
    }	
    
    public void clickNotificationPermissionAllow() {
    	//expWait(notificationPermission);
    	if (isElementDisplayedCheck(notificationPopupAllowButton)) {
    		clickbyXpath(notificationPopupAllowButton, "Click TO Allow the Notification Permission Pop-up ");	
			}
		
    }	
    
	public void enterOTPBox1(String Number) {
		entervaluebyXpath(otpBox1, "Enter The OTP 1" ,Number );
		
	}	
	public void enterOTPBox2(String Number) {
		entervaluebyXpath(otpBox2, "Enter The OTP 2" ,Number );
	
	}
	public void enterOTPBox3(String Number) {
		entervaluebyXpath(otpBox3, "Enter The OTP 3" ,Number );
		
	}
	public void enterOTPBox4(String Number) {
		entervaluebyXpath(otpBox4, "Enter The OTP 4" ,Number );
		
	}
	public void clickConfirmOTPButton() {
		clickbyXpath(confirmOTPButton, "Click the OTP Page Confirm OTP Button");
		
	}	
	public void clickResendButton() {
		clickbyXpath(otpPageResendButton, "Click the OTP Page Resend Button");
		
	}	
	public void verifyRegisteredSameMobileNo() {
		verifyTextContainsByXpath(registeredSameMobileNo, "Enter the OTP code we send via SMS to your registered mobile number +912222211113", " Content ");
	
	}
	
    public void clickProfileIcon() {
	    clickbyXpath(profileIcon, "Click the Home Page Profile Icon");
	
    }
	
    public void clickLogoutButton() {
	    clickbyXpath(logoutButton, "Click the My Profile Page Logout Button");  
	    
    }	
	public void verifyLogoutPopupTopic() {
		verifyTextContainsByXpath(logoutPopuptopic, "Logout!", " Content ");
		
	}	
	public void verifyLogoutPopupContent() {
		verifyTextContainsByXpath(logoutPopupContent, "Are you sure, you want to logout your account", " Content ");
	    
    }
	
    public void clickLogoutPopupCancelButton() {
	    clickbyXpath(logoutPopupcCancelButton, "Click the Cancel Button In Logout Popup");   
	    
    }
    
    public void clickLogoutPopupOkButton() {
    	clickbyXpath(logoutPopupcOkButton, "Click the Ok Button In Logout Popup");  
    	
    }
    
    public void clickWhiteScreen() {
    	clickbyXpath(whiteScreen, "Click The Enter OTP Page White Screen");    
    
    }
    
    public void verifyNotificationPopupContent() {
		verifyTextContainsByXpath(notificationPopupContent, "Allow ConnectSei to send you notifications?", " Content ");
    	
    }
    
    public void verifyNotificationPopupAllowButtonText() {
    	verifyTextContainsByXpath(notificationPopupAllowButton, "Allow", " Text ");
    	
    }
    
    public void verifyNotificationPopupDontAllowButtonText() {
    	verifyTextContainsByXpath(notificationPopupDontallowButton, "Don't allow", " Text ");
    	
    }
    
    public void clickAllowButton() {
    	clickbyXpath(notificationPopupAllowButton, "Click The Allow Button In Notification Pop-up");    
    	
    }
    
    public void clickDontAllowButton() {
    	clickbyXpath(notificationPopupDontallowButton, "Click The Don't Allow Button In Notification Pop-up");    
    	
    }
}

