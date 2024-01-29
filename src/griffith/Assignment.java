/**
 * @author Ihor Tryndey
 * @version 1.0
 * @since 2023
 */
package griffith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author Ihor Tryndey
 *  
 *  Class that represents Assignment
 */
public class Assignment extends Assessment{	
	
	//creation of deadline
	private DeadLine dl;
	
	/**
	 * Parametrized constructor that has three parametres
	 * @param mark
	 * @param title
	 * @param dl
	 */
	public Assignment(int mark, String title, DeadLine dl) {
		super(mark, title);
		this.dl = dl;
	}

	//get an instance of AssessmentLogger
	private AssessmentLogger al  = AssessmentLogger.getInstance();
	
	@Override
	/**
	 * Method that make subbmition
	 * @param StudentID
	 */ 
	public void subbmit(int StudentID) throws IOException {
		String str = "";
		int counter = 0;
		try {
			File file = al.getSub();
			file.createNewFile();
			Scanner scan =new Scanner(file);
			
			 while(scan.hasNextLine()){ 
				str= scan.nextLine();
				if(str.equals(Integer.toString(StudentID) +" "+ getTitle()))
					counter++;
			}
					 
			if(dl.beforeDeadLine(LocalDateTime.now())) { 
				if(counter == 0) {
				al.log(Event.SUBMITTED, StudentID + " " + getTitle());
				al.closeLog(Event.SUBMITTED);
			}else if(counter > 0) {
				al.log(Event.UPDATED, StudentID + " " + getTitle());
				al.closeLog(Event.UPDATED);
			}
			}else {
				al.log(Event.LATE_SUBMISSION, StudentID + " " + getTitle());
				al.closeLog(Event.LATE_SUBMISSION);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method that gets deadline
	 * @return dl
	 */
	public DeadLine getDl() {
		return dl;
	}
	
	/**
	 * Method that sets deadline
	 * @param dl
	 */
	public void setDl(DeadLine dl) {
		this.dl = dl;
	}

}
