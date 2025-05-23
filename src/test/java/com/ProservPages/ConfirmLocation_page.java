package com.ProservPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wrappers.GenericWrappers;

import io.appium.java_client.android.AndroidDriver;

public class ConfirmLocation_page extends GenericWrappers{

	public AndroidDriver driver;
	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String email =loadProp("EMAILID");
	
	// Locate all elements on the page

	@FindBy(xpath = "//*[@resource-id='LocationPinIcon']")
	private WebElement LocationPinIcon;
	@FindBy(xpath = "//*[@resource-id='useCurrentLocationButton']")
	private WebElement useCurrentLocationButton;
	@FindBy(xpath = "//*[@resource-id='address_text']")
	private WebElement ConfirmLocation_address_text;
//	@FindBy(xpath = "//*[@resource-id='LocationPinIcon']")
//	private WebElement LocationPinIcon;
//	@FindBy(xpath = "//*[@resource-id='LocationPinIcon']")
//	private WebElement LocationPinIcon;
	
	
}
