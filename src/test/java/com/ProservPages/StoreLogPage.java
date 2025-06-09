package com.ProservPages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;
import com.utils.Reporter;
import com.wrappers.GenericWrappers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;

public class StoreLogPage extends GenericWrappers{

	private AndroidDriver driver;
	public String userName = loadProp("USERNAME");
	public String emaId = loadProp("EMAILID");
	
	
	 public StoreLogPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	 
		@FindBy(xpath = "//*[@resource-id='menu_icon_sharelog']")
		private WebElement shareLogbtn;
		@FindBy(xpath = "//android.widget.TextView[@text='File Manager +']")
		private WebElement FTPicon;
		@FindBy(xpath = "//android.widget.TextView[@text='Downloads']")
		private WebElement FTPDownloads;
		@FindBy(xpath = "//android.widget.TextView[@text='Save']")
		private WebElement FTPsaveBtn;
		@FindBy(xpath = "//*[@resource-id='menu_bar']")
		private WebElement menuBarButton;
		 @FindBy(xpath = "//*[@resource-id='Launch_SignInText']")
		    private WebElement launchSignInButton;
		 @FindBy(xpath = "//*[@resource-id='SignIn_SignInText']")
			private WebElement signInButton;
		 @FindBy(xpath = "//*[@resource-id='SignIn_Email_or_UserName']")
			private WebElement userNameField;
		 @FindBy(xpath = "//android.widget.TextView[@text=\"Support\"]")
		 private WebElement supporticon;
		 
		 @FindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[1]")
			private WebElement otpField1;

			@FindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[2]")
			private WebElement otpField2;
			
			@FindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[3]")
			private WebElement otpField3;
			
			@FindBy(xpath = "(//android.widget.EditText[@resource-id='textInput'])[4]")
			private WebElement otpField4;

			@FindBy(xpath = "//*[@resource-id='OTP_ButtonText']")
			private WebElement submitBtn;
			@FindBy(xpath = "//*[@resource-id='ShareIcon']")
			private WebElement shareIcon;
			@FindBy(xpath = "//*[@resource-id='ShareLogButton']")
			private WebElement sharelogBtn_inside;
			
			@FindBy(xpath = "//*[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")
			private WebElement locationPopUp;

			@FindBy(xpath = "//*[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
			private WebElement nearByPermisson;
		
		public void storeLogToDownloads() {
			
			killAndReopenApp();
			if (isElementDisplayedCheck(shareIcon)) {
				
				clickbyXpath(shareIcon, "share icon");
				clickbyXpath(FTPicon, "Filemanager Button");
				clickbyXpath(FTPDownloads, "Filemanager downloads Button");
				clickbyXpath(FTPsaveBtn, "Filemanager save Button");
			}else if(isElementDisplayedCheck(supporticon)){
				clickbyXpath(supporticon, "supporticon" );
				clickbyXpath(sharelogBtn_inside, "sharelog btn");
				
				clickbyXpath(FTPicon, "Filemanager Button");
				clickbyXpath(FTPDownloads, "Filemanager downloads Button");
				clickbyXpath(FTPsaveBtn, "Filemanager save Button");
				
			}
			
			
		}
		public void takeAppLog() throws FileNotFoundException, IOException, Exception {
			File f= new File(".//service_person.txt");
			if (f.exists()) {
				f.delete();
				}
			Runtime.getRuntime().exec("adb shell rm /storage/emulated/0/Download/*.txt");// to delete all .txt files 
		    storeLogToDownloads();
		    
			String projectRoot = System.getProperty("user.dir");
			Thread.sleep(5000);
			String pullCommand = "adb pull /storage/emulated/0/Download/service_person.txt \"" + projectRoot + "\\service_person.txt\"";
			Runtime.getRuntime().exec(pullCommand);

//		    Runtime.getRuntime().exec("adb pull /storage/emulated/0/Download/sZephyrLOG.txt "+projectRoot+"/sZephyrLOG.txt");
		    if (driver.queryAppState(packages) != ApplicationState.RUNNING_IN_FOREGROUND) {
				driver.activateApp(packages); 
			}
			}
		
		
		
//		protected static String testCaseName;
//		protected static String testDescription;
  
	    
	    
	    
	    String baseRemotePath = loadProp("BASEREMOTEPATH");  // Base FTP directory path
	    String localDirectory =loadProp("LOCALAPPPATH") ;  // Local directory to save file
	    String newFileName = loadProp("NEWFILENAME");  // New file name
	    
	    
	    String server = "192.168.10.34";//192.168.10.34
		int port = 21;
		String user = "qa_usr";
		String pass = "nw9f2hgo@123";
		
		public void CollectLogOnFailure(String testCaseName,String testDescription) throws FileNotFoundException, IOException, Exception {

		
		LocalDateTime now = LocalDateTime.now();

        // Format date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Convert to string and print
        String formattedDateTime = now.format(formatter);
        
		takeAppLog();
		try {
		    
			// FTP server credentials

			// Local log files
			String appLogPath = "./service_person.txt";
//			String deviceLogPath = "./device.log";

			// FTP paths
			String existingDirectory = "/Internal_Project/FULL_VALIDATION_PACKAGES_LOGS/LOGS/2024/Automation_Logs/";
			String newSubDir = testCaseName+" Logs" +formattedDateTime ; // Subdirectory name
			// Initialize FTP connection
			FTPUploader(server, port, user, pass);

			// Create new subdirectory inside the existing directory
			createAndNavigateToSubdirectory(existingDirectory, newSubDir);

			// Upload files to the new subdirectory
			uploadFile(appLogPath, testCaseName + "  AppLog.txt");
//			uploadFile(deviceLogPath, testCaseName + "  DeviceLog.log");

			String remotefilepath = existingDirectory + newSubDir;
			String Filename = "/" + testCaseName + ".txt";
//			Reporter.reportStep(" FTP Path : " + remotefilepath + "<br>" + "Device Log File name:" + Filename, "INFO");

			// Disconnect from FTP server
			disconnect();

		} catch (IOException e) {
			e.printStackTrace();

		}
		}
}
