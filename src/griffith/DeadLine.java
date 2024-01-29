/**
 * @author Ihor Tryndey 3105023
 * @version 1.0
 * @since 2023
 */
package griffith;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 
 * @author Ihor Tryndey 3105023
 *
 * Class that represent DeadLine
 */
public final class DeadLine {
	
	/*
	 * Here I make declaration of five varibles time, day, month, year, deadline 
	 */
	private final LocalTime time;
	private final int day;
	private final int month;
	private final int year;
	private final LocalDateTime deadline;
	
	/**
	 * Parametrized constructor with four varibles
	 * @param year
	 * @param day
	 * @param month
	 * @param time
	 */
	public DeadLine(int year, int day, int month, LocalTime time) {
		this.time = time;
		this.year = year;
		this.day = day;
		this.month = month;
		deadline  =  LocalDateTime.of(LocalDate.of(year, month, day),time);
	}
	
	/**
	 * The method that returns day of the deadline
	 * @return day
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * The mothod that returns month of the deadline
	 * @return month
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * The mothod that returns year of the deadtine 
	 * @return year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * The method that returns time of the deadline
	 * @return time
	 */
	public LocalTime getTime() {
		return time;
	}
	
	/**
	 * The method that returns boolean before or after deadline
	 * @param time
	 * @return if time before deadline it is true else after
	 */
	public boolean beforeDeadLine(LocalDateTime time) {
		return time.isBefore(deadline);
		 
	}
}
