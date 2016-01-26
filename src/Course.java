
/*
 * Author: Sourav Das
 * Version: 1.0
 * Task: Hold Course data in Domain Layer(Information Expert Pattern)
 * *************Inputs****************************************
 * All data related to a particular course to be stored in the
 * system, passed on from controller.
 * ************************************************************
 * Function: This class holds course data
 * Date: 27 APR 2014
 */
import java.io.Serializable;

public class Course implements Serializable{
	
	private String classNumber;
	private String courseName;
	private String subjectPrefix;
	private String courseNumber;
	private String sectionNumber;
	private String semester;
	
	public Course(String classNumber2, String courseName2, String subjectPrefix2, String courseNumber2, String sectionNumber2, String semester2) {
		setClassNumber(classNumber2);
		setCourseName(courseName2);
		setSubjectPrefix(subjectPrefix2);
		setCourseNumber(courseNumber2);
		setSectionNumber(sectionNumber2);
		setSemester(semester2);
	}

	public String getClassNumber() {
		return classNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public String getSubjectPrefix() {
		return subjectPrefix;
	}

	public void setSubjectPrefix(String subjectPrefix) {
		this.subjectPrefix = subjectPrefix;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(String sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

}
