package MyRunner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Cucumber-Reports/Cucumber-Report.html"},
	monochrome=true,
	features = {"src/test/java/Features/Contract.feature"},
	//tags = {"@Regression"},
	glue={"stepDefinitions"},	
	dryRun = false,
	strict = true
) 
public class TestRunner {
		
		public static WebDriver driver;
		public static WebDriverWait wait;
		public static ExtentProperties extentProperties;
		public static String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		@AfterClass
		public static void writeExtentReport() throws IOException, InterruptedException {
			
			
			Reporter.loadXMLConfig(new File("Report-config/extent-config.xml"));
			Reporter.setSystemInfo("user", System.getProperty("user.name"));
			Reporter.setSystemInfo("os", "Mac OSX");
			Reporter.setTestRunnerOutput("Sample test runner output message");
			
			
			
			//Thread.sleep(10000);
			
			//Copy cucumber report to seperate folder location
			/*File srcFile = new File(System.getProperty("user.dir")+"/Cucumber-Reports/Cucumber-Report.html");
			String destFile = System.getProperty("user.dir")+"/Cucumber-Reports/" + timeStamp + "_Cucumber-Report/Cucumber-Report.html";
			FileUtils.copyFile(srcFile, new File(destFile));
			Thread.sleep(10000);
			File srcReRunFile = new File(System.getProperty("user.dir")+"/Failed_Scenario_Report/rerun.txt");
			String destReRunFile = System.getProperty("user.dir")+"/Re_Run_Failed_Scenarios_Report/" + timeStamp + "_Re-Run/rerun.txt";
			FileUtils.copyFile(srcReRunFile, new File(destReRunFile));*/
			
		}
		
		@BeforeClass
		public static void initiateExtentReport() throws IOException{
			System.out.println("In Before Class");
			//CommonFunctions.initialize();
			//CommonFunctions.browserLaunch();
			
			extentProperties = ExtentProperties.INSTANCE;
			extentProperties.setReportPath("Cucumber-Reports/Cucumber-Report.html");
		 }	
	}
	
	
	//ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
	//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest
	

