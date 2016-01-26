
/*
 * Author: Sourav Das
 * Version: 1.0
 * Task: Write data to some external source in Technical Services Layer(Adapter Pattern)
 * *************Inputs****************************************
 * treemap from controller which needs to be serialized and
 * stored in the flat files
 * ************************************************************
 * Function:  Write data in a Serialized manner to flat files.
 * Date: 27 APR 2014
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

public class RecordData {

	
	//TreeMap containing data to be serialized and recorded into files
	//for which the String is passed
	public String WriteFile(TreeMap tm, String file) {
		String status=null;
		try
	      {
			FileOutputStream fileOut = null;
			
			//For Writing Courses
			 if (file=="Course")
			 {
				 fileOut = new FileOutputStream("Courses.txt");
			 }
			 
			//For Writing Students
			 if (file=="Student")
			 {
				 fileOut = new FileOutputStream("Students.txt");
			 }
			 
			//For Writing Student to Course
			 if (file=="StudentToCourse")
			 {
				 fileOut = new FileOutputStream("StudentToCourse.txt");
			 }
			 
			//For recording Attendance
			 if (file=="Attendance")
			 {
				 fileOut = new FileOutputStream("Attendance.txt");
			 }
			 
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(tm);
	         out.close();
	         fileOut.close();
	         status="Fine";
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	          status="error";
	      }
		
		return status;
	}

}
