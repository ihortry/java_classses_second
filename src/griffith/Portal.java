/**
 * @author Ihor Tryndey 3105023
 * @version 1.0
 * @since 2023
 */
package griffith;
 
import java.io.IOException;
import java.time.LocalTime;

/**
 * 
 * @author Ihor Tryndey 3105023
 * 
 * Class Portal for submition assesments and testiong
 *
 */
public class Portal {

	/**
	 * The main method
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {	
		
		/*
		 * Here I create an instance of the class Exercise
		 * And subbmit it below
		 */
		Exercise exc = new Exercise(16, "cp1");
		exc.subbmit(310);
		
		/*
		 * Here I create an instance of the class Assignment
		 * Assignment with late submition
		 * And subbmit it below 
		 */
		Assignment assign = new Assignment(1, "SV",new DeadLine(2020, 14, 11, LocalTime.parse("15:00:00")));
		assign.subbmit(401);
		
		/*
		 * Here I create an instance of the class Test
		 * And subbmit it below
		 */
		Test test = new Test(90,"SAD",new DeadLine(2024, 14, 11, LocalTime.parse("15:00:00")));
		test.subbmit(934);
	}

}
