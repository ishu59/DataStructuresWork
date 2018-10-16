package homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Validator doit = new Validator();
		String file="C:\\Users\\ISHUHOME\\IdeaProjects\\DSMasterProj\\DataStructuresWork\\assignment_3\\Assignment 3\\src\\homework3\\testcase\\testcase3.txt";
		List<String> datain = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while((line = br.readLine()) != null) {
		    	datain.add(line);
		    }
		}
		catch (IOException e) {
			System.out.println("IO error");
			//throw new IOException("IO error in main");
		}
//		for(String s:datain) {
//			System.out.println(s.toString());
//		}
		doit.scan(datain);
		//print
//		for(String str: datain) {
//			System.out.println(str);
//		}
		//System.out.println("Items match: " + doit.scan(datain));
		
		
	}
}
