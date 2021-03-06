package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import logic.CalcRate;

public class SustRate {

	/**
	 * @param args
	 */
	static FileReader reader;
	private static String line;
	private static ArrayList<String> joiner = new ArrayList<String>();
	static CalcRate result;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		BufferedReader buffer = new BufferedReader(reader = new FileReader(args[0]));
		
		while((line = buffer.readLine()) != null){
			if(line.startsWith(">")){
				joiner.add(line);
			}else{
				if(joiner.get(joiner.size()-1).startsWith(">")){
					joiner.add(line);
				}else{
					joiner.set(joiner.size()-1, joiner.get(joiner.size()-1)+line);
				}
			}
		}
		
		result = new CalcRate(joiner);
		result.some(args[1]);
		
		buffer.close();
	}

}
