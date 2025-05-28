package com.ProservPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wrappers.GenericWrappers;

import io.appium.java_client.android.AndroidDriver;

public class ConnectSei_Home_page extends GenericWrappers{

	public ConnectSei_Home_page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public AndroidDriver driver;
//	Register_page rp= new Register_page(driver);
	
	String username =loadProp("USERNAME_CONNECTSEI_2");
	String Lastname =loadProp("USERNAME_CONNECTSEI_2");
//	String email =loadProp("EMAILID");
	String mobilenumber=loadProp("MOBILENUMBER_CONNECTSEI_2");
	
	@FindBy(xpath = "//*[@resource-id='ProductText0']") 
	private WebElement AC_Product;
	@FindBy(xpath = "//*[@resource-id='AC RepairTitle']") 
	private WebElement ACrepairtitle;
	@FindBy(xpath = "//*[@resource-id='BackIconSVG']") 
	private WebElement Backbutton;
	@FindBy(xpath = "//*[@resource-id='DescriptionInput']") 
	private WebElement DescriptionInput;
	@FindBy(xpath = "//*[@resource-id='DateButton0']") 
	private WebElement DateButton0;
	@FindBy(xpath = "//*[@resource-id='SlotButton11']") 
	private WebElement SlotButton11;
	
	
	
}
