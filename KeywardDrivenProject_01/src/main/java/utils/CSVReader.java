package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import keywords.KeywordExecutor;

public class CSVReader {

	public void executeTestCasesFromCSV(String csvFile) throws IOException {
		String path = System.getProperty("user.dir")+"/src/main/resources/"+csvFile;
		
		BufferedReader  br = new BufferedReader(new FileReader(path));
		String line;
		List <String> testSteps = new ArrayList<>();
		String testCaseName = null;
		
		while((line=br.readLine())!=null) {
			String[] data =line.split(",");
			testCaseName = data[0];
			String keyWord =data[1].trim();
			String target=data[2].trim();
			String value=(data.length==4)?data[3].trim():"";
			
			testSteps.add(keyWord + ","+ target +"," +value);
		}
		
		KeywordExecutor keywordExecutor = new KeywordExecutor();
		keywordExecutor.executeTestSteps(testCaseName, testSteps);
		 
				
			
		
		
	}



}
