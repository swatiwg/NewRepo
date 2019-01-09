package utillities;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.standardchartered.genie.model.GenieScenario;

public class BaseTestSetup {

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    private static Logger Log = LogManager.getLogger(BaseTestSetup.class.getName());
    public static GenieScenario genieScenario;

    public static String applicationURL = SetupPropertiesLoader.getProperty("url", "directory.properties");
    
    private enum BrowserType {
        ie, chrome, firefox;
    }

    /**
     * This method is to initialize the driver
     * 
     * @param Browser
     *            name and Application URL
     * @throws Throwable
     */
    public static void setDriver(String browserType, String appURL) throws Exception {

        BrowserType browser_Type = BrowserType.valueOf(browserType);

        switch (browser_Type) {
            case chrome:
                driver = initChromeDriver(appURL);
                break;
            case firefox:
                driver = initFirefoxDriver(appURL);
                break;
            case ie:
                System.out.println("browser : " + browserType + " is ie, Launching IE11 as browser of choice..");
                driver = initIEDriver(appURL);
                System.out.println(driver.getWindowHandle().toString());
        }
    }

    /**
     * This method is to initialize the chrome driver and launch the URL
     * 
     * @param Application
     *            URL
     * @throws Throwable
     */
    private static WebDriver initChromeDriver(String appURL) throws Exception {
        try {
            System.out.println("Launching google chrome with new profile..");
            try{
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            }
            catch(Exception e)
            {
            	System.out.println("Path not supported");
            }
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            chromeOptions.addArguments("disable-extensions");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            WebDriver driver = new ChromeDriver(chromeOptions);
            wait = new WebDriverWait(driver, 50);
            Thread.sleep(60);
            driver.navigate().to(appURL);

            return driver;
        }
        catch (Exception e) {
            Log.error(e.getMessage());
            return null;
        }
    }
    
    /**
     * This method is to initialize the firefox driver and launch the URL
     * 
     * @param Application
     *            URL
     * @throws Throwable
     */
    private static WebDriver initFirefoxDriver(String appURL) throws Exception {
        System.out.println("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 50);
        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }

    /**
     * This method is to initialize the ie driver and launch the URL
     * 
     * @param Application
     *            URL
     * @throws Throwable
     */
    private static WebDriver initIEDriver(String appURL) throws Exception {
        System.out.println("Launching IE browser..");
        System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");

        DesiredCapabilities cap = new DesiredCapabilities();
        DesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
        DesiredCapabilities.internetExplorer().setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
        DesiredCapabilities.internetExplorer().setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        DesiredCapabilities.internetExplorer().setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        DesiredCapabilities.internetExplorer().setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
        DesiredCapabilities.internetExplorer().setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.ACCEPT);
        DesiredCapabilities.internetExplorer().setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
        
        
        WebDriver driver = new InternetExplorerDriver(cap);
        wait = new WebDriverWait(driver, 70);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(appURL);
        return driver;
    }
    
	Properties prop;

@BeforeClass
public Properties LoadConfigProperties() throws IOException{
	        File propFile = new File(SetupPropertiesLoader.getProperty("ConfigFilePath", "config"));
	        
	        FileInputStream fileInput = null;
	        try{
	            fileInput = new FileInputStream(propFile);
	        } catch (FileNotFoundException e){
	            e.printStackTrace();
	        }

	        Properties prop = new Properties();
	        //Load properties file
	        try{
	            prop.load(fileInput);
	        }catch (IOException e){
	            e.printStackTrace();
	        }
	        return prop;
	    }
    



    /**
     * This method is to kill the browser
     * 
     * @throws Throwable
     */
    @AfterClass
    public static void tearDown() throws Exception {
        try {
            Runtime.getRuntime().exec("cmd /c start BrowserKill.bat");
            Thread.sleep(5000);
            driver.quit();
        }
        catch (Exception e) {
            Log.error(e.getMessage());
            throw new Exception("Failed while executing the Browserkill.bat file");
        }
    }

    /**
     * Wait until options loaded in drop down
     * 
     * @param select
     */
    public static void waitForAjax(final Select select) throws Exception {
        wait.until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {

                if (select.getOptions().size() > 1) {
                    return true;
                }
                else {
                    return false;
                }
            }
        });
    }
    
    public static void waitForTitleisPresent(final By by) throws Exception{
    	try{
    	wait.until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {

                if (driver.findElement(by).getAttribute("title").length()>0) {
                    return true;
                }
                else {
                    return false;
                }
            }
        });
    	}
    	catch(Exception e)
    	{
    		Log.error("Error while waiting for title is present in element: "+by+e.getMessage());
    		throw new Exception("Title is not present in the element: "+by);
    	}
    }

    /**
     * Wait until page is loaded
     */
    public static void waitForPageLoad() throws Exception {
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return String.valueOf(((JavascriptExecutor) BaseTestSetup.driver).executeScript("return document.readyState")).equals("complete");
                }
            });
        }
        catch (Exception e) {
            Log.error("Error in page load wait" + " :" + e.getMessage());
            throw new Exception("Error in page load wait" + " :" + e.getMessage());
        }
    }

    public static String waitForElementNotVisible(int timeOutInSeconds, WebDriver driver, String elementXPath) {
        if ((driver == null) || (elementXPath == null) || elementXPath.isEmpty()) {

            System.out.println("Wrong usage of WaitforElementNotVisible()");
        }
        try {
            (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class='loadingIndicatorImage']")));
            System.out.println("Wait for element visible");
            return null;
        }
        catch (TimeoutException e) {
            return "Build your own errormessage...";
        }
    }
    /**
     * wait till the number window size of driver is given in parameter
     * @param screenSize
     */
    public static void waitForNumberOfWindowsToBe(int screenSize){
    	try{
    	wait.until(ExpectedConditions.numberOfWindowsToBe(screenSize));
    	}
    	catch(Exception e){
    		
    	}
    }
    
    public static Boolean waitForElementVisible(int timeOutInSeconds, WebDriver driver, By by){
        try{
                (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(by));
                System.out.println("Wait for element visible");
                return Boolean.TRUE;
        }
        catch(Exception e){
                return Boolean.FALSE;
        }
    }

}