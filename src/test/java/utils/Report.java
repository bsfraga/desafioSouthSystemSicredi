package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import freemarker.template.SimpleDate;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Report {

	private static ExtentReports extentReport;
	private static ExtentTest logger;

	public Report() {
	}

	private static String getNewReportPath() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy - HH_mm_ss");
		Date date = new Date();
		return "./reports/Report_"+format.format(date)+".html";
	}

	private static void defineStatusHierarchy() {
		List<Status> statusHierarchy = Arrays.asList(Status.FAIL, Status.FATAL, Status.DEBUG, Status.ERROR, Status.INFO,
				Status.PASS, Status.SKIP, Status.WARNING);
		StatusConfigurator.getInstance().setStatusHierarchy(statusHierarchy);
	}

	public static void create(String title, String description) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(getNewReportPath());
		htmlReporter.config().setDocumentTitle(title);
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Teste Suite");
		defineStatusHierarchy();
		extentReport = new ExtentReports();
		extentReport.attachReporter(new ExtentReporter[] { htmlReporter });
	}

	public static void startTest(String testDescription) {
		if (extentReport == null) {
			create("Test Suite", testDescription);
		}
		logger = extentReport.createTest(testDescription);
	}

	public static void close() {
		if (extentReport != null) {
			extentReport.flush();
		} else {
			log(Status.INFO, "O TestCase Passou !");
			log(Status.INFO, "O TestCase encerrou.");
			close();
		}
	}

	public static void log(Status logStatus, String message, String imagePath) {
		try {
				if (logger == null) {
				startTest("Test Suite");
			}

			logger.log(logStatus, message, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());

		} catch (Exception e) {
			logger.log(logStatus, message + " (Screenshot fail)");
		}
	}
	

	public static void log(Status logStatus, String message) {
		if (logger == null) {
			startTest("TEST SUITE");
		}
		logger.log(logStatus, message);
	}

	public static void log(String message, String imagePath) {
		log(Status.INFO, message, imagePath);
	}

	public static void log(String message) {
		log(Status.INFO, message);
	}

	public static void logPass(String message, String imagePath) {
		log(Status.PASS, message, imagePath);
	}

	public static void logPass(String message) {
		log(Status.PASS, message);
	}

	public static void logFail(String message, String imagePath) {
		log(Status.FAIL, message, imagePath);
	}

	public static void logFail(String message) {
		log(Status.FAIL, message);
	}

}
