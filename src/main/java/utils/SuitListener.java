package utils;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.IListenersAnnotation;
import org.testng.annotations.ITestAnnotation;

import base.BaseTest;
public class SuitListener implements ITestListener,IAnnotationTransformer{

	public void onTestFailure(ITestResult result) {
		Date currentdate= new Date();
		//System.out.println(currentdate);
		String screenshotfileName=currentdate.toString().replace("", "-").replace(":","-");
		 File f=((TakesScreenshot)BaseTest.webdriver).getScreenshotAs(OutputType.FILE);
		    try {
				FileUtils.copyFile(f, new File(".//screenshots//"+screenshotfileName+".png"));
			}
		    catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
		
	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
		
	}

		
	

}
