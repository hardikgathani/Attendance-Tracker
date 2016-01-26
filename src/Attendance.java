
/*
 * Author: Sourav Das
 * Version: 1.0
 * Task: Hold Attendance data in Domain Layer(Information Expert Pattern)
 * *************Inputs****************************************
 * The netID, classNumber, date and the presence status of the 
 * students related to that particular course on a particular 
 * date, passed on from controller.
 * ************************************************************
 * Function: This class holds attendance data
 * Date: 27 APR 2014
 */
import java.io.Serializable;
import java.util.Date;

public class Attendance implements Serializable{

	private String netID;
	private String classNumber;
	private Date attendanceDate;
	private int status;

	
	public Attendance(Date attendanceDate,String netID, String classNumber,int status) {
		setAttendanceDate(attendanceDate);
		setNetID(netID);
		setClassNumber(classNumber);
		setStatus(status);
	}
	
	private void setStatus(int status2) {
		status=status2;
		//System.out.println(status);
	}

	private void setAttendanceDate(Date attendanceDate2) {
		attendanceDate=attendanceDate2;
		
	}

	private void setClassNumber(String classNumber2) {
		classNumber=classNumber2;
		
	}

	public String getNetID() {
		return netID;
	}
	
	public String getClassNumber() {
		return classNumber;
	}
	
	public Date getAttendanceDate() {
		return attendanceDate;
	}
	
	public int getStatus() {
		return status;
	}

	private void setNetID(String netID1) {
		netID=netID1;
	}
}
