package loginpageTest;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageObjects.LoginPage;
import resources.CreateDriverSession;



public class LandingPageTest extends CreateDriverSession {
  public static AppiumDriver<MobileElement> driver;
//  public static ExtentReports extent=ExtentReportsclass.getExReports();
 
  
  
   @org.testng.annotations.Test(priority = 1)
	public void launchURL() throws IOException  {
		driver = IntializeDriver();
		driver.get(url);
		System.out.println("URL sucessfully launched");
		
	}
	
   // verify page title 
	@org.testng.annotations.Test (priority = 2)
	public void ValidatePageTitle(){
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(actualtitle, "पासबुक ");
		}
	
	//Verify Yogoji's Picture 
	@Test(priority =3)
	public void verifyCmUpLogo() {
		LoginPage loginPage=new LoginPage(driver);
	  boolean Image =loginPage.cmUpImage().isDisplayed();
	  assertEquals(Image, true);
	}
	
	
	//Govt logo is displayed 
	@Test (priority = 4)
	public void verifyGovtLogoIsdisplay() {
	driver.get(url);
	LoginPage loginPage=new LoginPage(driver);
	boolean logo=loginPage.govtLogo().isDisplayed();
	Assert.assertEquals(logo, true);
	
	}
	
	//familyid picture
	@Test (priority = 5)
	public void familyIdImage() {
		LoginPage loginPage=new LoginPage(driver);
		boolean familyIdImage=loginPage.familyIdImage().isDisplayed();
		Assert.assertEquals(familyIdImage, true);
	}
	
	
	
	// click here for register link is working
//		@Test 
//		public void verifyForRegisterClickHere() throws InterruptedException {
//			LoginPage loginPage=new LoginPage(driver);
//			loginPage.clickhere().click();
//			Thread.sleep(3000);
//			String currenturl=driver.getCurrentUrl();
//			Assert.assertEquals(currenturl, "https://familyid.up.gov.in/portal/index.html");
//		}
//	
	@Test  
	public void Loginwithaadhar () throws InterruptedException {
//		LoginPage loginPage =new LoginPage(driver);
//		loginPage.AadharInput().sendKeys("246877289087");
//		loginPage.LoginButton().click();
////	    WebDriverWait wait = new WebDriverWait(driver,30);
////	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[3]/div/button")));
//	    loginPage.popupaccept();
//		Scanner scanner=new Scanner(System.in);
//		System.out.println("Please enter 6 digit otp");
//		String otp=scanner.nextLine();
//	    loginPage.enterOtp().sendKeys(otp);
//	    loginPage.submitotpbutton().click();
//	    loginPage.popupaccept().click();
	    
	
	}
	@AfterClass
	public void closesession() {
	driver.close();	
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
