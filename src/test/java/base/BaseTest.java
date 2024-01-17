package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
import utils.Links;

public class BaseTest {

	public static  WebDriver webdriver;
	protected HomePage homepage;
	ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;
	public ExtentTest logger;
	@BeforeSuite
	public void InitialiseExtentReports() {
		//htmlReporter = new ExtentHtmlReporter("extent.html");
		sparkReporter = new ExtentSparkReporter("SparkReports.html");

		// create ExtentReports and attach reporter(s)

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Arts Automation Report");
		sparkReporter.config().setReportName("Automation Test Results by Arts");
		extentReports.setSystemInfo("OS",System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));

	}




	@BeforeTest
	@Parameters("browserName")
	public void beforeMethodMethod(String browserName) {


		setupDriver(browserName);
		webdriver.manage().window().maximize();
		webdriver.get(Links.baseUrl);

		homepage= new HomePage(webdriver);


	}



	@AfterMethod
	public void checkStatus(ITestResult result) {
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extentReports.createTest("Login Test", "Sample description");

		if(result.getStatus()==ITestResult.FAILURE){
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"-Test Case Failed",ExtentColor.RED));
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+"-Test Case Failed",ExtentColor.RED ));
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"-Test Case Skipped",ExtentColor.ORANGE));
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			logger.log(Status.PASS,MarkupHelper.createLabel(result.getName()+"-Test Case Passed",ExtentColor.GREEN));

		}
		



	}




	@AfterSuite
	public void generateExtentReports() {
		// calling flush writes everything to the log file
		extentReports.flush();
		


	}
	@AfterTest
	public void tearDown() {
		
		webdriver.quit();
		
	}

	public void setupDriver(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			webdriver=new ChromeDriver();


		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			webdriver=new EdgeDriver();
		}

		else {
			WebDriverManager.firefoxdriver().setup();
			webdriver=new FirefoxDriver();

		}

	}



}
