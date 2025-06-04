package com.ProservPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import com.wrappers.GenericWrappers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Serviceareazone_page  extends GenericWrappers{
	
	public Serviceareazone_page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
//		this.wait=new WebDriverWait(driver, 1);

	}

	public AndroidDriver driver;
	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String email =loadProp("EMAILID");
	public String Location;
	String Password =loadProp("PASSWORD");
	String Mobilenumber =loadProp("MOBILENUMBER");
	// Locate all elements on the page


	@FindBy(xpath = "//*[@resource-id='Change_button_text']")
	private WebElement LocationchangeBtn;
	@FindBy(xpath = "//*[@resource-id='GooglemapSearchInput']")
	private WebElement GooglemapSearchInput;
	@FindBy(xpath = "//*[@resource-id='GooglemapSearch']")
	private WebElement GooglemapSearch;
	@FindBy(xpath = "//*[@resource-id='currentLocation_Text']")
	private WebElement currentLocation_Text;
//	@FindBy(xpath = "//*[@resource-id='Change_button_text']")
//	private WebElement LocationchangeBtn;
//	@FindBy(xpath = "//*[@resource-id='Change_button_text']")
//	private WebElement LocationchangeBtn;
//	@FindBy(xpath = "//*[@resource-id='Change_button_text']")
//	private WebElement LocationchangeBtn;
//	@FindBy(xpath = "//*[@resource-id='Change_button_text']")
//	private WebElement LocationchangeBtn;
//	@FindBy(xpath = "//*[@resource-id='Change_button_text']")
//	private WebElement LocationchangeBtn;
//	@FindBy(xpath = "//*[@resource-id='Change_button_text']")
//	private WebElement LocationchangeBtn;
	
	public void clickLocationchnageButton() {
		clickbyXpath(LocationchangeBtn, "Location change button");
	}
	public void enteranotherLocation() {
		entervaluebyXpath(GooglemapSearchInput, "Google map search input", "Thindivanam, Tamil Nadu, India");
		clickbyXpath(GooglemapSearch, "Google map search ");
	}
	public void useCurrentLocation() {
		clickbyXpath(currentLocation_Text, "currentLocation_Text");
	}
	
	public void swipedown() {

		   Dimension size = driver.manage().window().getSize();
		    int startX = size.width / 2;
		    int startY = (int) (size.height * 0.80);
		    int endY   = (int) (size.height * 0.20);

		    new TouchAction(driver)
		        .press(PointOption.point(startX, startY))
		        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		        .moveTo(PointOption.point(startX, endY))
		        .release()
		        .perform();
	}
}
