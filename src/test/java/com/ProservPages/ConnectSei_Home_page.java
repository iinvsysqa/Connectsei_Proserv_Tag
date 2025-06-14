package com.ProservPages;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.Reporter;
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
	@FindBy(xpath = "//*[@resource-id='SearchServiceText']") 
	private WebElement Connectsei_SearchInput;
	@FindBy(xpath = "//*[@resource-id='PendingButton']") 
	private WebElement PendingButton;
	@FindBy(xpath = "//*[@resource-id='AcceptButton']") 
	private WebElement AcceptButton;
	@FindBy(xpath = "//*[@resource-id='CheckBoxfalse']") 
	private WebElement CheckBoxfalse;
	@FindBy(xpath = "//*[@resource-id='CompleteButton']") 
	private WebElement CompleteButton;
	@FindBy(xpath = "//*[@resource-id='Verify TechnicianTitle']") 
	private WebElement VerifyTechnicianTitle;
	@FindBy(xpath = "//*[@resource-id='Verify TechnicianButton']") 
	private WebElement VerifyTechnicianButton;
	@FindBy(xpath = "//*[@resource-id='ServiceTechnicianCard']") 
	private WebElement ServiceTechnicianCard;
	@FindBy(xpath = "//*[@resource-id='ServicePersonName']") 
	private WebElement ServicePersonName;
	@FindBy(xpath = "//*[@resource-id='Capture QR CodeButton']") 
	private WebElement CaptureQRCodeButton;
	@FindBy(xpath = "//*[@resource-id='HistoryButton']") 
	private WebElement HistoryButton;
	@FindBy(xpath = "//*[@resource-id='GiveRatingText']") 
	private WebElement GiveRatingbtn;
	@FindBy(xpath = "//*[@resource-id='AvailableTechnicianButton']") 
	private WebElement AvailableTechnicianButton;
	@FindBy(xpath = "//*[@resource-id='AcceptedButton']") 
	private WebElement AcceptedButton;
	@FindBy(xpath = "//android.widget.TextView[@text=\"OK\"]")
	private WebElement OkButton;
	@FindBy(xpath = "//android.widget.TextView[@text=\"My Order\"]")
	private WebElement Myorderbtn_homepage;
	@FindBy(xpath = "//android.widget.TextView[@text=\"Invoice Pending\"]")
	private WebElement Invoicepopup;
	@FindBy(xpath = "//android.widget.TextView[@text=\"OK\"]")
	private WebElement OKpopup;
//	@FindBy(xpath = "//*[@resource-id='SlotButton0']") 
//	private WebElement SlotButton0;
	private WebElement jobCard(int no) {
		return driver.findElement(By.xpath("//*[@resource-id='JobCard"+no+"']"));
		
	}
	private WebElement jobCardproductname(int no) {
		return driver.findElement(By.xpath("//*[@resource-id='JobCardProductName"+no+"']"));
		
	}
	private WebElement SlotButton(int no) {
		return driver.findElement(By.xpath("//*[@resource-id='SlotButton"+no+"']"));
		
	}
	private WebElement ProductText(int no) {
		return driver.findElement(By.xpath("//*[@resource-id='ProductText"+no+"']"));
		
	}
	private WebElement ServicePersonName(int no) {
		return driver.findElement(By.xpath("//*[@resource-id='ServivePersonName"+no+"']"));
		
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
		isElementDisplayedCheck(AC_Product);
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
	public void Connectsei_SearchInput() {
		verifyTextContainsByXpath(Connectsei_SearchInput, "Search service here...", "Connectsei search box");
	}
	public void clickonProducttext(int num,String Productname) {
		isElementDisplayedCheck(ProductText(num));
		clickbyXpath(ProductText(num), Productname);
	}
	public void clickMyOrderbutton() {
		clickbyXpath(Myorderbtn_homepage, "My order button");
	}
	public void navigatePendingpage() {
		clickbyXpath(PendingButton, "Pending Button");
	}
	public void checkforPendingOrderstatus(String Productname) {
		try {
		for (int i = 0; i < 20; i++) {
				jobCard(i);
				String productname = jobCardproductname(i).getText();
				
				System.out.println("product name"+productname);
				
				
				if (jobCardproductname(i).getText().contains(Productname)) {
					clickbyXpath(jobCardproductname(i), Productname);
					Reporter.reportStep( Productname+"field contains Service person accepted Product name: " + Productname, "PASS");
					
					break;
				}else{
					System.out.println("Moving to next product");
				}
			}
			}catch (Exception e) {
				Reporter.reportStep("Page not displayed any products", "FAIL");
				
		}
	}
	public void clickAvailableTechnicianButton() {
		clickbyXpath(AvailableTechnicianButton, "AvailableTechnicianButton");
	}
	
	public void checkservicepersonname_and_accept(String name) {
		for (int i = 0; i < 20; i++) {
			if(ServicePersonName(i).getText().startsWith(name)) {
				Reporter.reportStep( "field contains Service person name: " + name, "PASS");
				clickbyXpath(ServicePersonName(i), "navigating to Service person page");
				scrollToText("I agree with the T&C and privacy policy");
				clickbyXpath(CheckBoxfalse, "CheckBoxfalse");
				clickbyXpath(AcceptButton, "Accept button");
				
				break;
			}
		}
	}
	public void verifyTechnician(String Productname) {

		try {
		for (int i = 0; i < 20; i++) {
				jobCard(i);
				String productname = jobCardproductname(i).getText();
				
				System.out.println("product name"+productname);
				
				
				if (jobCardproductname(i).getText().contains(Productname)) {
					clickbyXpath(jobCardproductname(i), Productname);
					Reporter.reportStep( Productname+"field contains Service person accepted Product name: " + Productname, "PASS");
					clickbyXpath(VerifyTechnicianButton, "Verify TechnicianButton");
					verifyTextContainsByXpath(VerifyTechnicianTitle, "Verify Technician", "Verify Technician");
					clickbyXpath(CaptureQRCodeButton, "CaptureQRCodeButton");
					
					break;
				}else{
					System.out.println("Moving to next product");
				}
			}
			}catch (Exception e) {
				Reporter.reportStep("Page not displayed any products", "FAIL");
				
		}
	
	}
	public void clickCompleteBtn() {
		clickbyXpath(CompleteButton, "CompleteButton");
	}
	public void checkInvoice() {
		verifyTextContainsByXpath(Invoicepopup,"Invoice Pending" , "Invoice pop-up");
		clickbyXpath(OKpopup, "Ok popup");
	}
	public void clickHistoryBtn() {
		clickbyXpath(HistoryButton, "HistoryButton");
	}
	public void clickRatingBtn(String Productname,String servicePersonName) {
		try {
			for (int i = 0; i < 20; i++) {
					jobCard(i);
					String productname = jobCardproductname(i).getText();
					
					System.out.println("product name"+productname);
					
					
					if (jobCardproductname(i).getText().contains(Productname)) {
						clickbyXpath(jobCardproductname(i), Productname);
						Reporter.reportStep( Productname+"field contains Service person accepted Product name: " + Productname, "PASS");
						scrollToText("Service Technician Profile");
						clickbyXpath(ServiceTechnicianCard, "ServiceTechnicianCard");
						verifyTextContainsByXpath(ServicePersonName, servicePersonName, "ServicePersonName");
						clickbyXpath(Backbutton, "Backbutton");
						
						clickbyXpath(GiveRatingbtn, "Give Rating Btn");
						taprating();
						tap();
						
						break;
					}else{
						System.out.println("Moving to next product");
					}
				}
				}catch (Exception e) {
					Reporter.reportStep("Page not displayed any products", "FAIL");
					
			}
//		clickbyXpath(, Lastname)
	}
	
	public void taprating() {

		// 1. Get the screen dimensions (this part is the same)
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();

		// 2. Calculate the coordinates for the bottom-center tap
		int tapX = width / 2;
		// Use a value like 90% of the height to safely tap in the bottom region,
		// avoiding the very edge of the screen or the system navigation bar.
		int tapY = (int) (height * 0.50);

		System.out.println("Tapping at bottom-center coordinates: x=" + tapX + ", y=" + tapY);

		// 3. Define the tap action sequence
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1)
		    // Move finger to the target coordinates
		    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), tapX, tapY))
		    // Finger presses down on the screen
		    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		    // Finger lifts up from the screen
		    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// 4. Perform the tap action
		driver.perform(Collections.singletonList(tap));
	
	}
	public void tap() {
		// 1. Get the screen dimensions (this part is the same)
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();

		// 2. Calculate the coordinates for the bottom-center tap
		int tapX = width / 2;
		// Use a value like 90% of the height to safely tap in the bottom region,
		// avoiding the very edge of the screen or the system navigation bar.
		int tapY = (int) (height * 0.90);

		System.out.println("Tapping at bottom-center coordinates: x=" + tapX + ", y=" + tapY);

		// 3. Define the tap action sequence
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1)
		    // Move finger to the target coordinates
		    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), tapX, tapY))
		    // Finger presses down on the screen
		    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		    // Finger lifts up from the screen
		    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// 4. Perform the tap action
		driver.perform(Collections.singletonList(tap));
	}
	public void clickacceptedtab() {
		clickbyXpath(AcceptedButton, "AcceptedTab");
	}
}
