package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
		@Override
		protected synchronized WebDriver initialValue(){
			return initDriver();
		}
	};

	public DriverFactory() {}

	public static WebDriver getDriver(){
		return threadDriver.get();
	}

	public static WebDriver initDriver() {

		WebDriver driver = null;
			switch (ProjectProperties.browser) {
				case CHROME:
					System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
					driver = new ChromeDriver();
					break;
				case FIREFOX:
					System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
					driver = new FirefoxDriver();
					break;
			}
		driver.manage().window().maximize();
		return driver;
	}

	/**
	 * This method manage the driver instance to run single tests using only one core.
	 */
//	public static WebDriver getDriver() {
//
//		if(driver == null) {
//			switch (ProjectProperties.browser) {
//			case CHROME:
//				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//				driver = new ChromeDriver();
//				break;
//			case FIREFOX:
//				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
//				driver = new FirefoxDriver();
//				break;
//			}
//		}
//		return driver;
//	}

	public static void killDriver() {
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if (threadDriver != null){
			threadDriver.remove();
		}
	}
	
}
