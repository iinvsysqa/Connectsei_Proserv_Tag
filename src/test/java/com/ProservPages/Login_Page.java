package com.ProservPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;
import com.wrappers.GenericWrappers;

import io.appium.java_client.android.AndroidDriver;

public class Login_Page extends GenericWrappers{

	public AndroidDriver driver;

	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String Password =loadProp("PASSWORD");
	String Mobilenumber =loadProp("MOBILENUMBER");
	// Locate all elements on the page

	@FindBy(xpath = "//*[@resource-id='mobile_numberInput']")
	private WebElement  Mobilenumberfield;
	@FindBy(xpath = "//*[@resource-id='passwordInput']")
	private WebElement  passwordInputfield;
	@FindBy(xpath = "//*[@resource-id='LoginText']")
	private WebElement  LoginTextfield;
	@FindBy(xpath = "//*[@resource-id='forgot_password']")
	private WebElement  forgot_passwordfield;
	@FindBy(xpath = "//android.widget.Toast[@text=\"Mobile number does not exist\"]")
	private WebElement  mobilenumberToast;
	@FindBy(xpath = "//*[@resource-id='Forgot PasswordTitle']")
	private WebElement  forgot_passwordtitle;
	@FindBy(xpath = "//*[@resource-id='Get OTPText']")
	private WebElement  GetOTPbtn;
	@FindBy(xpath = "//*[@resource-id='mobile_numberError']")
	private WebElement  mobileNoErr;
	@FindBy(xpath = "//*[@resource-id='Reset PasswordTitle']")
	private WebElement  resetPasswordTtile;
	@FindBy(xpath = "//*[@resource-id='confirmPasswordInput']")
	private WebElement confirmPasswordfield;
	@FindBy(xpath = "//*[@resource-id='LogoutText']")
	private WebElement Logouttext;
	@FindBy(xpath = "//*[@resource-id='My ProfileTitle']")
	private WebElement Myprofiletitle;
	@FindBy(xpath = "//android.widget.Toast[@text=\"Logout successfully\"]")
	private WebElement LogoutToast;
	@FindBy(xpath = "//*[@resource-id='AdvertisementSVG']")
	private WebElement Advertisement;
	@FindBy(xpath = "//android.widget.Button[@text=\"OK\"]")
	private WebElement OkBtn;
	@FindBy(xpath = "//*[@resource-id='Status_text']") 
	private WebElement HomepageStatustext;
	
	//android.widget.Toast[@text="You have 3 remaining attempt(s)"]
	
//	@FindBy(xpath = "//*[@resource-id='Enter OTPTitle']")
//	private WebElement  OTPtitle;
//	@FindBy(xpath = "//*[@resource-id='otp_input_0']")
//	private WebElement OTP1;
//	@FindBy(xpath = "//*[@resource-id='otp_input_1']")
//	private WebElement OTP2;
//	@FindBy(xpath = "//*[@resource-id='otp_input_2']")
//	private WebElement OTP3;
//	@FindBy(xpath = "//*[@resource-id='otp_input_3']")
//	private WebElement OTP4;
//	@FindBy(xpath = "//*[@resource-id='resendtext']")
//	private WebElement resendtext;
//	@FindBy(xpath = "//*[@resource-id='Confirm OTPText']")
//	private WebElement Confirm_OTPText;
	
	
	
	public Login_Page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
//		this.wait=new WebDriverWait(driver, 1);

	}
	
	
	public void uninstall_reinstall() throws Exception {
		Properties prop =new Properties();
		prop.load(new FileInputStream(new File("./config.properties")));
		
		if (driver.isAppInstalled(packages)) {
		Runtime.getRuntime().exec("adb uninstall com.iinvsys.connectsei_proserv_2");
		driver.installApp(prop.getProperty("APP_PATH"));
		driver.activateApp(packages);
		Runtime.getRuntime().exec("adb shell pm grant com.iinvsys.connectsei_proserv_2 android.permission.ACCESS_FINE_LOCATION");
		Runtime.getRuntime().exec("adb shell pm grant com.iinvsys.connectsei_proserv_2 android.permission.BLUETOOTH_SCAN");
		Runtime.getRuntime().exec("adb shell pm grant com.iinvsys.connectsei_proserv_2 android.permission.BLUETOOTH_CONNECT");
		Runtime.getRuntime().exec("adb shell pm grant com.iinvsys.connectsei_proserv_2 android.permission.CAMERA");
		Runtime.getRuntime().exec("adb shell pm grant com.iinvsys.connectsei_proserv_2 android.permission.POST_NOTIFICATIONS");
		}
		else {
			
			driver.installApp(prop.getProperty("APP_PATH"));
			driver.activateApp(packages);
			Runtime.getRuntime().exec("adb shell pm grant com.iinvsys.connectsei_proserv_2 android.permission.ACCESS_FINE_LOCATION");
			Runtime.getRuntime().exec("adb shell pm grant com.iinvsys.connectsei_proserv_2 android.permission.BLUETOOTH_SCAN");
			Runtime.getRuntime().exec("adb shell pm grant com.iinvsys.connectsei_proserv_2 android.permission.BLUETOOTH_CONNECT");
			Runtime.getRuntime().exec("adb shell pm grant com.iinvsys.connectsei_proserv_2 android.permission.CAMERA");
			Runtime.getRuntime().exec("adb shell pm grant com.iinvsys.connectsei_proserv_2 android.permission.POST_NOTIFICATIONS");
		}
	}
	
	public void enterMobileno(String mobilenumber) {
		isElementDisplayedCheck(Mobilenumberfield);
		entervaluebyXpath(Mobilenumberfield, "Mobilenumber field", mobilenumber);
	}
	public void enterPassword(String password) {
		entervaluebyXpath(passwordInputfield, "Password field", password);

	}
	public void clickLogin() {
		clickbyXpath(LoginTextfield, "Login field");
	}
	public void checkMobilenoToast() {
//		verifyDynamicContentByXpath("//android.widget.Toast[@text=\"radius updated successfully\"]","radius updated successfully" , "Radius updated Toast");
		verifyTextContainsByXpath(mobilenumberToast, "Mobile number does not exist", "Mobile no toast");
	}
	
	public void Clickforgetpasswordlink() {
		clickbyXpath(forgot_passwordfield, "ForgetPassword");
	}
	 public void verifyResetPasswordtitle() {
		 verifyTextContainsByXpath(resetPasswordTtile, "Reset Password", "Resetpassword");
	}
	public void enterConfirmPassword(String password) {
		entervaluebyXpath(confirmPasswordfield, "Confirm Password field",password );
	}
	
	public void clickGetOTPbtn() {
		clickbyXpath(GetOTPbtn, "Get OTP button");
	}
	public void clickLogoutbtn() {
		clickbyXpath(Logouttext, "click Logout");
	}
	
	public void turnOnWifi() throws Exception {

		try {
			Runtime.getRuntime().exec("adb shell svc wifi enable");
			Thread.sleep(3000);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void turnOffWifi() {

		try {
			Runtime.getRuntime().exec("adb shell svc wifi disable");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void verifyMyProfiletitle() {
		verifyTextContainsByXpath(Myprofiletitle, "My Profile", "My profile title");
	}
	public void verifyLogoutToast() {
		verifyTextContainsByXpath(LogoutToast, "Logout successfully", "Logout successfully Toast");
	}
	public void checkHomepageAdvertisement() {
		isElementDisplayed(Advertisement, "Profile Page advertisement");
	}
	
	public void checkOKbtuton() {
		isElementDisplayedCheck(OkBtn);
		clickbyXpathwithoutReport(OkBtn, "OKbutton");
	}
	  public void checknotificationbutton() {
		  verifyTextContainsByXpath(HomepageStatustext, "Status:", "Home page Status text") ;
	}
	public void login(String mobilenumber,String Password) {
		enterMobileno(mobilenumber);
		enterPassword(Password);
		clickLogin();
		checkOKbtuton();
//		checknotificationbutton();
	}
}
