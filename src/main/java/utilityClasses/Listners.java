package utilityClasses;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.google.common.io.Files;

public class Listners implements ITestListener,IAnnotationTransformer {
	
	WebDriver driver;

	public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
	
		iTestAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		/*
		 * "user.dir" it returns current directory of our working project structure.
		 */
		String fileName=System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)driver;
	File src=	ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(fileName+".png");
	try {
		Files.copy(src, dest);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	
	
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
		
}
