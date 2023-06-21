package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import resources.CreateDriverSession;


public class LoginPage extends CreateDriverSession{

      AppiumDriver<MobileElement> driver;
	
	    public LoginPage(AppiumDriver<MobileElement> driver) {
	    	this.driver=driver;
	    PageFactory.initElements(driver, this);
	    
	    }
        //Aadhar input field 
		@FindBy(xpath ="/html/body/div[1]/div/div[3]/input")
	     WebElement Aadharnumber;
	    public WebElement AadharInput () {
			return Aadharnumber;
		}
	    
	    // Login button
	    @FindBy (xpath = "/html/body/div[1]/div/div[4]/button")
        WebElement loginbuttonElement;
	    public WebElement LoginButton() {
	    	return loginbuttonElement;
	    }
	    // otp input field 
	    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div/input[1]")
	    WebElement inputotpElement;
	    public WebElement enterOtp() {
	    	return inputotpElement;
	    }
	    
	    // otp submit button 
	    @FindBy (xpath = "//*[@id=\"__next\"]/div/div[4]/button")
	    WebElement submitoptElement;
	    public WebElement submitotpbutton() {
	    	return submitoptElement;
	    }
	    
	    
	    // okay popup
	    @FindBy(css ="button.swal-button.swal-button--confirm")
	    WebElement popupbutton;
	    public WebElement popupaccept() {
	    	return popupbutton;
	    }
	    
	    //not register click here to register 
	   @FindBy (xpath = "//a[@target='blank']")
        WebElement clickherElement;
	   public WebElement clickhere() {
		   return clickherElement;
	   }
	   
	   // govt logo
	   @FindBy (xpath = "//img[@alt='govtLogo']")
	   WebElement govtlogoElement ;
	   public WebElement govtLogo() {
		   return govtlogoElement;
	   }
	    
	   //cm up
	   @FindBy(xpath = "//*[@id=\"cm_up\"]") WebElement cmup;
	   public WebElement cmUpImage() {
		   return cmup;
	   }
	   //family id logo 
	   @FindBy(xpath ="//*[@id=\"__next\"]/div/div[2]/img" )
	   WebElement familyidimagElement;
	   public WebElement familyIdImage() {
		   return familyidimagElement;
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   }
	    
	    
	    
	    
	    
	    
	    
	    
	  
	    
	







	

	
	
	
	
	

