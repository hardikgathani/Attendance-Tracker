
/*
 * Author: Sourav Das
 * Version: 1.0
 * Task: Hold Student data in Domain Layer(Information Expert Pattern)
 * *************Inputs****************************************
 * All data related to students to be stored in the
 * system, passed on from controller.
 * ************************************************************
 * Function: This class holds student data
 * Date: 27 APR 2014
 */
import java.io.Serializable;

public class Student implements Serializable{
	
	private String netID;
	private String firstName;
	private String mInIt;
	private String lastName;
	
	public Student(String netID1, String firstName1, String mInIt1, String lastName1) {
		setNetID(netID1);
		setFirstName(firstName1);
		setMInIt(mInIt1);
		setLastName(lastName1);
	}
	
	public String getNetID() {
		return netID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getMInIt() {
		return mInIt;
	}

	public String getLastName() {
		return lastName;
	}


	private void setLastName(String lastName1) {
		lastName=lastName1;
		
	}

	private void setMInIt(String mInIt1) {
		mInIt=mInIt1;
		
	}

	private void setFirstName(String firstName1) {
		firstName=firstName1;
		
	}

	private void setNetID(String netID1) {
		netID=netID1;
	}

}
