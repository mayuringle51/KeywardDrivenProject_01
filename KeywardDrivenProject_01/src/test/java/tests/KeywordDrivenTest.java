package tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import keywords.KeywordExecutor;

public class KeywordDrivenTest {

	@AfterMethod
	public void tearDown() {
		
	}
	
	@Test
	public void executeLoginTest() throws IOException {
		KeywordExecutor keywordExecutor = new KeywordExecutor();
		keywordExecutor.executeTestCasesFromCSV("loginTest.csv");
		
	}

}
