package resources;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ScreenshotState.ScreenshotComparisonError;
import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;




public class CreateDriverSession {
	
			public static Properties prop;
			 public static String url;

	
	public AppiumDriver<MobileElement> IntializeDriver() throws IOException  {
		FileInputStream fs =new FileInputStream("/Users/aakashsatpute/eclipse-workspace/Passbook/src/main/java/resources/data.properties");
	//  create object of properties class to use load method to load the properties file 
			 prop =new Properties();
			 prop.load(fs);
			
    // get the properties from data.property file 
     
         url =prop.getProperty("Baseurl");
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", prop.getProperty("Device")); 
        caps.setCapability("platformVersion", prop.getProperty("platformVersion"));
        caps.setCapability("deviceName", prop.getProperty("deviceName"));
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("chromedriverExecutable", prop.getProperty("driverpath"));
        caps.setCapability("udid", prop.getProperty("udid"));
        caps.setCapability("browserName",prop.getProperty("Browser"));
        //for emulator only 
       // caps.setCapability("avd", "Pixel_3a_API_33_arm64-v8a");
		//caps.setCapability("avdLaunchTimeout", 180000);
        URL appiumServerURL = new URL("http://0.0.0.0:4723/wd/hub");
            
       
        AppiumDriver<MobileElement> driver = new AndroidDriver<>(appiumServerURL, caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        return driver;
	}

	
	   public String Screenshot(String testcasename,AppiumDriver<MobileElement>driver) {
				// Take a screenshot
			    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    String screenshotPath=System.getProperty("user.dir")+"//screenshots//"+testcasename+".png";
			    try {
			    // Copy the screenshot file to a desired location
			   
			    FileHandler.copy(screenshot, new File(screenshotPath));    
		    	} catch (IOException e) {
			    e.printStackTrace();
			    }
		        return screenshotPath;
		 
	   }
	
	
	
	
	
	
	
	
	
	
		
	}
	
	
	
	
	
	
	
	


