
/*
 * Author: Sourav Das
 * Version: 1.0
 * Task: Read data from external source in Technical Services Layer(Adapter Pattern)
 * *************Inputs****************************************
 * name of the flat file which needs to be read and 
 * de-serialized in a tree map and passed onto controller
 * ************************************************************
 * Function:  Read all data related to any flat file which needs 
 * to be read and de-serialized in a tree map and passed onto controller
 * Date: 27 APR 2014
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.TreeMap;



public class ReadData {

	//Method to read data from the files passed in the String
	//de-serialized into a TreeMap and returned 
	public TreeMap ReadFile(String file) {
		TreeMap tm ;
	      try
	      {
	    	  FileInputStream fileIn = null;
	    	  
	    	  //read for Courses FIle
	    	  if (file=="Course")
	    	  {
	    		  fileIn = new FileInputStream("Courses.txt");
	    	  }
	    	  
	    	//read for Students FIle
	    	  if (file=="Student")
	    	  {
	    		  fileIn = new FileInputStream("Students.txt");
	    	  }
	    	  
	    	//read for StudentToCourse FIle
	    	  if (file=="StudentToCourse")
	    	  {
	    		  fileIn = new FileInputStream("StudentToCourse.txt");
	    	  }
	    	  
	    	//read for Attendance FIle
	    	  if (file=="Attendance")
	    	  {
	    		  fileIn = new FileInputStream("Attendance.txt");
	    	  }
	    	  
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         //read into tree map
	         tm = (TreeMap) in.readObject();
	         in.close();
	         fileIn.close();
	         return tm;
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	        return null;
	      }catch(ClassNotFoundException d)
	      {
	         System.out.println("Class not found");
	         d.printStackTrace();
	         return null;
	      }
	}

}
