package studio9;

import assignment7.Student;
import java.util.Map;

public class UniversityDatabase {
	private final Map<String, Student> Data;
	
	/**
	 * @param data
	 */
	public UniversityDatabase(Map<String, Student> data) {
		super();
		Data = data;
	}

	//TODO: Complete this class according to the studio instructions

	public void addStudent(String accountName, Student student) {
		Data.put(accountName, student);
	}

	public int getStudentCount() {
		return Data.size();
	}

	public String lookupFullName(String accountName) {
			Student student = Data.get(accountName);
			if (student == null) {
				return "null";
			}
			else {
				return student.getFullName();
			}
		}

	
			
	

	public double getTotalBearBucks() {
		for (String s: ) {
			if (wordCount.get(s) == null) {
				wordCount.put(s, 1);
	}
}
