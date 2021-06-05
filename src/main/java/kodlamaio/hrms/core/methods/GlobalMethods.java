package kodlamaio.hrms.core.methods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Random;



public class GlobalMethods {
	public static String passwordGenerator(int passLength) {
		   int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    
		    Random random = new Random();
		    StringBuilder buffer = new StringBuilder(passLength);
		    for (int i = 0; i < passLength; i++) {
		        int randomLimitedInt = leftLimit + (int) 
		          (random.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
		    String generatedString = buffer.toString();
		    return generatedString;
	}
	public static boolean checkLocalDate(String date) {
		boolean valid=true;
	       try {

	    	   		LocalDate localDate = LocalDate.parse(date);
	           

	            valid = true;

	        } catch (Exception e) {
	            valid = false;
	        }
		return valid;
	}
}
