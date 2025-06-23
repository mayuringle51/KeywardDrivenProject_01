package keywords;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.CSVReader;

public class KeywordExecutor {
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public void executeTestCasesFromCSV(String csvFile) throws IOException {

		CSVReader csvReader = new CSVReader();
		csvReader.executeTestCasesFromCSV(csvFile);
	}

	public void executeTestSteps(String testCaseName, List<String> testSteps) {
		System.out.println("Executing test Case: " + testCaseName);
		for (String step : testSteps) {
			String[] parts = step.split(",");
			String keyword = parts[0].trim();
			String target = parts[1].trim();
			String value = "";
			if (parts.length == 3) {
				value = parts[2].trim();
			}
			executeKeyword(keyword, target, value);
		}

	}

	public void executeKeyword(String keyword, String target, String value) {
		System.out.println("==========executeKeyword : " + keyword);
		switch (keyword) {
		case "OpenBrowser":
			try {
				openBrowser(target.toLowerCase());
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Unsupported browser: " + value);
			}
			break;
		case "NavigateTo":
			navigateTo(target);
			break;
		case "click":
			click(target);
			break;
		case "type":
			type(target, value);
			break;
		case "verifyText":
			verifyText(target, value);
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + keyword);

		}

	}

	public void verifyText(String target, String expectedText) {
		By locator = getBy(target);
		String actualText=getWebDriver().findElement(locator).getText();

	}

	public WebDriver getWebDriver() {
		
		 WebDriver driver = tlDriver.get();
		 
	        if (driver == null) {
	            throw new IllegalStateException("Driver not initialized. Did you call OpenBrowser first?");
	        }
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        return driver;
	}

	public By getBy(String target) {
		if (target.startsWith("id=")) {
            return By.id(target.replace("id=", ""));
        } else if (target.startsWith("name=")) {
            return By.name(target.replace("name=", ""));
        } else if (target.startsWith("xpath=")) {
            return By.xpath(target.replace("xpath=", ""));
        } else {
            return By.cssSelector(target);
        }
	}

	public void type(String target, String value) {
		By locator = getBy(target);
		getWebDriver().findElement(locator).sendKeys(value);

	}

	public void click(String target) {
		By locator = getBy(target);
		getWebDriver().findElement(locator).click();

	}

	public void navigateTo(String url) {
		getWebDriver().navigate().to(url);

	}

	public void openBrowser(String browser) {
		 WebDriver driver;
		 switch(browser) {
		 case "chrome":
			 driver=new ChromeDriver();
			 break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " +browser);
		 }
		 
		tlDriver.set(driver);
		
		
	}

}
