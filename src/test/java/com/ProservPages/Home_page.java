package com.ProservPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.Reporter;
import com.wrappers.GenericWrappers;

import io.appium.java_client.android.AndroidDriver;

public class Home_page extends GenericWrappers{

	public AndroidDriver driver;
	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String email =loadProp("EMAILID");
	public String Location;
	String Password =loadProp("PASSWORD");
	String Mobilenumber =loadProp("MOBILENUMBER");
	// Locate all elements on the page


	@FindBy(xpath = "//*[@resource-id='toggleSwitch_true']")
	private WebElement onlineToggleSwitch;
	
	@FindBy(xpath = "//*[@resource-id='toggleSwitch_false']")
	private WebElement offlineToggleSwitch;
	
	@FindBy(xpath = "//*[@resource-id='toggleState']")
	private WebElement ToggleState;
	
	@FindBy(xpath = "//*[@resource-id='InterestedButton']")
	private WebElement InterestedButton;
	
	@FindBy(xpath = "//*[@resource-id='no_service_info_text']")
	private WebElement NojobPlaceholder;
	
	@FindBy(xpath = "//*[@resource-id='Interested_text']")
	private WebElement Interested_text;
	
	@FindBy(xpath = "//*[@resource-id='Journey StartedButton']")
	private WebElement JourneyStartedButton;
	
	@FindBy(xpath = "//*[@resource-id='RibbonSmallTagSVGExpired']")
	private WebElement RibbonTag;
	
	@FindBy(xpath = "//*[@resource-id='ContactNumberValue']")
	private WebElement ContactNumberValue;
	
	@FindBy(xpath = "//*[@resource-id='QRCode']")
	private WebElement QRCode;
	
	@FindBy(xpath = "//*[@resource-id='ArrivedText']")
	private WebElement ArrivedText;
	
	@FindBy(xpath = "//*[@resource-id='SummaryTextInput']")
	private WebElement SummaryTextInput;
	
	@FindBy(xpath = "//*[@resource-id='AdditionalInputIG']")
	private WebElement AdditionalInputIG;
	
	@FindBy(xpath = "//*[@resource-id='Generate InvoiceButton']")
	private WebElement GenerateInvoiceButton;
	
	@FindBy(xpath = "//*[@resource-id='Payment ReceivedText']")
	private WebElement PaymentReceivedText;
		
	
	@FindBy(xpath = "//*[@resource-id='available_jobs_title']")
	private WebElement available_jobs_title;
	
	@FindBy(xpath = "//android.widget.Button[@text=\"OFFLINE\"]")
	private WebElement PopupOfflinebtn;
	
	@FindBy(xpath = "//android.widget.Button[@text=\"CANCEL\"]")
	private WebElement PopupCancelbtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Home\"]")
	private WebElement HomeIcon;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"My Order\"]")
	private WebElement MyorderIcon;
	
	private WebElement jobCard(int no) {
		return driver.findElement(By.xpath("//*[@resource-id='JobCard"+no+"']"));
		
	}
	private WebElement jobCardproductname(int no) {
		return driver.findElement(By.xpath("//*[@resource-id='JobCardProductName"+no+"']"));
		
	}
	private WebElement jobCardusername(int no) {
		return driver.findElement(By.xpath("//*[@resource-id='JobCardUserName"+no+"']"));
		
	}
	
	public Home_page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
//		this.wait=new WebDriverWait(driver, 1);

	}
	
	public void checkAvailablejobstitle() {
		verifyTextContainsByXpath(available_jobs_title, "Available Jobs", "Available jobs title");
	}
	public void confirmAvailablejob(String Productname,String Username) {
		for (int i = 0; i < 20; i++) {
			System.out.println("I value :"+i);
			jobCard(i);
			String productname = jobCardproductname(i).getText();
			
			System.out.println("product name"+productname);
			
			if (productname.contains(Productname)) {
				Reporter.reportStep( Productname+"field contains " + Productname+":: Service person desired jobs only displaying ", "PASS");
			}else{
				System.out.println("Moving to next product");
			}
			String username = jobCardusername(i).getText();
			
			System.out.println("username :"+username);
			
			if (username.startsWith(Username)) {
				Reporter.reportStep( Productname+"field contains correct Username: " + Username, "PASS");
				clickbyXpath(jobCardusername(i), "job card");
				clickInterested();
				break;
			}else{
				System.out.println("Moving to next product");
			}
			
//			Reporter.reportStep( Productname+"field not contains " + Productname, "FAIL");
		}
	}
	
	public void checkUsersentjob(String Productname,String Username) {
		for (int i = 0; i < 20; i++) {
			System.out.println("I value :"+i);
			jobCard(i);
			String productname = jobCardproductname(i).getText();
			
			System.out.println("product name"+productname);
			
			if (productname.contains(Productname)) {
				Reporter.reportStep( Productname+"field contains " + Productname+":: Service person desired jobs only displaying ", "PASS");
				
			}else{
				System.out.println("Moving to next product");
			}
			String username = jobCardusername(i).getText();
			
			System.out.println("username :"+username);
			
			if (username.startsWith(Username)) {
				Reporter.reportStep( Productname+"field contains correct Username: " + Username, "PASS");
				break;
			}else{
				System.out.println("Moving to next product");
			}
			
		}
//		Reporter.reportStep( "User sent  jobs  displayed ", "PASS");
	}
	
	public void checkOldLocationJob(String Productname,String Username) {
		for (int i = 0; i < 20; i++) {
			System.out.println("I value :"+i);
//			jobCard(i);
			
			if (isElementDisplayed(NojobPlaceholder, "No job placeholder")) {
				Reporter.reportStep( Productname+" field not contains old location jobs" , "PASS");
				break;
			}else if ( jobCardproductname(i).getText().contains(Productname)&&jobCardusername(i).getText().startsWith(Username)) {
				Reporter.reportStep("location changed still old location job displaying ", "FAIL");
				break;
			}else{
				System.out.println("Moving to next product");
			}
			
		}
		Reporter.reportStep( "Old Location jobs not displayed ", "PASS");
	}
	public void changeOffline() {
		clickbyXpath(onlineToggleSwitch, "Online Toggle switch");
		clickbyXpath(PopupOfflinebtn, "Offline popup button");
	}
	
	public void checkOfflineTogglestate() {

		verifyTextContainsByXpath(ToggleState, "Offline", "Toggle status");
	}
	public void checkNojobPlaceholder() {
		verifyTextContainsByXpath(NojobPlaceholder, "Currently no job for you", "No job placeholder");
	}
	public void changeOnline() {
		clickbyXpath(offlineToggleSwitch, "Offline Toggle switch");
		
	}
	public void clickInterested() {
		scrollToText("Interested");
		
		clickbyXpath(InterestedButton, "Interested button");
	}
	public void clickHomeicon() {
		clickbyXpath(HomeIcon, "Home Icon");
	}
	public void alertokbtn() {
		driver.switchTo().alert().accept();
	}
	public void clickMyordericon() {
		clickbyXpath(MyorderIcon, "My order icon");
	}
	public void clickInterestedText() {
		clickbyXpath(Interested_text, "Interested Text");
	}
	
	public void checkforInterestedOrder(String Productname,String Username) {
		for (int i = 0; i < 20; i++) {
			jobCard(i);
			String productname = jobCardproductname(i).getText();
			
			System.out.println("product name"+productname);
			String username = jobCardusername(i).getText();
			
			System.out.println("username :"+username);
			
			if (productname.contains(Productname)&&username.startsWith(Username)) {
				Reporter.reportStep( Productname+"field contains " + Productname+":: Service person - ("+username+") related jobs only displaying ", "PASS");
				
				break;
			}else{
				System.out.println("Moving to next product");
			}
			
			
			
			
		}
	}
	
	public void clickonJourneyStarted_Acceptedorder(String Productname,String Username) {

		try {
			
		
			for (int i = 0; i < 20; i++) {
				System.out.println("I value :"+i);
				jobCard(i);
				
				if (isElementDisplayedCheck(NojobPlaceholder)) {
					Reporter.reportStep( Productname+" field not contains old location jobs" , "FAIL");
					break;
				}else if ( jobCardproductname(i).getText().contains(Productname)&&jobCardusername(i).getText().startsWith(Username)) {
					Reporter.reportStep("User Accepted job displayed in Accepted order page ", "PASS");
					clickbyXpath(jobCardproductname(i), "Product-"+Productname);
					scrollToText("Journey Started");
					verifyTextContainsByXpath(ContactNumberValue, loadProp("MOBILENUMBER_CONNECTSEI_2"), "Check user Mobile number");
					clickbyXpath(JourneyStartedButton, "Journey Started button");
					clickbyXpath(ArrivedText,"ArrivedText" );
					isElementDisplayedCheck(QRCode);
					break;
				}else{
					System.out.println("Moving to next product");
				}
				
			}
		
		}catch (Exception e) {
			Reporter.reportStep("Something went wrong"+e, "FAIL");
			
		}
	}
	
	public void invoicehandling(String Productname,String Username) {
		try {
			
			
			for (int i = 0; i < 20; i++) {
				System.out.println("I value :"+i);
				jobCard(i);
				
				if (isElementDisplayedCheck(NojobPlaceholder)) {
					Reporter.reportStep( Productname+" field not contains old location jobs" , "FAIL");
					break;
				}else if ( jobCardproductname(i).getText().contains(Productname)&&jobCardusername(i).getText().startsWith(Username)) {
					Reporter.reportStep("User Accepted job displayed in Accepted order page ", "PASS");
					clickbyXpath(jobCardproductname(i), "Product-"+Productname);
					entervaluebyXpath(SummaryTextInput, "SummaryTextInput", "Work has been completed");
					entervaluebyXpath(AdditionalInputIG, "AdditionalInputIG", "100");
					clickbyXpath(GenerateInvoiceButton, "Generate InvoiceButton");
					clickbyXpath(PaymentReceivedText, "Payment ReceivedText");
					break;
				}else{
					System.out.println("Moving to next product");
				}
				
			}
		
		}catch (Exception e) {
			Reporter.reportStep("Something went wrong"+e, "FAIL");
			
		}
	}
}
