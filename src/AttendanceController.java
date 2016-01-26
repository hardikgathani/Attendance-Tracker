
/*
 * Author: Sourav Das
 * Version: 1.0
 * Task: Controller of Attendance Tracker in Domain Layer(Controller Design Pattern also acts as Creator)
 * *************Inputs****************************************
 * This file is mainly called as a result of different events
 * from class of UI layer
 * ************************************************************
 * Function: This file acts as a controller between the UI, other domain
 * level classes and classes of the technical Services layer
 * Date: 27 APR 2014
 */
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class AttendanceController {

	public static void main(String[] args) {
		
		//Create instance of HomeScreen
		HomeScreen h1=new HomeScreen();
		h1.setVisible(true);

	}
	
	//Method for Adding Courses
 public static String createCourseObject(String classNumber, String courseName, String subjectPrefix, String courseNumber, String sectionNumber, String semester) throws IOException{
	 String status;
	 //Create Course Object
	 Course c1=new Course(classNumber,courseName,subjectPrefix,courseNumber,sectionNumber,semester);
	 
	 TreeMap<String, Course> tm = new TreeMap<String,Course>();
	 
	 File ifile =new File("Courses.txt");
	  
		//if file doesnt exists, then skip read
		if(ifile.exists()){
			ReadData r1=new ReadData();
			//read file into treemap
			 tm=r1.ReadFile("Course");
		}
	 
	 //Add new Course object in treemap 
	 tm.put(c1.getClassNumber(),c1);
	 //Write treemap to file
	 RecordData w1=new RecordData();
	 status=w1.WriteFile(tm,"Course");
	 
	 return status;
 }
 
//Method for Viewing Courses
 public static String[] viewCourse(){
	 TreeMap<String,Course> tm = new TreeMap<String,Course>();
	 ArrayList<String> lines = new ArrayList<String>();
	 
	 File ifile =new File("Courses.txt");
	  
		//if file doesnt exists, then skip
		if(ifile.exists()){
			ReadData r1=new ReadData();
			//read file into treemap
			 tm=r1.ReadFile("Course");
			 //iterate through each treemap entry and add to ArrayList
			 for (Map.Entry<String,Course> entry : tm.entrySet()) {
			        Course c1 = entry.getValue();
			        String key = entry.getKey();
			        lines.add(c1.getClassNumber()+"	"+c1.getCourseName()+"	"+c1.getSubjectPrefix()+"	"+c1.getCourseNumber()+"	"+c1.getSectionNumber()+"	"+c1.getSemester());
			   }
		}
		
	 return lines.toArray(new String[lines.size()]);
 }
 
//Method for Updating Courses
public static String updateCourseObject(String classNumber, String courseName,
		String subjectPrefix, String courseNumber, String sectionNumber,
		String semester) {
	
	String status = null;
	 //Create Course Object
	 Course c1=new Course(classNumber,courseName,subjectPrefix,courseNumber,sectionNumber,semester);
	 
	 TreeMap<String, Course> tm = new TreeMap<String,Course>();
	 
	 File ifile =new File("Courses.txt");
	  
		//if file doesnt exists, then skip read
		if(ifile.exists()){
			ReadData r1=new ReadData();
			//read file into treemap
			 tm=r1.ReadFile("Course");
		
	 
	 //Update Course object in treemap 
		 
		 tm.put(c1.getClassNumber(),c1);
	 
	 //Write treemap to file
	 RecordData w1=new RecordData();
	 status=w1.WriteFile(tm,"Course");
		}
	 return status;
}

//Method for deleting Courses
public static String deleteCourseObject(String classNumber) {
	 String status = null;
	 
	 TreeMap<String, Course> tm = new TreeMap<String,Course>();
	 
	 File ifile =new File("Courses.txt");
	  
	 	//if file doesnt exists, then skip 
	 if(ifile.exists()){
		ReadData r1=new ReadData();
		//read file into treemap
		 tm=r1.ReadFile("Course");
		 
		 //Remove node from tree map
		 tm.remove(classNumber);

	 //Write treemap to file
	 RecordData w1=new RecordData();
	 status=w1.WriteFile(tm,"Course");
	 
	//remove student to course entries
		String status1 = deleteStudentToCourseObject("",classNumber);
	}
	 return status;
}

//Method for Viewing Students
public static String[] viewStudent() {
	TreeMap<String,Student> tm = new TreeMap<String,Student>();
	 ArrayList<String> lines = new ArrayList<String>();
	 
	 File ifile =new File("Students.txt");
	  
		//if file doesnt exists, then skip
		if(ifile.exists()){
			ReadData r1=new ReadData();
			//read file into treemap
			 tm=r1.ReadFile("Student");
			 //iterate through each treemap entry and add to ArrayList
			for (Map.Entry<String,Student> entry1 : tm.entrySet()) {
			        Student s1 = entry1.getValue();
			        String key = entry1.getKey();
			        lines.add(s1.getNetID()+"	"+s1.getFirstName()+"	"+s1.getMInIt()+"	"+s1.getLastName());
			   }
		}
		
	 return lines.toArray(new String[lines.size()]);
}

//Method for adding Students
public static String createStudentObject(String netID, String firstName,
		String mInIt, String lastName) {
	String status;
	 //Create Course Object
	 Student s1=new Student(netID,firstName,mInIt,lastName);
	 
	 TreeMap<String, Student> tm = new TreeMap<String,Student>();
	 
	 File ifile =new File("Students.txt");
	  
		//if file doesnt exists, then skip read
		if(ifile.exists()){
			ReadData r1=new ReadData();
			//read file into treemap
			 tm=r1.ReadFile("Student");
		}
	 
	 //Add new Course object in treemap 
	 tm.put(s1.getNetID(),s1);
	 //Write treemap to file
	 RecordData w1=new RecordData();
	 status=w1.WriteFile(tm,"Student");
	 
	 return status;
}

//Method for updating Students
public static String updateStudentObject(String netID, String firstName,
		String mInIt, String lastName) {
	String status = null;
	 //Create Student Object
	Student s1=new Student(netID,firstName,mInIt,lastName);
	 
	 TreeMap<String, Student> tm = new TreeMap<String,Student>();
	 
	 File ifile =new File("Students.txt");
	  
		//if file doesnt exists, then skip read
		if(ifile.exists()){
			ReadData r1=new ReadData();
			//read file into treemap
			 tm=r1.ReadFile("Student");
		
	 
	 //Update Student object in treemap 
		 
		 tm.put(s1.getNetID(),s1);
	 
	 //Write treemap to file
	 RecordData w1=new RecordData();
	 status=w1.WriteFile(tm,"Student");
		}
	 return status;
}

//Method for deleting Students
public static String deleteStudentObject(String netID) {
	 String status = null;
	 
	 TreeMap<String, Student> tm = new TreeMap<String,Student>();
	 
	 File ifile =new File("Students.txt");
	  
	 	//if file doesnt exists, then skip 
	 if(ifile.exists()){
		ReadData r1=new ReadData();
		//read file into treemap
		 tm=r1.ReadFile("Student");
		 
		 //Remove node from tree map
		 tm.remove(netID);

	 //Write treemap to file
	 RecordData w1=new RecordData();
	 status=w1.WriteFile(tm,"Student");
	 tm.clear();
	 //remove student to course entries
	 status = deleteStudentToCourseObject(netID,null);
	 
	}
	 return status;
}

//Method for Viewing Student to Course Relationships
public static String[] viewStudentToCourse(String netID, String course) {
	
	String classNumber = null;
	//Extracting Class Number
	if(course!=null){
		classNumber = course.split(",")[0];
	}
	
	TreeMap<String,StudentToCourse> tm = new TreeMap<String,StudentToCourse>();
	 ArrayList<String> lines = new ArrayList<String>();
	 
	 File ifile =new File("StudentToCourse.txt");
	  
		//if file doesnt exists, then skip
		if(ifile.exists()){
			ReadData r1=new ReadData();
			//read file into treemap
			 tm=r1.ReadFile("StudentToCourse");
			 //iterate through each treemap entry and add to ArrayList
			for (Map.Entry<String,StudentToCourse> entry1 : tm.entrySet()) {
					StudentToCourse sc1 = entry1.getValue();
			        String key = entry1.getKey();
			        
			        //if none of the fields are passed
					if(netID.trim().length() == 0 && course==null){
				        lines.add(sc1.getNetID()+"	"+sc1.getClassNumber());
					}
					//if only classNumber is passed
					else if (netID.trim().length() == 0){
						if(sc1.getClassNumber().equals(classNumber)){
							lines.add(sc1.getNetID()+"	"+sc1.getClassNumber());
						}
					}
					//if only classNumber is passed
					else if (course==null){
						if(sc1.getNetID().equals(netID)){
							lines.add(sc1.getNetID()+"	"+sc1.getClassNumber());
						}
					}
					//if both classNumber and NetID are passed
					else{
						if(sc1.getClassNumber().equals(classNumber) && sc1.getNetID().equals(netID)){
							lines.add(sc1.getNetID()+"	"+sc1.getClassNumber());
						}
					}
						
			   }
		}
		
	 return lines.toArray(new String[lines.size()]);
}

//Method for Adding Student to Course Relationships
public static String createStudentToCourseObject(String netID, String course) {
	String status;
	
	//Extracting Class Number
	String classNumber = course.split(",")[0];
	
	 //Create Course Object
	 StudentToCourse sc1=new StudentToCourse(netID,classNumber);
	 
	 TreeMap<String, StudentToCourse> tm = new TreeMap<String,StudentToCourse>();
	 
	 File ifile =new File("StudentToCourse.txt");
	  
		//if file doesnt exists, then skip read
		if(ifile.exists()){
			ReadData r1=new ReadData();
			//read file into treemap
			 tm=r1.ReadFile("StudentToCourse");
		}
	 
	 //Add new Student to Course object in treemap 
	 tm.put(sc1.getNetID()+sc1.getClassNumber(),sc1);
	 //Write treemap to file
	 RecordData w1=new RecordData();
	 status=w1.WriteFile(tm,"StudentToCourse");
	 return status;
}

//Method for Deleting Student to Course Relationships
public static String deleteStudentToCourseObject(String netID, String course) {
	String status = null;
	System.out.println("Inside deleteStudentToCourseObject with"+ netID+"	"+course);
	//Extracting Class Number
	String classNumber =null;
	if(course!=null){
		classNumber = course.split(",")[0];
	}
	 
	 TreeMap<String, StudentToCourse> tm3 = new TreeMap<String,StudentToCourse>();
	 TreeMap<String, StudentToCourse> tm4 = new TreeMap<String,StudentToCourse>();
	 
	 File ifile =new File("StudentToCourse.txt");
	  
	 	//if file doesnt exists, then skip 
	 if(ifile.exists()){
		ReadData r1=new ReadData();
		//read file into treemap
		 tm3=r1.ReadFile("StudentToCourse");
		 tm4=r1.ReadFile("StudentToCourse");
		 
		 //Remove node from tree map
		 if(course== null)
		 { 
			 System.out.println("Inside IF1");
			 for (Map.Entry<String,StudentToCourse> entry1 : tm4.entrySet()) {
					StudentToCourse sc1 = entry1.getValue();
			        String key = entry1.getKey();
			        
			        //if none of the fields are passed
					if(sc1.getNetID().equals(netID)){
						tm3.remove(key);
						
					}
			 }
			 
			//removing attendance entries for the student
		    status = deleteAttendanceObject(netID,null);
		 }
		 else if (netID.length() == 0){
			 System.out.println("Inside IF 2");
			 for (Map.Entry<String,StudentToCourse> entry1 : tm4.entrySet()) {
					StudentToCourse sc1 = entry1.getValue();
			        String key = entry1.getKey();
			        
			        //if none of the fields are passed
					if(sc1.getClassNumber().equals(classNumber)){
						tm3.remove(key);
					}
			 }
			 //removing attendance entries for the course
			 status = deleteAttendanceObject("",course);
		 }
		 else{
			 System.out.println("Inside IF"+netID+classNumber);
			 tm3.remove(netID+classNumber);
			 System.out.println("After tm3 remove");
			//removing attendance entries for the Course for the Student
			 status = deleteAttendanceObject(netID,course);
		 }

	 //Write treemap to file
	 RecordData w1=new RecordData();
	 String status1=w1.WriteFile(tm3,"StudentToCourse");
	}
	 return status;
}

//fetch attendance of a particular day of a particular class
public static String[] fetchAttendance(Date attendanceDate, String course) {
	TreeMap<String,Attendance> tm = new TreeMap<String,Attendance>();
	 ArrayList<String> lines = new ArrayList<String>();
	 
	// DateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
	 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	// Date convertedDate = parser.parse(attendanceDate);
	 String stringAttendDate = formatter.format(attendanceDate);
	 
	//Extracting Class Number
			String classNumber = course.split(",")[0];
	 
	 File ifile =new File("Attendance.txt");
	  
	 	//This part is done if Attendance have already been recorded once for that day
		//if file doesn't exists, then skip
		if(ifile.exists()){
			ReadData r1=new ReadData();
			//read file into treemap
			 tm=r1.ReadFile("Attendance");
			 //iterate through each treemap entry and add to ArrayList
			for (Map.Entry<String,Attendance> entry1 : tm.entrySet()) {
				Attendance a1 = entry1.getValue();
			        String key = entry1.getKey();
			        if(a1.getAttendanceDate().compareTo(attendanceDate)==0 && a1.getClassNumber().equals(classNumber))
			        lines.add(formatter.format(attendanceDate)+"	"+a1.getClassNumber()+"	"+a1.getNetID()+"	"+a1.getStatus());
			   }
		}
		
		String[] returnList= lines.toArray(new String[lines.size()]);
		
		
		//This part is done if attendance of the class and for that date have not been recorded previously.
		//it returns an array of strings containing the intended date(attendanceDate), classNumber, netIDs of students enrolled
		//for that class and all of them in absent status
		String netID="";
		if(returnList.length==0)
		{
			
			String netClass[]=viewStudentToCourse(netID,course);                 //netID+"	"+classNumber returned
			String returnList1[]= new String[netClass.length];
			//preparing the string array to be returned, each record in "date(attendanceDate)	classNumber	netID	status" format
			for(int i=0;i<netClass.length;i++)
			{
				netID=netClass[i].split("	")[0];
				classNumber=netClass[i].split("	")[1];
				returnList1[i]=stringAttendDate+"	"+classNumber+"	"+netID+"	"+0;
			}
			returnList=returnList1;
		}
		
		return returnList;	
}

//Method for recording Attendance
public static String createAttendanceObjects(
		ArrayList<String> stringAttendDateLst,
		ArrayList<String> classNumberLst, ArrayList<String> netIDLst,
		ArrayList<String> attendanceLst) {
	String stat;
	 
	 TreeMap<String, Attendance> tm = new TreeMap<String,Attendance>();
	 
	 File ifile =new File("Attendance.txt");
	  
		//if file doesnt exists, then skip read
		if(ifile.exists()){
			ReadData r1=new ReadData();
			//read file into treemap
			 tm=r1.ReadFile("Attendance");
		}
		
		
		//Create Attendance Object and adding to tree map
		int status=0;
		for (int i=0;i<stringAttendDateLst.size();i++)
		{
			Date AttendDate = null;
			try {
				AttendDate = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(stringAttendDateLst.get(i));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String classNumber=classNumberLst.get(i);
			String netID=netIDLst.get(i);
			
			if(Boolean.valueOf(attendanceLst.get(i))==true){
				status=1;}
			else{
				status=0;}
			
			Attendance a1=new Attendance(AttendDate,netID,classNumber,status);
			
			//Add new Attendance record object in treemap 
			 tm.put(stringAttendDateLst.get(i)+a1.getNetID()+a1.getClassNumber(),a1);
		}
		
	 //Write treemap to file
	 RecordData w1=new RecordData();
	 stat=w1.WriteFile(tm,"Attendance");
	 
	 return stat;
}

//Method for reading Attendance
public static String[] fetchReportChart(String course) {
	TreeMap<String,Attendance> tm = new TreeMap<String,Attendance>();
	TreeMap<String,Attendance> tm1 = new TreeMap<String,Attendance>();
	 ArrayList<String> lines = new ArrayList<String>();
	 
	//Extracting Class Number
		String classNumber = course.split(",")[0];
		
		// Date Formatter to convert from date to string
		 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		File ifile =new File("Attendance.txt");

	//if file doesn't exists, then skip
		if(ifile.exists()){
		ReadData r1=new ReadData();
		//read file into treemap
		 tm=r1.ReadFile("Attendance");
		 //iterate through each treemap entry and add to ArrayList
		for (Map.Entry<String,Attendance> entry1 : tm.entrySet()) {
			Attendance a1 = entry1.getValue();
		    String key = entry1.getKey();
		    if(a1.getClassNumber().equals(classNumber))
		    lines.add(formatter.format(a1.getAttendanceDate())+"	"+a1.getNetID()+"	"+a1.getStatus());
		   }
	}
	
	return lines.toArray(new String[lines.size()]);
}
	
//Method for Deleting Attendance
public static String deleteAttendanceObject(String netID, String course) {
	String status = null;
	System.out.println("Inside Attendance");
	//Extracting Class Number
	String classNumber=null;
	if(course != null){
		classNumber = course.split(",")[0];
	}
	System.out.println("Inside Attendance"+netID+"	"+classNumber);
	
	 TreeMap<String, Attendance> tm1 = new TreeMap<String,Attendance>();
	 TreeMap<String, Attendance> tm2 = new TreeMap<String,Attendance>();
	 
	 File ifile =new File("Attendance.txt");
	  
	 	//if file doesnt exists, then skip 
	 if(ifile.exists()){
		 System.out.println("Before read file");
		ReadData r1=new ReadData();
		//read file into treemap
		 tm1=r1.ReadFile("Attendance");
		 tm2=r1.ReadFile("Attendance");
		 System.out.println("After read file");
		 //Remove node from tree map
		 if(course == null)
		 {
			 System.out.println("Inside Attendance1");
			 for (Map.Entry<String,Attendance> entry1 : tm2.entrySet()) {
				Attendance a1 = entry1.getValue();
			    String key = entry1.getKey();
			    if(a1.getNetID().equals(netID)){
			    	tm1.remove(key);
			    }
			}
		 }
		 else if (netID.length() == 0){
			 System.out.println("Inside Attendance2");
			 for (Map.Entry<String,Attendance> entry1 : tm2.entrySet()) {
					Attendance a1 = entry1.getValue();
				    String key = entry1.getKey();
				    if(a1.getClassNumber().equals(classNumber)){
				    	tm1.remove(key);
				    }
			 }
		 }
		 else{
			 System.out.println("Inside Attendance3");
			 for (Map.Entry<String,Attendance> entry1 : tm2.entrySet()) {
					Attendance a1 = entry1.getValue();
				    String key = entry1.getKey();
				    System.out.println("attendance keys "+key);
				    
				    if(a1.getClassNumber().equals(classNumber) && a1.getNetID().equals(netID)){
				    	System.out.println("attendance key to be removed"+key);
				    	tm1.remove(key);
				    	System.out.println("attendance key removed");
				    }
				    System.out.println("Attendance key removal process");
			 }
		 }

	 //Write treemap to file
	 RecordData w1=new RecordData();
	 status=w1.WriteFile(tm1,"Attendance");
	 System.out.println("After attendance removal");
	}
	 return status;
}

}
