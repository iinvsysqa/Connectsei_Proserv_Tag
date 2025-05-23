package com.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ProservPages.Login_Page;
import com.ProservPages.Register_page;
import com.wrappers.MobileAppWrappers;

public class TC_02_Login extends MobileAppWrappers{

	Login_Page loginpage;
	Register_page registerpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC01_Login";
		testDescription = "Try to login with username";
	}
	
	String username =loadProp("USERNAME");
	String Lastname =loadProp("LASTNAME");
	String Password =loadProp("PASSWORD");
	String Mobilenumber =loadProp("MOBILENUMBER");
	
	
	@Test(priority = 0)
	public void removerepair() throws Exception {
		initAndriodDriver();
		loginpage= new Login_Page(driver);
		registerpage = new Register_page(driver);
		
		try {
			
			uninstall_reinstall();
			loginpage.enterMobileno(randomnumbers(10));
			loginpage.enterPassword("User"+"@#"+randomnumbers(3));
			loginpage.clickLogin();
			loginpage.checkMobilenoToast();
			
			loginpage.enterMobileno(Mobilenumber);
			loginpage.enterPassword(Password);
			loginpage.clickLogin();
			loginpage.checkOKbtuton();
			registerpage.checknotificationbutton();;
			
			
		
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
