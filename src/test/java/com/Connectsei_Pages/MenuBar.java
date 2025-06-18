package com.Connectsei_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import com.wrappers.GenericWrappers;

public class MenuBar extends GenericWrappers {
	private AndroidDriver driver;
	
	
	// Locate all elements on the page
	
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
	private WebElement menuBar;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]")
	private WebElement menuLogout;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
	private WebElement cancel;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement logout;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(xpath = "")
//	private WebElement ;
	
//	@FindBy(xpath = "")
//	private WebElement ;
	
	
	// Constructor to initialize the driver and instantiate elements using
	
			public MenuBar(AndroidDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
	// Methods to be used as part of menuBarpage.
	
		public void clickMenuBar() {
			clickbyXpath(menuBar, " Click the Menubar Button ");

		}		
		
		public void clickMenuLogout() {
			clickbyXpath(menuLogout, " Click the Logout Button ");
			
		}	
		
		public void clickCancel() {
			clickbyXpath(cancel, " Click The Cancel Button In Logout Alert PopUp");
			
		}	
		
		public void clickLogout() {
			clickbyXpath(logout, " Click The Logout Button In Logout Alert PopUp");
			
		}

			
		}

