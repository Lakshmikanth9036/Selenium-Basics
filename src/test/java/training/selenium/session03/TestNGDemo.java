package training.selenium.session03;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {

	@BeforeMethod
	public void setup(){
		System.out.println("Initial Driver Setup");
	}
	
	@Test(priority=2)
	public void login(){
		Assert.assertTrue(false);
		System.out.println("Login Form Testing");
	}
	
	@Test(priority=1)
	public void register(){
		System.out.println("Registration Form Testing");
	}
	
	@Test(dependsOnMethods="login")
	public void changePassword(){
		System.out.println("Change Password Testing");
	}
	
	@AfterMethod
	public void tearDown(){
		System.out.println("Close the browser window");
	}
}
