package com.ProservPages;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.Reporter;
import com.wrappers.GenericWrappers;

import io.appium.java_client.android.AndroidDriver;

public class Notification_page extends GenericWrappers{

	public AndroidDriver driver;
//	Register_page rp= new Register_page(driver);
	
	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String email =loadProp("EMAILID");
	String state;
	// Locate all elements on the page

	@FindBy(xpath = "//*[@resource-id='DownArrowSVG']")
	private WebElement AddressDownArrow;
	@FindBy(xpath = "//*[@resource-id='NotificationIconSVG']")
	private WebElement NotificationIcon;
	@FindBy(xpath = "//*[@resource-id='toggleState']")
	private WebElement Togglestate;
	@FindBy(xpath = "//*[@resource-id='toggleSwitch_true']")
	private WebElement ToggleSwitchTrue;
	@FindBy(xpath = "//*[@resource-id='toggleSwitch_false']")
	private WebElement ToggleSwitchFalse;
	@FindBy(xpath = "//*[@resource-id='no_service_info_text']")
	private WebElement NoJobPlaceholder;
	@FindBy(xpath = "//android.widget.TextView[@text=\"My Order\"]")
	private WebElement MyOrderIcon;
	@FindBy(xpath = "//android.widget.TextView[@text=\"Profile\"]")
	private WebElement ProfileIcon;
	@FindBy(xpath = "//android.widget.TextView[@text=\"Support\"]")
	private WebElement SupportIcon;
	@FindBy(xpath = "//android.widget.TextView[@text=\"Home\"]")
	private WebElement HomeIcon;
	@FindBy(xpath = "//*[@resource-id='NotificationTitle']")
	private WebElement NotificationTitle;
	@FindBy(xpath = "//*[@resource-id='EmptyTitle']")
	private WebElement NotificationPlaceholder;
	@FindBy(xpath = "//*[@resource-id='BackIconSVG']")
	private WebElement BackIcon;
	@FindBy(xpath = "//*[@resource-id='Edit AddressTitle']")
	private WebElement EditAddressTitle;
	@FindBy(xpath = "//*[@resource-id='FirstNameButton']")
	private WebElement Home_edittitle;
	@FindBy(xpath = "//*[@resource-id='BackIconSVG']")
	private WebElement Home_officetitle;
	@FindBy(xpath = "//*[@resource-id='My OrderTitle']")
	private WebElement MyOrderTitle;
	@FindBy(xpath = "//*[@resource-id='SomethingWentWrongText']")
	private WebElement somethingWentWrong;
	@FindBy(xpath = "//*[@resource-id='ReloadSVG']")
	private WebElement reloadicon;
	@FindBy(xpath = "//*[@resource-id='EditedAddress']") //Thattanchavady Puducherry Puducherry 605013
	private WebElement Home_address;
	@FindBy(xpath = "//android.widget.Button[@text=\"OFFLINE\"]")
	private WebElement OfflineBtn;
	@FindBy(xpath = "//android.widget.Button[@text=\"CANCEL\"]")
	private WebElement CancelBtn;
	@FindBy(xpath = "//android.widget.Button[@text=\"OK\"]")
	private WebElement OkBtn;
	
	public Notification_page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickNotificationIcon() {
		clickbyXpath(NotificationIcon, "NotificationIcon");
	}
	public void verifyNotificationtitle() {
		verifyTextContainsByXpath(NotificationTitle, "Notification", "NotificationTitle");
	}
	public void verifyNotificationPlaceholder() {
		verifyTextContainsByXpath(NotificationPlaceholder, "No notifications yet","NotificationPlaceholder");
	}
	public void clickbackbutton() {
		clickbyXpath(BackIcon, "Backbutton");
	}
	public void clickAddressarrow() {
		clickbyXpath(AddressDownArrow, "AddressDownArrow");
	}
	public void verifyAddressTitle() {
		verifyTextContainsByXpath(EditAddressTitle, "Edit Address", "Edit Address title");
	}
	
	public void clickMyorderIcon() {
		clickbyXpath(MyOrderIcon, "My order icon");
	}
	public void verifyMyOrderTitle() {
		verifyTextContainsByXpath(MyOrderTitle,"My Order" , "My Order title");
	}
	public void verifyNointernetMsg() {
		verifyTextContainsByXpath(somethingWentWrong,"something went wrong!" , "something went wrong! toast");
	}
	public void clickReloadicon() {
		clickbyXpath(reloadicon, "ReloadIcon");
	}
	public void clickToggleIconON() {
		clickbyXpath(ToggleSwitchTrue, "Toggle Icon On");
	}
	public void clickToggleIconOFF() {
		clickbyXpath(ToggleSwitchFalse, "Toggle Icon Off");
	}
	
	public void checkState() {
		state=Togglestate.getText();
		Reporter.reportStep("Analytics value before Start of the session : " + state, "PASS");
		System.out.println(state);
	}
	
}
