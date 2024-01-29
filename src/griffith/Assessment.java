/**
 * @author Ihor Tryndey 3105023
 * @version 1.0
 * @since 2023
 */
package griffith;

import java.io.IOException;

/**
 * 
 * @author Ihor Tryndey 3105023
 * 
 *	Abstract class that represents Assessment
 */
abstract class Assessment {
	
	/*
	 * Here I declare two varibles mark and title
	 */
	private int mark;
	private String title;
	
	/**
	 * Method that returns mark of assessment
	 * @return mark of the assessment
	 */
	public int getMark() {
		return mark;
	}
	
	/**
	 * Method that sets mark of assessment
	 * @param mark
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	/**
	 * Method that returns title of assessment
	 * @return title of the assessment
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Mehtod that sets titile of the assessment 
	 * @param title of the assessment 
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Parametrized with two varibles
	 * @param mark 
	 * @param title
	 */
	public Assessment(int mark, String title) {
		super();
		this.mark = mark;
		this.title = title;
	}
	
	/**
	 * Abstract method that submitted assessment
	 * @param StudentID of a student 
	 * @throws IOException
	 */
	public abstract void subbmit(int StudentID) throws IOException;
}
