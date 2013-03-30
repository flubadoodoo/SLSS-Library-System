package panel.library_func;

import guiElements.MLabelTextCombo;

import java.awt.Container;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.swingx.JXList;

import panel.abstractPanel.AbstractInnerPanel;
import user.student.Student;

@SuppressWarnings("serial")
public class LibraryStudentsScreen extends AbstractInnerPanel {
	
	JXList studentTable;
	MLabelTextCombo studentName;
	MLabelTextCombo studentID;
	
	public LibraryStudentsScreen(String panelName) {
		super(panelName);
	}
	
	public Container initialize() {
		super.initialize();
		studentName = new MLabelTextCombo("Name", "Student name", 100, 220, 300, this);
		studentName.getTextField().setEditable(false);
		
		studentID = new MLabelTextCombo("ID", "Student id", 100, 259, 300, this);
		studentID.getTextField().setEditable(false);
		
		studentTable = new JXList(getStudentArray(), true);
		studentTable.setBounds(100, 100, 200, 100);
		studentTable.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Student selectedStudent = (Student) ((JXList) e.getSource()).getSelectedValue();
				studentName.getTextField().setText(selectedStudent.getName());
				studentID.getTextField().setText(selectedStudent.getID());
			}
		});
		JScrollPane scrollPane = new JScrollPane(studentTable);
		scrollPane.setBounds(studentTable.getBounds());
		add(scrollPane);
		return this;
	}
	
	private Student[] getStudentArray() {
		File usrDir = new File("file/usr/");
		// create an array list of students
		ArrayList<Student> students = new ArrayList<Student>();
		// add all the students in the file/usr directory
		for (File file : usrDir.listFiles()) {
			if (file.getName().charAt(0) != 's' && file.getName().charAt(0) != 'S') {
				students.add(Student.getStudent(file.getName().substring(0, file.getName().length() - 4)));
			}
		}
		// create an array of students
		Student[] studentArray = new Student[students.size()];
		// transfer all the student in the array list to the array
		for (int i = 0; i < students.size(); i++) {
			studentArray[i] = students.get(i);
		}
		return studentArray;
	}
}
