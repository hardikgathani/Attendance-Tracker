
/*
 * Author: Sourav Das
 * Version: 1.0
 * Task: User Interface of Attendance Tracker in User interface layer(Facade Design Pattern)
 * *************Inputs****************************************
 * This file acts as the major UI class which takes requests 
 * directly from the user as input
 * ************************************************************
 * Function: This file acts as the major UI class which passes on requests 
 * to controller of Domain layer.
 * Date: 27 APR 2014
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HomeScreen extends JFrame {

	private JPanel contentPane;
	private JTextField crsClassNoTF;
	private JTextField crsCourseNmTF;
	private JTextField crsSubPrefTF;
	private JTextField crsCourseNoTF;
	private JTextField crsSecNoTF;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel panel_3;
	private JTextArea textArea;
	private JButton btnDelete_1;
	private JButton btnUpdate_1;
	private JButton btnAdd_1;
	private JButton btnView_1;
	private JLabel lblLastName;
	private JLabel lblMinit;
	private JLabel lblFname;
	private JLabel lblNewLabel_1;
	private JPanel panel_2;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblCourseName;
	private JLabel lblSubjectPrefixexCs;
	private JLabel lblCourseNumber;
	private JLabel lblSectionNumber;
	private JLabel lblSemester;
	private JButton btnView;
	private JButton btnAdd_2;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTextArea crsTextArea_1;
	private JTextField crsSemesterTF;
	private JPanel panel_4;
	private JLabel lblCourse;
	private JPanel panel;
	private JLabel lblDay;
	private JList list;
	private JList<String> list_1;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JLabel label;
	private JTextField textField_4;
	private JLabel label_1;
	private JScrollPane scrollPane_3;
	private JList list_2;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JTextArea textArea_1;
	private JScrollPane scrollPane_4;
	private JLabel lblNoteAddAnd;
	private JLabel lblNoteAddAnd_1;
	private JLabel lblCourse_1;
	private JScrollPane scrollPane_8;
	private JList list_6;
	private JScrollPane scrollPane_9;
	private JTable table;
	private JButton btnSave;
	private JButton btnUpdate_2;
	private JTextField textField_5;
	private JButton btnFetch;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_6;
	private JTable table_1;
	private JList list_3;
	private JButton btnChart;
	private JButton btnGraph;
	private JLabel label_4;
	private JScrollPane scrollPane_5;
	private JButton btnNewButton;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JLabel lblRepresentsPresent;
	



	/**
	 * Create the frame.
	 */
	public HomeScreen() {
		setTitle("Attendance Recorder");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane1.setBounds(0, 0, 490, 443);
		contentPane.add(tabbedPane1);
		
		panel = new JPanel();
		tabbedPane1.addTab("Attendance", null, panel, null);
		panel.setLayout(null);
		
		lblDay = new JLabel("Date(Format:MM/dd/yyyy): ");
		lblDay.setBounds(10, 11, 152, 14);
		panel.add(lblDay);
		
		lblCourse_1 = new JLabel("Courses:");
		lblCourse_1.setBounds(10, 36, 143, 14);
		panel.add(lblCourse_1);
		
		scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(163, 35, 244, 59);
		panel.add(scrollPane_8);
		
		list_6 = new JList(loadCourses());
		scrollPane_8.setViewportView(list_6);
		list_6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(10, 105, 369, 231);
		//panel.add(scrollPane_9);
		
		table = new JTable();
		
		//Saving attendance for a particular day for a particular class
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_2.setText("");
				label_3.setText("");
				
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				
				//taking data into different array lists :stringAttendDateLst,classNumberLst,netIDLst,attendanceLst
				ArrayList<String> stringAttendDateLst = new ArrayList<String>();
				ArrayList<String> classNumberLst = new ArrayList<String>();
				ArrayList<String> netIDLst = new ArrayList<String>();
				ArrayList<String> attendanceLst = new ArrayList<String>();

				int nRow1 = model1.getRowCount(), nCol1 = model1.getColumnCount();
				
				  for(int count = 0; count < nRow1; count++){
					  stringAttendDateLst.add(model1.getValueAt(count, 0).toString());
					  classNumberLst.add(model1.getValueAt(count, 1).toString());
					  netIDLst.add(model1.getValueAt(count, 2).toString());
					  attendanceLst.add(model1.getValueAt(count, 3).toString());
				  }
				  
			
				  String status = null;
					//Call createAttendanceObjects of Controller to record Attendance
					status = AttendanceController.createAttendanceObjects(stringAttendDateLst,classNumberLst,netIDLst,attendanceLst);
					if(status=="Fine")
					{
						label_3.setText("Attendance recorded Successfully with Class Number"+classNumberLst.get(0)+" for date:"+stringAttendDateLst.get(0));
					}
					else
					{
						label_3.setText("There is some problem");
					}
					
					scrollPane_9.setVisible(false);
			
			}
		});
		btnSave.setBounds(127, 347, 89, 23);
		panel.add(btnSave);
		
		
		//Updating attendance for a particular day for a particular class
		btnUpdate_2 = new JButton("UPDATE");
		btnUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				label_2.setText("");
				label_3.setText("");
				
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				
				//taking data into different array lists :stringAttendDateLst,classNumberLst,netIDLst,attendanceLst
				ArrayList<String> stringAttendDateLst = new ArrayList<String>();
				ArrayList<String> classNumberLst = new ArrayList<String>();
				ArrayList<String> netIDLst = new ArrayList<String>();
				ArrayList<String> attendanceLst = new ArrayList<String>();

				int nRow1 = model1.getRowCount(), nCol1 = model1.getColumnCount();
				
				  for(int count = 0; count < nRow1; count++){
					  stringAttendDateLst.add(model1.getValueAt(count, 0).toString());
					  classNumberLst.add(model1.getValueAt(count, 1).toString());
					  netIDLst.add(model1.getValueAt(count, 2).toString());
					  attendanceLst.add(model1.getValueAt(count, 3).toString());
				  }
				  
			
				  String status = null;
					//Call createAttendanceObjects of Controller to record Attendance
					status = AttendanceController.createAttendanceObjects(stringAttendDateLst,classNumberLst,netIDLst,attendanceLst);
					if(status=="Fine")
					{
						label_3.setText("Attendance updated Successfully with Class Number"+classNumberLst.get(0)+" for date:"+stringAttendDateLst.get(0));
					}
					else
					{
						label_3.setText("There is some problem");
					}
					
					scrollPane_9.setVisible(false);
			}
		});
		btnUpdate_2.setBounds(226, 347, 89, 23);
		panel.add(btnUpdate_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(163, 8, 152, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		//Fetching attendance records for a particular day for a particular class
		btnFetch = new JButton("FETCH");
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				label_2.setText("");
				label_3.setText("");
				String enteredDate=textField_5.getText();
				if(validationDate(enteredDate)!="fine"){
					label_2.setText("Enter Valid date");
				}
				else
				{
				int stat=1;
				Date attendanceDate = null;
				DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
				DateFormat formatter = new SimpleDateFormat("MM dd yyyy");

				try {
					attendanceDate = parser.parse(textField_5.getText());
				} catch (ParseException e1) {
					stat=0;
					e1.printStackTrace();
				}

				if(stat==1)
				{
					String course=(String) list_6.getSelectedValue();
					int idx = list_6.getSelectedIndex();
	
					if (idx==-1)
					{
						label_2.setText("Choose a Course");
					}
					else{
						String status = null;
						//Call fetchAttendance of Controller to show attendance information
						String attendanceArray[] = AttendanceController.fetchAttendance(attendanceDate,course);
						
						// Declaring Object which would hold table data
						Object rowData[][] = new Object[attendanceArray.length][4];
						
						//attendanceArray contains data in the format "stringAttendDate+"	"+classNumber+"	"+netID+"	"+0"
						//extracting data from attendanceArray and filling into rowData to be added as table row
						for(int i=0;i<attendanceArray.length;i++)
						{
							String stringAttendDate=attendanceArray[i].split("	")[0];
							String classNumber=attendanceArray[i].split("	")[1];
							String netID=attendanceArray[i].split("	")[2];
							String attendance=attendanceArray[i].split("	")[3];
							
							
							rowData[i][0]=stringAttendDate;
							rowData[i][1]=classNumber;
							rowData[i][2]=netID;
							if(Integer.parseInt(attendance)==0)
							{
								rowData[i][3]=false;
							}
							else
							{
								rowData[i][3]=true;
							}
						}
						
						String[] columnNames = {"Date", "Class Number", "Net ID", "Present"};

						DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
				        table = new JTable(model){

				            private static final long serialVersionUID = 1L;

				            /*@Override
				            public Class getColumnClass(int column) {
				            return getValueAt(0, column).getClass();
				            required for the checkboxes
				            }*/
				            @Override
				            public Class getColumnClass(int column) {
				                switch (column) {
				                    case 0:
				                        return String.class;
				                    case 1:
				                        return String.class;
				                    case 2:
				                        return String.class;
				                    default:
				                        return Boolean.class;
				                }
				            }
				        };;
				        scrollPane_9.add(table);
				        scrollPane_9.setViewportView(table);
				        panel.add(scrollPane_9);
				        scrollPane_9.setVisible(true);
					}
				}
				}
			}
		});
		btnFetch.setBounds(20, 347, 89, 23);
		panel.add(btnFetch);
		
		label_2 = new JLabel("");
		label_2.setBounds(317, 11, 168, 14);
		panel.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(10, 381, 465, 14);
		panel.add(label_3);
		
		JLabel lblNewLabel_3 = new JLabel("Fetch the Student Records, for a particular date and course, to SAVE or UPDATE ");
		lblNewLabel_3.setBounds(10, 401, 475, 14);
		panel.add(lblNewLabel_3);
		
		button_5 = new JButton("Refresh");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshCourse();
			}
		});
		button_5.setBounds(10, 61, 89, 23);
		panel.add(button_5);
		
		panel_1 = new JPanel();
		tabbedPane1.addTab("Course", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("5 digit Class Number:");
		lblNewLabel.setBounds(10, 11, 143, 14);
		panel_1.add(lblNewLabel);
		
		lblCourseName = new JLabel("Course Name:");
		lblCourseName.setBounds(10, 36, 143, 14);
		panel_1.add(lblCourseName);
		
		lblSubjectPrefixexCs = new JLabel("Subject Prefix(e.x. CS):");
		lblSubjectPrefixexCs.setBounds(10, 61, 143, 14);
		panel_1.add(lblSubjectPrefixexCs);
		
		lblCourseNumber = new JLabel("Course Number:");
		lblCourseNumber.setBounds(10, 86, 143, 14);
		panel_1.add(lblCourseNumber);
		
		lblSectionNumber = new JLabel("Section Number:");
		lblSectionNumber.setBounds(10, 111, 143, 14);
		panel_1.add(lblSectionNumber);
		
		lblSemester = new JLabel("Semester:");
		lblSemester.setBounds(10, 136, 143, 14);
		panel_1.add(lblSemester);
		
		crsClassNoTF = new JTextField();
		crsClassNoTF.setBounds(153, 11, 86, 20);
		panel_1.add(crsClassNoTF);
		crsClassNoTF.setColumns(10);
		
		crsCourseNmTF = new JTextField();
		crsCourseNmTF.setBounds(153, 36, 86, 20);
		panel_1.add(crsCourseNmTF);
		crsCourseNmTF.setColumns(10);
		
		crsSubPrefTF = new JTextField();
		crsSubPrefTF.setBounds(153, 61, 86, 20);
		panel_1.add(crsSubPrefTF);
		crsSubPrefTF.setColumns(10);
		
		crsCourseNoTF = new JTextField();
		crsCourseNoTF.setBounds(153, 86, 86, 20);
		panel_1.add(crsCourseNoTF);
		crsCourseNoTF.setColumns(10);
		
		crsSecNoTF = new JTextField();
		crsSecNoTF.setBounds(153, 111, 86, 20);
		panel_1.add(crsSecNoTF);
		crsSecNoTF.setColumns(10);
		
		//View Courses
		btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				crsTextArea_1.setText("");
				crsClassNoTF.setText("");
				crsCourseNmTF.setText("");
				crsSubPrefTF.setText("");
				crsCourseNoTF.setText("");
				crsSecNoTF.setText("");
				crsSemesterTF.setText("");
				//Call viewCourse of Controller
				String[] lines=AttendanceController.viewCourse();
				crsTextArea_1.setText("ClassNo	CourseNm	SubPref	CourseNo	SecNo	Semester");
				crsTextArea_1.append("\n");
				//Append the lines returned by viewCourse to TextArea
				for(int i=0;i<lines.length;i++)
				{
					crsTextArea_1.append(lines[i]+"\n");
				}
			}
		});
		btnView.setBounds(10, 161, 89, 23);
		panel_1.add(btnView);
		
		//ADD Courses
		btnAdd_2 = new JButton("ADD");
		btnAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String classNumber=crsClassNoTF.getText();
				String courseName=crsCourseNmTF.getText();
				String subjectPrefix=crsSubPrefTF.getText();
				String courseNumber=crsCourseNoTF.getText();
				String sectionNumber=crsSecNoTF.getText();
				String semester=crsSemesterTF.getText();
				
				crsTextArea_1.setText("");
				crsClassNoTF.setText("");
				crsCourseNmTF.setText("");
				crsSubPrefTF.setText("");
				crsCourseNoTF.setText("");
				crsSecNoTF.setText("");
				crsSemesterTF.setText("");
				
				
				if(validationNum(classNumber,5)!="fine"||validationAlphaNum(courseName)!="fine"||validationAlphaNum(subjectPrefix)!="fine"||validationNum(courseNumber)!="fine"||validationNum(sectionNumber)!="fine"||validationAlphaNum(semester)!="fine")
				{
					crsTextArea_1.setText("Check if all the above fields are filled in following format:\n"
							+ "classNumber is numeric of 5 digits\n"
							+ "courseName, subjectPrefix and semester are AlphaNumeric\n"
							+ "courseNumber and sectionNumber are numeric.");
				}
				else
				{
					String status = null;
					try {
						//Call createCourseObject of Controller to Add Courses
						status = AttendanceController.createCourseObject(classNumber,courseName,subjectPrefix,courseNumber,sectionNumber,semester);
					} catch (IOException e) {
						e.printStackTrace();
					}
					if(status=="Fine")
					{
						crsTextArea_1.setText("Course added Successfully with Class Number"+classNumber);
					}
					else
					{
						crsTextArea_1.setText("There is some problem");
					}
				}
								
			}
		});
		btnAdd_2.setBounds(109, 161, 89, 23);
		panel_1.add(btnAdd_2);
		
		//Updating Courses
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String classNumber=crsClassNoTF.getText();
				String courseName=crsCourseNmTF.getText();
				String subjectPrefix=crsSubPrefTF.getText();
				String courseNumber=crsCourseNoTF.getText();
				String sectionNumber=crsSecNoTF.getText();
				String semester=crsSemesterTF.getText();
				
				crsTextArea_1.setText("");
				crsClassNoTF.setText("");
				crsCourseNmTF.setText("");
				crsSubPrefTF.setText("");
				crsCourseNoTF.setText("");
				crsSecNoTF.setText("");
				crsSemesterTF.setText("");
				
				if(validationNum(classNumber,5)!="fine"||validationAlphaNum(courseName)!="fine"||validationAlphaNum(subjectPrefix)!="fine"||validationNum(courseNumber)!="fine"||validationNum(sectionNumber)!="fine"||validationAlphaNum(semester)!="fine")
				{
					crsTextArea_1.setText("Check if all the above fields are filled in following format:\n"
							+ "classNumber is numeric of 5 digits\n"
							+ "courseName, subjectPrefix and semester are AlphaNumeric\n"
							+ "courseNumber and sectionNumber are numeric.");
				}
				else
				{
					//Call updateCourseObject of Controller to Update Courses
					String status=AttendanceController.updateCourseObject(classNumber,courseName,subjectPrefix,courseNumber,sectionNumber,semester);
					if(status=="Fine")
					{
						crsTextArea_1.setText("Course Updated or Added Successfully with Class Number"+classNumber);
					}
					else
					{
						crsTextArea_1.setText("There is some problem, check the class Number.");
					}
				}
				
			}
		});
		btnUpdate.setBounds(208, 161, 89, 23);
		panel_1.add(btnUpdate);
		
		//Delete Courses
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String classNumber=crsClassNoTF.getText();
				
				crsTextArea_1.setText("");
				crsClassNoTF.setText("");
				crsCourseNmTF.setText("");
				crsSubPrefTF.setText("");
				crsCourseNoTF.setText("");
				crsSecNoTF.setText("");
				crsSemesterTF.setText("");
				
				
				if(validationNum(classNumber,5)!="fine")
				{
					crsTextArea_1.setText("You need to provide a valid 5 digit numeric class number to be deleted");
				}
				else
				{
					String status = null;
					//Call createCourseObject of Controller to Add Courses
					status = AttendanceController.deleteCourseObject(classNumber);
					if(status=="Fine")
					{
						crsTextArea_1.setText("Course deleted Successfully if present with Class Number"+classNumber);
					}
					else
					{
						crsTextArea_1.setText("There is some problem");
					}
				}
			}
		});
		btnDelete.setBounds(307, 161, 89, 23);
		panel_1.add(btnDelete);
		
		crsSemesterTF = new JTextField();
		crsSemesterTF.setBounds(153, 136, 86, 20);
		panel_1.add(crsSemesterTF);
		crsSemesterTF.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 186, 445, 145);
		panel_1.add(scrollPane);
		
		crsTextArea_1 = new JTextArea();
		scrollPane.setViewportView(crsTextArea_1);
		
		JLabel lblNoteAddRequires = new JLabel("Note: ADD and UPDATE requires all the fields. DELETE requires Class Number. ");
		lblNoteAddRequires.setBounds(10, 342, 445, 22);
		panel_1.add(lblNoteAddRequires);
		
		
		
		panel_2 = new JPanel();
		tabbedPane1.addTab("Student", null, panel_2, null);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Net ID:");
		lblNewLabel_1.setBounds(10, 11, 120, 14);
		panel_2.add(lblNewLabel_1);
		
		lblFname = new JLabel("First Name:");
		lblFname.setBounds(10, 36, 120, 14);
		panel_2.add(lblFname);
		
		lblMinit = new JLabel("MInIt:");
		lblMinit.setBounds(10, 61, 120, 14);
		panel_2.add(lblMinit);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 86, 120, 14);
		panel_2.add(lblLastName);
		
		textField = new JTextField();
		textField.setBounds(121, 8, 86, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 36, 86, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(121, 61, 86, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(121, 86, 86, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		//View Students
		btnView_1 = new JButton("VIEW");
		btnView_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textArea.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				//Call viewCourse of Controller
				String[] lines=AttendanceController.viewStudent();
				textArea.setText("NetID	FirstName	MInIt	LastName");
				textArea.append("\n");
				//Append the lines returned by viewCourse to TextArea
				for(int i=0;i<lines.length;i++)
				{
					textArea.append(lines[i]+"\n");
				}
				
				}
				
			});
		btnView_1.setBounds(10, 175, 89, 23);
		panel_2.add(btnView_1);
		//Adding Students
		btnAdd_1 = new JButton("ADD");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String netID=textField.getText();
				String firstName=textField_1.getText();
				String mInIt=textField_2.getText();
				String lastName=textField_3.getText();
				String course=(String) list_1.getSelectedValue();
				int idx = list_1.getSelectedIndex();

				textArea.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				
				if(validationAlphaNum(netID)!="fine"||validationAlphaNum(firstName)!="fine"||validationAlphaNum(firstName)!="fine")
				{
					textArea.setText("Check if Alpha Numeric values of netID, firstName and lastName have been provided.");
				}
				else
				{
					if (idx!=-1)
					{

						textField_4.setText("");
						String status = null;
						//Call createStudentToCourseObject of Controller to Add StudentToCourse relationship
						status = AttendanceController.createStudentToCourseObject(netID,course);
						if(status=="Fine")
						{
							textArea_1.setText("Student added to Course Successfully with NetID: "+netID);
						}
						else
						{
							textArea_1.setText("There is some Problem");
						}
					}
					String status = null;
					//Call createCourseObject of Controller to Add Courses
					status = AttendanceController.createStudentObject(netID,firstName,mInIt,lastName);
					if(status=="Fine")
					{
						textArea.setText("Student added Successfully with NetID: "+netID);
					}
					else
					{
						textArea.setText("There is some problem");
					}
				}
			}
		});
		btnAdd_1.setBounds(109, 175, 89, 23);
		panel_2.add(btnAdd_1);
		//Update Student Names based on NetID
		btnUpdate_1 = new JButton("UPDATE");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String netID=textField.getText();
				String firstName=textField_1.getText();
				String mInIt=textField_2.getText();
				String lastName=textField_3.getText();

				textArea.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				//System.out.println("Inside Add1");
				
				if(validationAlphaNum(netID)!="fine"||validationAlphaNum(firstName)!="fine"||validationAlphaNum(firstName)!="fine")
				{
					textArea.setText("Check if Alpha Numeric values of netID, firstName and lastName have been provided.");
				}
				else
				{
					String status = null;
					//Call createCourseObject of Controller to Add Courses
					status = AttendanceController.updateStudentObject(netID,firstName,mInIt,lastName);
					if(status=="Fine")
					{
						textArea.setText("Student updated Successfully with NetID: "+netID);
					}
					else
					{
						textArea.setText("There is some problem");
					}
				}
			}
		});
		btnUpdate_1.setBounds(208, 175, 89, 23);
		panel_2.add(btnUpdate_1);
		
		btnDelete_1 = new JButton("DELETE");
		//Deleting Students
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String netID=textField.getText();
				textArea.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				
				
				if(validationAlphaNum(netID)!="fine")
				{
					textArea.setText("You need to provide a valid netID to be deleted");
				}
				else
				{
					String status = null;
					//Call deleteStudentObject of Controller to delete Students
					status = AttendanceController.deleteStudentObject(netID);
					if(status=="Fine")
					{
						textArea.setText("Student deleted Successfully if present with netID: "+netID);
					}
					else
					{
						textArea.setText("There is some problem, check whether proper netID is provided.");
					}
				}
			}
		});
		btnDelete_1.setBounds(307, 175, 89, 23);
		panel_2.add(btnDelete_1);
		
		lblCourse = new JLabel("Course:");
		lblCourse.setBounds(10, 111, 105, 14);
		panel_2.add(lblCourse);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(121, 111, 289, 54);
		panel_2.add(scrollPane_1);
		

		list_1 = new JList(loadCourses());
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(list_1);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 210, 400, 133);
		panel_2.add(scrollPane_2);
		
		textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
		
		lblNoteAddAnd = new JLabel("Note: ADD and UPDATE requires all the fields. DELETE requires Net ID. ");
		lblNoteAddAnd.setBounds(10, 354, 445, 22);
		panel_2.add(lblNoteAddAnd);
		
		btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				refreshCourse();
			}
		});
		btnNewButton.setBounds(10, 136, 89, 23);
		panel_2.add(btnNewButton);
		
		panel_4 = new JPanel();
		tabbedPane1.addTab("StudentToCourse", null, panel_4, null);
		panel_4.setLayout(null);
		
		label = new JLabel("Net ID:");
		label.setBounds(10, 14, 120, 14);
		panel_4.add(label);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(121, 11, 86, 20);
		panel_4.add(textField_4);
		
		label_1 = new JLabel("Course:");
		label_1.setBounds(10, 39, 105, 14);
		panel_4.add(label_1);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(121, 39, 290, 55);
		panel_4.add(scrollPane_3);
		
		list_2 = new JList(loadCourses());
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(list_2);
		
		//View Student to Courses relationship
		button = new JButton("VIEW");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String netID=textField_4.getText();
				String course=(String) list_2.getSelectedValue();
				int idx = list_2.getSelectedIndex();
				textArea_1.setText("");
				textField_4.setText("");
				
				//Call viewStudentToCourse of Controller
				String[] lines=AttendanceController.viewStudentToCourse(netID,course);
				textArea_1.setText("NetID	CourseNumber");
				textArea_1.append("\n");
				//Append the lines returned by viewCourse to TextArea
				for(int i=0;i<lines.length;i++)
				{
					textArea_1.append(lines[i]+"\n");
				}
			}
		});
		button.setBounds(10, 115, 89, 23);
		panel_4.add(button);
		
		//ADD Student to Courses relationship
		button_1 = new JButton("ADD");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea_1.setText("");
				String netID=textField_4.getText();
				String course=(String) list_2.getSelectedValue();
				int idx = list_2.getSelectedIndex();
				
				if(validationAlphaNum(netID)!="fine")
				{
					textArea_1.setText("Enter a valid Student NetID.");
				}
				else
				{
					if (idx==-1)
					{
						textArea_1.setText("Choose a Course to add for the Student.");
					}
					else{
						textField_4.setText("");
						String status = null;
						//Call createStudentToCourseObject of Controller to Add StudentToCourse relationship
						status = AttendanceController.createStudentToCourseObject(netID,course);
						if(status=="Fine")
						{
							textArea_1.setText("Student added to Course Successfully with NetID: "+netID);
						}
						else
						{
							textArea_1.setText("There is some Problem");
						}
					}
				}
				
			}
		});
		button_1.setBounds(109, 115, 89, 23);
		panel_4.add(button_1);
		//Delete Student from Courses
		button_2 = new JButton("DELETE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea_1.setText("");
				String netID=textField_4.getText();
				String course=(String) list_2.getSelectedValue();
				int idx = list_2.getSelectedIndex();
				
				if(validation(netID)!="fine")
				{
					textArea_1.setText("Enter a valid Student NetID.");
				}
				else
				{
					if (idx==-1)
					{
						textArea_1.setText("Choose a Course to be delete for the Student.");
					}
					else{
						textField_4.setText("");
						String status = null;
						//Call deleteStudentObject of Controller to delete Students
						status = AttendanceController.deleteStudentToCourseObject(netID,course);
						if(status=="Fine")
						{
							textArea_1.setText("Student to Course entry deleted Successfully if present with netID: "+netID);
						}
						else
						{
							textArea_1.setText("There is some problem, check whether proper netID and course is provided.");
						}
					}
				}
				
			}
		});
		button_2.setBounds(208, 115, 89, 23);
		panel_4.add(button_2);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 149, 404, 183);
		panel_4.add(scrollPane_4);
		
		textArea_1 = new JTextArea();
		scrollPane_4.setViewportView(textArea_1);
		
		lblNoteAddAnd_1 = new JLabel("Note: ADD and DELETE requires both Net ID and Course");
		lblNoteAddAnd_1.setBounds(10, 343, 445, 22);
		panel_4.add(lblNoteAddAnd_1);
		
		button_3 = new JButton("Refresh");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refreshCourse();
			}
		});
		button_3.setBounds(10, 64, 89, 23);
		panel_4.add(button_3);
		
		panel_3 = new JPanel();
		tabbedPane1.addTab("Report", null, panel_3, null);
		panel_3.setLayout(null);
		
		label_4 = new JLabel("Course:");
		label_4.setBounds(10, 11, 105, 14);
		panel_3.add(label_4);
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(121, 11, 290, 45);
		panel_3.add(scrollPane_5);
		
		list_3 = new JList(loadCourses());
		scrollPane_5.setViewportView(list_3);
		list_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		//Show Chart of all students in a particular course
		btnChart = new JButton("CHART");
		btnChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel_2.setText("");
				String course=(String) list_3.getSelectedValue();
				int idx = list_3.getSelectedIndex();
				if (idx==-1)
				{
					lblNewLabel_2.setText("Choose a Course to show report.");
				}
				else{

					String status = null;
					//Call fetchReportChart of Controller to show chart report information			
					String[] reportData = AttendanceController.fetchReportChart(course);

					//reportData contains data in the format a1.getAttendanceDate())+"	"+a1.getNetID()+"	"+a1.getStatus()
					//extracting data from reportData and filling into netIDArray and dateArray to be added as table row and column
					ArrayList<String> netIDArray = new ArrayList<String>();
					ArrayList<String> dateArray = new ArrayList<String>();
					
					for(int i=0;i<reportData.length;i++)
					{
						String stringAttendDate=reportData[i].split("	")[0];
						String netID=reportData[i].split("	")[1];
						String attendance=reportData[i].split("	")[2];
						
						//Adding unique netIDs taking the course
						int netIDOccurenceCount=0;
						if(!netIDArray.isEmpty()){
							for(int k=0;k<netIDArray.size();k++){
								if(netID.equals(netIDArray.get(k))){
									netIDOccurenceCount++;
								}
							}
						}
						if(netIDOccurenceCount==0){
							netIDArray.add(netID);
						}
						
						//Adding unique dates for which attendance have been recorded
						int dateOccurenceCount=0;
						if(!dateArray.isEmpty()){
							for(int l=0;l<dateArray.size();l++){
								if(stringAttendDate.equals(dateArray.get(l))){
									dateOccurenceCount++;
								}
							}
						}
						
						if(dateOccurenceCount==0){
							dateArray.add(stringAttendDate);
						}
						
					}
					
					int noOfIDs=netIDArray.size();
					int noOfDates=dateArray.size();
					
					//Array for storing Attendances
					int[][] attendanceArray=new int[noOfIDs][noOfDates];
					//initializing the array to 0 for all attendances
					for(int i=0;i<noOfIDs;i++)
					{
						for(int j=0;j<noOfDates;j++)
						{
							attendanceArray[i][j]=0;
						}
					}
					
					
					//extracting the attendence information from reportData
					for(int i=0;i<noOfIDs;i++)
					{
						for(int j=0;j<noOfDates;j++)
						{
							for(int k=0;k<reportData.length;k++)
							{
								String stringAttendDate=reportData[k].split("	")[0];
								String netID=reportData[k].split("	")[1];
								int attendance=Integer.parseInt(reportData[k].split("	")[2]);
								
								if((netIDArray.get(i)).equals(netID) && dateArray.get(j).equals(stringAttendDate))
								{
									attendanceArray[i][j]=attendance;
								}
								
							}
						}
					}
					
					
					// Declaring Object which would hold table data
					Object rowData[][] = new Object[noOfIDs][noOfDates+1];
					
					//filling in the rows with first column being the netIDs
					for(int i=0;i<noOfIDs;i++)
					{
						for(int j=0;j<noOfDates+1;j++)
						{
							if(j==0)
							{
								rowData[i][j]=netIDArray.get(i);
							}
							else{
								rowData[i][j]=attendanceArray[i][j-1];
							}
						}
						
					}
					
					//filling the columns the first being netID and the rest being the dates
					String[] columnNames = new String[noOfDates+1];
					columnNames[0]="netID";
					for(int i=0;i<noOfDates;i++)
					{
						columnNames[i+1]=dateArray.get(i);
					}
					
					DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
			        table_1 = new JTable(model){

			            private static final long serialVersionUID = 1L;

			            /*@Override
			            public Class getColumnClass(int column) {
			            return getValueAt(0, column).getClass();
			            required for the checkboxes if there is any
			            }*/
					     @Override
			           public Class getColumnClass(int column) {
			                switch (column) {
			                    case 0:
			                        return String.class;
			                    default:
			                        return String.class;
			                }
			            }
			        };
			        scrollPane_6.add(table_1);
			        scrollPane_6.setViewportView(table_1);
			        panel_3.add(scrollPane_6);
			        scrollPane_6.setVisible(true);
				}
			}
		});
		btnChart.setBounds(10, 77, 89, 23);
		panel_3.add(btnChart);
		//Show Graph presence of all students in a particular course based on date
		btnGraph = new JButton("GRAPH");
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setText("");
				String course=(String) list_3.getSelectedValue();
				int idx = list_3.getSelectedIndex();
				if (idx==-1)
				{
					lblNewLabel_2.setText("Choose a Course to show report.");
				}
				else{
					String status = null;
					//Call fetchReportChart of Controller to show chart report information
					String[] reportData = AttendanceController.fetchReportChart(course);

					//reportData contains data in the format a1.getAttendanceDate())+"	"+a1.getNetID()+"	"+a1.getStatus()
					//extracting data from reportData and filling into netIDArray and dateArray to be added as table row and column
					ArrayList<String> netIDArray = new ArrayList<String>();
					ArrayList<String> dateArray = new ArrayList<String>();
					
					for(int i=0;i<reportData.length;i++)
					{
						String stringAttendDate=reportData[i].split("	")[0];

						//Adding unique dates for which attendance have been recorded
						int dateOccurenceCount=0;
						if(!dateArray.isEmpty()){
							for(int l=0;l<dateArray.size();l++){
								if(stringAttendDate.equals(dateArray.get(l))){
									dateOccurenceCount++;
								}
							}
						}
						
						if(dateOccurenceCount==0){
							dateArray.add(stringAttendDate);
						}
					}

					int noOfDates=dateArray.size();
					
					//Arrays for storing Attendances
					int[] presentArray=new int[noOfDates];
					int[] absentArray=new int[noOfDates];
					
					//initializing the arrays to 0 for all dates
					for(int i=0;i<noOfDates;i++)
					{
						presentArray[i]=0;
						absentArray[i]=0;
					}
					
					//extracting the attendence information from reportData
					for(int i=0;i<noOfDates;i++)
					{
						int present=0,absent=0;
						for(int k=0;k<reportData.length;k++)
						{
							String stringAttendDate=reportData[k].split("	")[0];
							int attendance=Integer.parseInt(reportData[k].split("	")[2]);
							
							if(dateArray.get(i).equals(stringAttendDate))
							{
								if(attendance==1)present++;
								else absent++;
							}
						}
						presentArray[i]=present;
						absentArray[i]=absent;
					}
					
					JFrame f = new JFrame();
			        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        f.getContentPane().add(new GraphingData());
			        f.setSize(400,400);
			        f.setLocation(200,200);
			        f.setVisible(true);
				}
			}
		});
		btnGraph.setBounds(121, 77, 89, 23);
		panel_3.add(btnGraph);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(231, 81, 244, 14);
		panel_3.add(lblNewLabel_2);
		
		button_4 = new JButton("Refresh");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refreshCourse();
			}
		});
		button_4.setBounds(10, 36, 89, 23);
		panel_3.add(button_4);
		
		lblRepresentsPresent = new JLabel("\"1\" represents present, \"0\" represents absent in the chart");
		lblRepresentsPresent.setBounds(10, 390, 465, 14);
		panel_3.add(lblRepresentsPresent);
		
		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 111, 465, 337);
		
		table_1 = new JTable();
	}
	
	public String[] loadCourses()
    {
		String[] lineArray = null;
		String courseString;
		//Call viewCourse of Controller
		String[] lines=AttendanceController.viewCourse();
		
		String[] allCourses = new String[lines.length];

		//Append the lines returned by viewCourse to list
		for(int i=0;i<lines.length;i++)
		{
			lineArray = lines[i].split("	");	
			courseString=(lineArray[0]+","+lineArray[1]+","+lineArray[2]+lineArray[3]+"."+lineArray[4]+","+lineArray[5]);
			allCourses[i]=courseString;
		}

		return allCourses;
    }
	
	//Method for validating String inputs
    public String validation(String input)
    {
        String newline = System.getProperty("line.separator");
        boolean hasNewline = input.contains(newline);
    
        if ((input.trim().length() == 0) || (hasNewline))
        {
            return "blank";
        }
        else if (input.contains(";") || input.contains("\""))
        {
            return "invalid";
        }
        else
        {
            return "fine";
        }
        
     }
  //Method for validating String Date inputs
    public String validationDate(String input)
    {
    	String checkformat="invalid";
    	if(validation(input)=="fine")
    	{
    		if (input.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
    		    checkformat="fine";
    	}
		return checkformat;
    }
  //Method for validating String alpha numeric inputs
    public String validationAlphaNum(String input)
    {
    	String checkformat="invalid";
    	if(validation(input)=="fine")
    	{
    		if (input.matches("[A-Za-z0-9 _.,!]*"))
    		    checkformat="fine";
    	}
		return checkformat;
    }
    
  //Method for validating String alpha numeric inputs of certain lengths
    public String validationAlphaNum(String input,int length)
    {
    	String checkformat="invalid";
    	if(validation(input)=="fine" && input.length()==length)
    	{
    		if (input.matches("[A-Za-z0-9]+"))
    		    checkformat="fine";
    	}
		return checkformat;
    }
    
  //Method for validating String numeric inputs 
    public String validationNum(String input)
    {
    	String checkformat="invalid";
    	if(validation(input)=="fine")
    	{
    		if (input.matches("[0-9]+"))
    		    checkformat="fine";
    	}
		return checkformat;
    }
    
    //Method for validating String numeric inputs of certain lengths 
    public String validationNum(String input,int length)
    {
    	String checkformat="invalid";
    	if(validation(input)=="fine")
    	{
    		if (input.matches("[0-9]+") && input.length()==length)
    		    checkformat="fine";
    	}
		return checkformat;
    }
    
  //Method for refreshing courses 
    public void refreshCourse()
    {
    	list_1 = new JList(loadCourses());
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(list_1);
		
		list_6 = new JList(loadCourses());
		scrollPane_8.setViewportView(list_6);
		list_6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list_2 = new JList(loadCourses());
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(list_2);
		
		list_3 = new JList(loadCourses());
		scrollPane_5.setViewportView(list_3);
		list_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	
    }
}
