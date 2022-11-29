package assignment7;

public class Student {
	
	private String first;
	   private String last;
	   private int ID;
	   private int attempt;
	   private int pass;
	   private double QualityPoint;
	   private double bear;
	
	   
	   public Student(String theFirst, String theLast, int num) {
			  first = theFirst;
			  last = theLast;
			  ID = num;
		  }
		/**
		 * 
		 * @return full name as string
		 */
	   public String getFullName() {
		   return first +" "+last;
	   }
	   /**
	    * 
	    * @return student ID
	    */
	  public int getId(){
		   return ID;
	   }
	  /**
	   * 
	   * @param grade grade of student
	   * @param credits credits for class
	   */
	  public void submitGrade(double grade, int credits) {
			QualityPoint = QualityPoint+ grade * credits;
			attempt = attempt +credits;
			if(grade>=1.7)
				pass = pass+credits;
	  }
	  /**
	   * 
	   * @return passing credits
	   */
	 public int getTotalPassingCredits() {
		 return pass;
	 }
	  /**
	   * 
	   * @return attempted credits
	   */
	 public int getTotalAttemptedCredits() {
		 return attempt;
	 }
	 /**
	  * 
	  * @return GPA
	  */
	public double calculateGradePointAverage() {
		return QualityPoint/getTotalAttemptedCredits();
	}
	
	public String getClassStanding() {
		if (getTotalPassingCredits()<30)
			return "First Year";
		else if (getTotalPassingCredits()<60 && getTotalPassingCredits() >=30)
			return "Sophomore";
		else if (getTotalPassingCredits()<90 && getTotalPassingCredits() >=60)
			return "Junior";
		else
			return "Senior";
	}
	/**
	 * 
	 * @return if student can join PBK
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (getTotalAttemptedCredits()>=98 && calculateGradePointAverage() >=3.6)
			return true;
		else if (getTotalAttemptedCredits()>=75 && calculateGradePointAverage() >=3.8)
			return true;
		else 
			return false;
	}
	/**
	 * 
	 * @param amount amount added
	 */
	public void depositBearBucks(double amount) {
		bear = bear + amount;
	}
	/**
	 * 
	 * @param amount amount deduceted
	 */
	public void deductBearBucks(double amount) {
		bear = bear - amount;
	}
	/**
	 * 
	 * @return bear bucks
	 */
	public double getBearBucksBalance() {
		return bear;
	}
/**
 * 
 * @return bear bucks after being zeroed
 */
	public double cashOutBearBucks() {
		if (getBearBucksBalance()<=10) {
			bear = 0;
			return getBearBucksBalance();
		}
		else {
			double place = getBearBucksBalance();
			place = place-10;
			bear =0;
			return place;
		}
	}
	/** create a legacy method
	 * 
	 * @param firstName student first name
	 * @param other student
	 * @param isHyphenated whether the last name will be hyphenated
	 * @param id student id
	 * @return a new student with bear bucks added
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String stud = "";
		
		if (isHyphenated == true) 
			stud = this.last +"-"+other.last;
		else
			stud = this.last;

		Student legacy = new Student(firstName, stud, id);
		legacy.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
		return legacy;
	}
/**
 * returns student as string
 */
	public String toString() {
		return first+" "+last+" "+ID;
	}
}
