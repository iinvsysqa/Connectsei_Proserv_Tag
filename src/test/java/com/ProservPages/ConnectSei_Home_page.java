package com.ProservPages;

import java.util.Iterator;

import org.openqa.selenium.By;
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
	@FindBy(xpath = "//*[@resource-id='NextButton']") 
	private WebElement Nextbutton;
	@FindBy(xpath = "//*[@resource-id='Book NowText']") 
	private WebElement Book_NowText;
	@FindBy(xpath = "//android.widget.TextView[@text=\"OK\"]")
	private WebElement OkButton;
//	@FindBy(xpath = "//*[@resource-id='SlotButton0']") 
//	private WebElement SlotButton0;
	private WebElement SlotButton(int no) {
		return driver.findElement(By.xpath("//*[@resource-id='SlotButton"+no+"']"));
		
	}
	
	
	public void clickonSlotbutton() {
		String slotvalue=null;
		for (int i = 0; i < 12; i++) {
			
			slotvalue = SlotButton(i).getAttribute("enabled");
			if (slotvalue.contains("true")) {
				SlotButton(i).click();
				break;
			}
		}
		if (slotvalue.equals("true")) {
			
			System.out.println("slot booked ");
		}else {
			
			System.out.println("No slot are available");
		}
	}
	
	public void clickonDatebutton() {
		clickbyXpath(DateButton0, "Date button");
	}
	public void clickNextbutton() {
		clickbyXpath(Nextbutton, "Next button");
	}
	public void clickACproduct() {
		clickbyXpath(AC_Product, "AC product");
	}
	public void addDescription() {
		entervaluebyXpath(DescriptionInput, "AC Repair Description", "Issue on Compressor");
	}
	public void clickBooknow() {
		clickbyXpath(Book_NowText, "Book now ");
	}
	public void clickPop_upOk() {
		clickbyXpath(OkButton, "Pop-UP ok button");
	}
}
