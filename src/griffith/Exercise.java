/**
 * @author Ihor Tryndey
 * @version 1.0
 * @since 2023
 */
package griffith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Ihor Tryndey
 * 
 * Class that represents Exercise
 *
 */
public class Exercise extends Assessment{
	
	/**
	 * Parametrized constructor with two parametres 
	 * @param mark
	 * @param title
	 */
	public Exercise(int mark, String title) {
		super(mark, title);
	}
	
	/*
	 * Creation instance of an AssesmentLogger
	 */
	private AssessmentLogger al  = AssessmentLogger.getInstance();
	
	 
	@Override
	/**
	 * Method that make subbmition
	 * @param StudentID
	 */
	public void subbmit(int StudentID) throws IOException {
		//containter for fileReader
		String str = "";
		
		//counter to count how many simmilar submition in submition of file
		int counter = 0;
		
		try {
			//getting file from AssesmentLogger obj
			File file = al.getSub();
			//creation of this file
			file.createNewFile();
			Scanner scan = new Scanner(file);
			//Scanner scan =new Scanner(al.getSub());
			 while(scan.hasNextLine()){ 
				str= scan.nextLine();
				if(str.equals(Integer.toString(StudentID) +" "+ getTitle()))
					counter++;
			}	 
			 
			if(counter == 0) {
				al.log(Event.SUBMITTED, StudentID + " " + getTitle());
				al.closeLog(Event.SUBMITTED);
			}else if(counter > 0) {
				al.log(Event.UPDATED, StudentID + " " + getTitle());
				al.closeLog(Event.UPDATED);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
