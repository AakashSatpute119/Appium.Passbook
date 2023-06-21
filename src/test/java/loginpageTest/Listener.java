package loginpageTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import resources.CreateDriverSession;
import resources.ExtentReportsclass;
    
public class Listener extends CreateDriverSession implements ITestListener {
	ExtentReports extent = ExtentReportsclass.getExReports();
	ExtentTest test;
	  public static AppiumDriver<MobileElement> driver;
 

	
	@Override
	public void onStart(ITestContext arg0) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		 AppiumDriver<MobileElement> driver=null;
		 String testcasename =arg0.getMethod().getMethodName();
		try {
			driver=(AppiumDriver<MobileElement>)arg0.getTestClass().getRealClass().getDeclaredField("driver").get(arg0.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
			}
		System.out.println(testcasename);
		System.out.println(driver);
		Screenshot(testcasename, driver);
		
	    test.log(Status.INFO, "Screenshot:").addScreenCaptureFromPath("/Users/aakashsatpute/eclipse-workspace/Passbook/screenshots/"+testcasename+".png");
		test.log(Status.FAIL, "Fail");
		
		}
		
	
	

	

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// give report life to each test start 
		 test=extent.createTest(arg0.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// on each test pass log
		test.log(Status.PASS, "Passed");
		// this status will be update in report 
		
	}
	@Override
	public void onFinish(ITestContext arg0) {
		// flush the extent capacity after test folder is completed 
		extent.flush();
	}


}
