package com.Connectsei_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import com.wrappers.GenericWrappers;

public class ForgotPasswordPage extends GenericWrappers{
	
	private AndroidDriver driver;

	// Locate all elements on the page
	@FindBy(xpath = "//*[@resource-id='forgot_password']")
	private WebElement forgotPasswordButton;
	
	@FindBy(xpath = "//*[@resource-id='Forgot PasswordTitle']")
	private WebElement forgotPasswordPageTitle;
	
	@FindBy(xpath = "//*[@resource-id='reset_password_info_text']")
	private WebElement forgotPasswordPageContent;
	
	@FindBy(xpath = "//*[@resource-id='mobile_numberInput']")
	private WebElement mobileNoField;
	
	@FindBy(xpath = "//*[@resource-id='SubmitButton']")
	private WebElement forgotSubmitButton;
	
	@FindBy(xpath = "//*[@resource-id='Reset PasswordTitle']")
	private WebElement resetPasswordPageTitle;
	
	@FindBy(xpath = "//*[@resource-id='reset_pass_info']")
	private WebElement resetPasswordPageContent;
	
	@FindBy(xpath = "//*[@resource-id='passwordInput']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//*[@resource-id='confirmPasswordInput']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath = "//*[@resource-id='EyeOpenSVG']")
	private WebElement eyeIcon;
	
	@FindBy(xpath = "//*[@resource-id='SubmitButton']")
	private WebElement submitButton;
	
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
//	
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;


//Constructor to initialize the driver and instantiate elements using

	public ForgotPasswordPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver, 30);
	}

	// Methods to be used as part of loginpage.
	
	public void clickForgotPasswordButton() {
		clickbyXpath(forgotPasswordButton, " Click the Forgot Password Button ");
		
	}	
	public void verifyForgotPasswordPageTitle() {
		verifyTextContainsByXpath(forgotPasswordPageTitle, "Forgot Password", " The Title ");
		
	}	
	public void verifyForgotPasswordPageContent() {
		verifyTextContainsByXpath(forgotPasswordPageContent, "Enter the registered mobile number for password change", " The Content ");
		
	}	
	public void enterMobileNo(String Mobile) {
		entervaluebyXpath(mobileNoField, "Enter The Mobile No" , Mobile);
		
	}	
	public void clickForgotSubmitButton() {
		clickbyXpath(forgotSubmitButton, "Click the Forgot Password Page Submit Button");
		
	}	
	public void verifyResetPasswordPageTitle() {
		verifyTextContainsByXpath(resetPasswordPageTitle, "Reset Password", " The Title ");
		
	}	
	public void verifyResetPasswordPageContent() {
		verifyTextContainsByXpath(resetPasswordPageContent, "Create a new password for your account", " The Content ");
		
	}	
	public void enterPassword(String Password) {
		entervaluebyXpath(passwordField, "Enter The Password" , Password);
		
	}	
	public void enterConfirmPassword(String ConfirmPassword) {
		entervaluebyXpath(confirmPasswordField, "Enter The Confirm Password" , ConfirmPassword);
		
	}	
	public void clickEyeIcon() {
		clickbyXpath(eyeIcon, "Click the Eye Icon Button");
		
	}
	public void clickSubmitButton() {
		clickbyXpath(submitButton, "Click the Submit Button");
		
	}
		
}
