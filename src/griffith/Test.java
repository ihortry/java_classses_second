/**
 * @author Ihor Tryndey 3105023
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
 * 
 * @author Ihor Tryndey
 * 
 * Class that represents Test 
 *
 */
public class Test extends Assessment{
	
	//creation of deadline
	private DeadLine dl;
	
	 /**
	  * 
	  * jfgskfgj
	  * Parametrized constructor with five parametres
	  * @param mark
	  * @param title
	  * @param dl
	  */
	public Test(int mark, String title, DeadLine dl) {
		super(mark, title);
		this.dl = dl;
	}
	
	//getting instance of assessmentLogger
	private AssessmentLogger al  = AssessmentLogger.getInstance();
	
	@Override
	/**
	 * Method that submitted Test
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
				System.out.println("Tests can be submitted only once");
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
