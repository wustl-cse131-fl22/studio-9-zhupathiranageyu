package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int studentId;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;

	/**
	 * Constructor that declares how to create a new Student object
	 * 
	 * @param firstName the first name of the Student
	 * @param lastName  the last name of the Student
	 * @param studentID the unique student ID number of the Student
	 */
	public Student(String firstName, String lastName, int studentId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
	}

	/**
	 * Method that returns the Student's first and last name
	 * 
	 * @return the Student's first and last name
	 */
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	/**
	 * Method that returns the Student's student ID number
	 * 
	 * @return the Student's student ID number
	 */
	public int getId() {
		return this.studentId;
	}

	/**
	 * Setter method that submits a grade to the Student object
	 * 
	 * @param grade   the grade of the course being submitted, between 0.0 and 4.0
	 *                (inclusive)
	 * @param credits the number of credits of the course being submitted
	 */
	public void submitGrade(double grade, int credits) {
		this.attemptedCredits = this.attemptedCredits + credits;
		if (1.7 <= grade && grade <= 4) {
			this.passingCredits = this.passingCredits + credits;
		}
		this.totalGradeQualityPoints = this.totalGradeQualityPoints + (credits * grade);
	}

	/**
	 * Method that returns the Student's total attempted credits of all submitted
	 * grades
	 * 
	 * @return the Student's total attempted credits
	 */
	public int getTotalAttemptedCredits() {
		return this.attemptedCredits;
	}

	/**
	 * Method that returns the Student's total passing credits -- credits with
	 * grades that are at least 1.7
	 * 
	 * @return the Student's total passing credits
	 */
	public int getTotalPassingCredits() {
		return this.passingCredits;
	}

	/**
	 * Method that returns the Student's total grade average of all submitted grades
	 * 
	 * @return the Student's grade average of all submitted grades
	 */
	public double calculateGradePointAverage() {
		return (this.totalGradeQualityPoints / this.attemptedCredits);
	}

	/**
	 * Method that returns the Student's class year depending on how many passing
	 * credits they have
	 * 
	 * @return the Student's class year
	 */
	public String getClassStanding() {
		if (this.passingCredits < 30) {
			return "First Year";
		} else if (this.passingCredits >= 30 && this.passingCredits < 60) {
			return "Sophomore";
		} else if (this.passingCredits >= 60 && this.passingCredits < 90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}

	/**
	 * Method that returns whether the student is eligible for PhiBetaKappa
	 * enrollment based on their grade average and number of passing credits
	 * 
	 * @return the Student's PhiBetaKappa enrollment eligibility
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (this.calculateGradePointAverage() >= 3.80) {
			if (this.attemptedCredits >= 75) {
				return true;
			}
		}
		if (this.calculateGradePointAverage() >= 3.60) {
			if (this.attemptedCredits >= 98) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Setter method that submits a deposit to the Student's Bear Bucks balance
	 * 
	 * @param amount the amount of the deposit to be added
	 */
	public void depositBearBucks(double amount) {
		this.bearBucksBalance = this.bearBucksBalance + amount;
	}

	/**
	 * Setter method that submits a deduction of the Student's Bear Bucks balance
	 * 
	 * @param amount the amount of the deposit to be deducted
	 */
	public void deductBearBucks(double amount) {
		this.bearBucksBalance = this.bearBucksBalance - amount;
	}

	/**
	 * Method that returns the Student's Bear Bucks balance
	 * 
	 * @return the Student's Bear Bucks balance
	 */
	public double getBearBucksBalance() {
		return this.bearBucksBalance;
	}

	/**
	 * Method that zeroes the Student's Bear Bucks balance and returns the amount in
	 * dollars that the Student will be reimbursed
	 * 
	 * @return the amount in dollars that the Student will be reimbursed
	 */
	public double cashOutBearBucks() {
		double tempBearBucks = this.bearBucksBalance - 10;
		this.bearBucksBalance = 0.0;
		if (tempBearBucks < 0) {
			tempBearBucks = 0;
		}
		return tempBearBucks;
	}

	/**
	 * Method that creates a new Student object based on this Student object and one
	 * other Student object
	 * 
	 * @param firstName    the first name of the new Student
	 * @param other        the spouse of this Student object
	 * @param isHyphenated determines whether the new Student's last name is a
	 *                     hyphenated combination of the two parents, or simply this
	 *                     Student's last name
	 * @param id           the student id of the new Student
	 * 
	 * @return the new Student object
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		if (isHyphenated) {
			String newLastName = this.lastName + "-" + other.lastName;
			Student Legacy = new Student(firstName, newLastName, id);
			Legacy.bearBucksBalance = Legacy.bearBucksBalance + this.cashOutBearBucks();
			Legacy.bearBucksBalance = Legacy.bearBucksBalance + other.cashOutBearBucks();
			return Legacy;
		}

		Student Legacy = new Student(firstName, this.lastName, id);
		Legacy.bearBucksBalance = Legacy.bearBucksBalance + this.cashOutBearBucks();
		Legacy.bearBucksBalance = Legacy.bearBucksBalance + other.cashOutBearBucks();

		return Legacy;
	}

	/**
	 * Method that returns a string of the Student's name and id
	 * 
	 * @return the Student's full name and student ID
	 */
	public String toString() {
		String stringId = "" + this.studentId;
		return this.firstName + " " + this.lastName + " " + stringId;
	}

}
