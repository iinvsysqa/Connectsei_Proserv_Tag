package com.Connectsei_Pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import com.wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {


	private AndroidDriver driver;
	
	@FindBy(xpath = "//*[@resource-id='NotificationSVG']")
	private WebElement notificationIcon;
	
	@FindBy(xpath = "//*[@resource-id='BackIconSVG']")
	private WebElement notificationPageBackButton;
	
	@FindBy(xpath = "//*[@resource-id='NotificationTitle']")
	private WebElement notificationPageTitle;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"No notifications yet\"]")
	private WebElement noNotificationYet;
	
	@FindBy(xpath = "//*[@resource-id='NoNotificationInfo']")
	private WebElement noNotificationContent;
	
	@FindBy(xpath = "//*[@resource-id='SearchInput']")
	private WebElement searchbox;
	
	@FindBy(xpath = "//com.horcrux.svg.CircleView")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"My Order\"]")
	private WebElement myOrderButton;
	
	@FindBy(xpath = "//*[@resource-id='BackIconSVG']")
	private WebElement myOrderPageBackButton;
	
	@FindBy(xpath = "//*[@resource-id='AcceptedButton']")
	private WebElement acceptedButton;
	
	@FindBy(xpath = "//*[@resource-id='PendingButton']")
	private WebElement pendingButton;
	
	@FindBy(xpath = "//*[@resource-id='HistoryButton']")
	private WebElement historyButton;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
	private WebElement tryAgainButton;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
	private WebElement whiteScreen;
	
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
//	
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
//	
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
//	
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
//	
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
//	
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
//	
//	@FindBy(xpath = "//*[@resource-id='']")
//	private WebElement ;
	
	// Constructor to initialize the driver and instantiate elements using

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver, 30);
	}

	// Methods to be used as part of loginpage.
	
	
	public void clickNotificationIcon() {
		clickbyXpath(notificationIcon, " Click the Notification Icon ");
	}
	
	public void clickNotificationPageBackButton() {
		clickbyXpath(notificationPageBackButton, " Click the Notification Page Back Button ");
	}
	
	public void clickAndScrollThePage() {
		scrollToText("No notifications yet");
	}
	
	public void verifyNotificationTitle() {
		verifyTextContainsByXpath(notificationPageTitle, "Notification", " Title ");	
	}
	
	public void verifyNoNotificationYet() {
		verifyTextContainsByXpath(noNotificationYet, "No notifications yet", "Bold Text");	
	}
	
	public void verifyNotificationPageContent() {
		verifyTextContainsByXpath(noNotificationContent, "Stay tuned! We’ll keep you informed about your orders and support messages.", "No Notification Content");	
	}
	
	public void clickSearchButton() {
		clickbyXpath(searchbox, " Click the Search Box");
	}
	
	public void enterSearchData(String SearchData) {
		entervaluebyXpath(searchbox, "Type The Search Data" , SearchData);	
	}
	
	public void clickcancelButton() {
		clickbyXpath(cancelButton, " Click Cancel Button To Remove The Data");
	}
	
	public void clickMyOrderButton() {
		clickbyXpath(myOrderButton, " Click the Home Page My Order Button");
	}
	
	public void clickMyOrderPageBackButton() {
		clickbyXpath(myOrderPageBackButton, " Click the My Order Page Back Button");
	}
	
	public void clickAcceptedButton() {
		clickbyXpath(acceptedButton, " Click the Accepted Button");
	}
	
	public void clickPendingButton() {
		clickbyXpath(pendingButton, " Click the Pending Button");
	}
	
	public void clickHistoryButton() {
		clickbyXpath(historyButton, " Click the History Button");
	}
	
	public void clickTryAgainButton() {
		clickbyXpath(tryAgainButton, " Click the Try Again Button");
	}
	
	public void clickSearchPageWhiteScreen() {
		clickbyXpath(whiteScreen, " Click the Search Page White Screen");
	}
}