package com.ProservPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

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
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Zoom out\"]")
	private WebElement zoomOutBtn;
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
//		clickbyXpath(GooglemapSearchInput,"searchbox");
//		entervaluebyXpath(GooglemapSearchInput, "Google map search input", "Thindivanam, Tamil Nadu");
		clickbyXpath(zoomOutBtn, "Zoom out btn");
		clickbyXpath(zoomOutBtn, "Zoom out btn");
		clickbyXpath(zoomOutBtn, "Zoom out btn");
		clickbyXpath(zoomOutBtn, "Zoom out btn");
		clickbyXpath(zoomOutBtn, "Zoom out btn");
		clickbyXpath(zoomOutBtn, "Zoom out btn");
	}
	public void useCurrentLocation() {
		clickbyXpath(currentLocation_Text, "currentLocation_Text");
	}
	
	public void swipedown() {

	    int width = driver.manage().window().getSize().getWidth();
	    int height = driver.manage().window().getSize().getHeight();

	    int startX = width / 2;
	    int startY = (int) (height * 0.40); // Start from top 20%
	    int endY = (int) (height * 0.80);   // Swipe down to 80%

	    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence swipe = new Sequence(finger, 0)
	        .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
	        .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY))
	        .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    driver.perform(Collections.singletonList(swipe));
	
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
	
	public void swipeup() {

		
		    int width = driver.manage().window().getSize().getWidth();
		    int height = driver.manage().window().getSize().getHeight();

		    int centerX = width / 2;
		    int startY = (int) (height * 0.5);  // Start from 80% (bottom)
		    int endY = (int) (height * 0.2);    // Swipe up to 20% (top)

		    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		    Sequence swipe = new Sequence(finger, 0)
		        .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY))
		        .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), centerX, endY))
		        .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		    driver.perform(Collections.singletonList(swipe));
		
	}
}
