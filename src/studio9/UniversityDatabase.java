package studio9;

import assignment7.Student;

import java.util.HashMap;
import java.util.Map;

public class UniversityDatabase {
	private final Map<String, Student> database = new HashMap<>();

	public UniversityDatabase() {
	}

	public void addStudent(String accountName, Student student) {
		database.put(accountName, student);
	}

	public int getStudentCount() {
		return database.size();
	}

	public String lookupFullName(String accountName) {
		if (database.containsKey(accountName)) {
			Student bob = database.get(accountName);
			return bob.getFullName();
		}
		return null;
	}

	public double getTotalBearBucks() {
		double runningCount = 0.0;
		for (String accountName : database.keySet()) {
			Student billy = database.get(accountName);
			runningCount = runningCount + billy.getBearBucksBalance();
		}
		return runningCount;
	}

}
