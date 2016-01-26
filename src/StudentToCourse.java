
/*
 * Author: Sourav Das
 * Version: 1.0
 * Task: Relate between Student and Course objects in Domain Layer(Mediator / Association class)
 * *************Inputs****************************************
 * The netID and classNumber of the students related to a 
 * particular course respectively, passed on from controller
 * ************************************************************
 * Function: This class acts as mediator between Student and Course objects
 * Date: 27 APR 2014
 */
import java.io.Serializable;

public class StudentToCourse implements Serializable{
	
	private String netID;
	private String classNumber;

	
	public StudentToCourse(String netID1, String classNumber) {
		setNetID(netID1);
		setClassNumber(classNumber);
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

	private void setNetID(String netID1) {
		netID=netID1;
	}

}
