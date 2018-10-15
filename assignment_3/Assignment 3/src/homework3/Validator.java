package homework3;

import java.util.List;
import java.util.Stack;

public class Validator {
	Stack<Character> braceTracker;
	Stack<Character> quoteTracker;
	boolean isCommented;
	
	public Validator() {
		braceTracker = new Stack<>();
		isCommented = false;
	}
	
	public void scan(List<String> fileData) {
		if(fileData == null) {
			System.out.println("File is empty in scan!");
			return;
		}
		List<String> filteredData = filterComments(fileData);
		
		if(filteredData == null) {
			System.out.println("Error in comments");
			return;
		}
		//print result
		for(String str: filteredData) {
			System.out.println(str);
		}
		
		for(int line = 0; line < filteredData.size(); line++) {
			braceCheck(filteredData.get(line),line);
			//quoteCheck();
		}
		//validity
		if(isBraceTrackerEmpty() && isQuoteTrackerEmpty()) {
			System.out.println("SUCCESS: Valid syntax!");
		}
	}
	
	private List<String> filterComments(List<String> fileData){
		for(int index=0; index<fileData.size(); index++) {
			String line = fileData.get(index);
			char[] charArr = line.toCharArray();
			String updatedLine = line;
			StringBuilder tempLine = new StringBuilder("");
			for(int j=0; j<charArr.length; j++) {
				if(!isCommented) {
					tempLine.append(charArr[j]);
				}
				if(j<charArr.length-1 && charArr[j] == '/' && charArr[j+1] == '/') {
					if(j == 0) {
						tempLine.setLength(0);
					}else {
						if(tempLine.length() > 0)
							tempLine.deleteCharAt(j);
					}
					break;
				}else if(j<charArr.length-1 && charArr[j] == '/' && charArr[j+1] == '*' && !isCommented) {
					isCommented = true;
					tempLine.deleteCharAt(j);
					j++;
				}else if(j<charArr.length-1 && charArr[j] == '*' && charArr[j+1] == '/') {
					if(isCommented) {
						isCommented = false;
						j++;
					}else {
						System.out.println("Line "+ index + ": Faulty closing comment. Please remove it.");
						return null;
					}
				}else {
					//check
				}
			}
			fileData.set(index, tempLine.toString());
		}
		return fileData;
	}
	
	private void braceCheck(String filteredDataLine, int lineNum) {
		final String opening = "({[";
		final String closing = ")}]";
		char[] charArr = filteredDataLine.toCharArray();
		for(int i=0; i<charArr.length; i++) {
			char ch = charArr[i];
			//commented brace handling
			if(i<charArr.length-1 && 
					Character.compare(ch, '\\') == 0 && 
					closing.indexOf(charArr[i+1]) != -1 || opening.indexOf(charArr[i+1]) != -1){
				i++;
				continue;
			}
					
			if(opening.indexOf(ch) != -1)
				braceTracker.push(ch);
			else if(closing.indexOf(ch) != -1) {
				if(braceTracker.isEmpty())
					System.out.println("Line "+ lineNum + ": Faulty closing brace '" + ch + "' .");
				if(closing.indexOf(ch) != opening.indexOf(braceTracker.peek())) {
					System.out.println("Line "+ lineNum + ": Brace mismatch for '" + ch + "' and '" + braceTracker.pop() + "' .");
				}
			}
		}
	}
	
	private void quoteCheck(String filteredDataLine) {
		
	}
	
	private boolean isBraceTrackerEmpty() {
		return braceTracker.size() == 0;
	}
	
	private boolean isQuoteTrackerEmpty() {
		return quoteTracker.size() == 0;
	}
	
}

