package core;


import utils.Utils;

import java.util.concurrent.TimeUnit;

public class BasePage {

	protected Utils utils;
	
	public BasePage() {
		utils = new Utils();
		DriverFactory.getDriver().manage().window().maximize();
//		DriverFactory.getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
}
