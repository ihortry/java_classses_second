/**
 * @author Ihor Tryndey 3105023
 * @version 1.0
 * @since 2023
 */
package griffith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 
 * @author Ihor Tryndey
 * 
 * Class of the AssessmentLogger that creates logs, prints logs and close logs
 *
 */
public class AssessmentLogger {	
	
	private static AssessmentLogger instance= null;	
	/**
	 * Constructor for AssessmentLogger
	 */
	private AssessmentLogger() {
	}
	/*
	 * Creation of files
	 */
	private File  sub = new File ("sub.txt");	
	private File  upd = new File ("upd.txt");
	private File  late = new File ("late.txt");
	
	/*
	 * Creation of FileWriters
	 */
	private FileWriter updWriter = null;
	private FileWriter subWriter = null;
	private FileWriter lateWriter = null;
	
	/**
	 * The method that returns submition file
	 * @return
	 */
	public File getSub() {
		return sub;
	}

	/**
	 * Mehtod that sets submition file 
	 * @param sub
	 */
	public void setSub(File sub) {
		this.sub = sub;
	}

	/**
	 * Method that gets updation file
	 * @return upd
	 */
	public File getUpd() {
		return upd;
	}

	/**
	 * Method that sets updation file
	 * @param upd
	 */
	public void setUpd(File upd) {
		this.upd = upd;
	}

	/**
	 * Method that gets late submition file
	 * @return late
	 */
	public File getLate() {
		return late;
	}

	/**
	 * Mehtod that sets late submition file
	 * @param late
	 */
	public void setLate(File late) {
		this.late = late;
	}
	
	/**
	 * Static method getInstance
	 * @return instance of an obj
	 */
	public static AssessmentLogger getInstance() {
		if(instance == null)
			instance = new AssessmentLogger();
		return instance;
	}
	
	/**
	 * Mehtod that log files 
	 * @param event
	 * @param message
	 * @throws IOException
	 */
	public void log(Event event, String message) throws IOException {
			//current time
			LocalDateTime timeStamp = LocalDateTime.now();
		if(event.equals(Event.LATE_SUBMISSION)) {			
			try {
				lateWriter = new FileWriter(late,true);
				//file write method
				lateWriter.write(timeStamp + ":\n" + message +"\n");
			}	catch(Exception e) {
				
			}		
		}else if(event.equals(Event.SUBMITTED)){
			try{				
				subWriter = new FileWriter(sub,true);
				//file write method
				subWriter.write(timeStamp + ":\n" + message +"\n");
			}catch(Exception e) {
				
			}
		}else if(event.equals(Event.UPDATED)) {
			try{
				updWriter = new FileWriter(upd,true);
				//file write method
				updWriter.write(timeStamp + ":\n" + message +"\n");
			}catch(Exception e) {
				
			}
		}
	}
	
	/**
	 * Method that reads all logs
	 * @param event
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void getLog(Event event) throws FileNotFoundException, IOException {
		//container for reading file
		String str = "";
		if(event.equals(Event.LATE_SUBMISSION)) {			
			try(Scanner lateRead = new Scanner(late)){
				while(lateRead.hasNextLine()) {
					str = lateRead.nextLine();
				}
			}		
		}else if(event.equals(Event.SUBMITTED)) {
			try(Scanner subRead = new Scanner(sub)){
				while(subRead.hasNextLine()) {
					str = subRead.nextLine();
				}
			}
		}else if(event.equals(Event.UPDATED)) {
			try(Scanner updRead = new Scanner(upd)){
				while(updRead.hasNextLine()) {
					str = updRead.nextLine();
				}
			}
		}
		
	}
	
	/**
	 * Method that close FileWriters
	 * @param e
	 * @throws IOException
	 */
	public void closeLog(Event e) throws IOException {		
			if(e.equals(Event.LATE_SUBMISSION)) {
				lateWriter.close();
			}else if(e.equals(Event.SUBMITTED)) {
				subWriter.close();
			}else if(e.equals(Event.UPDATED)) {
				updWriter.close();
			}
		}
}
