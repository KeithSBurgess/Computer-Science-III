package cs244.robward;

public class Student implements Comparable<Student> {
	
	@Override
	public String toString() {
		return "Student [lastName=" + lastName + ", ID=" + ID + ", getAverage()=" + getAverage() + "]";
	}

	private String firstName = "";
	private String lastName = "";
	private String ID = "";
	
	private int numberOfGrades = 0;
	private double[] grades = new double[10];
	
	
	
	public Student(String firstName, String lastName, String iD) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		ID = iD;
	}
	public Student( String iD) {
		super();
		ID = iD;
	}
	
		
	public Double getAverage()
	{
		if (numberOfGrades == 0)
		{
			return 0.0;
		}
		
		double total = 0;
		for (int i = 0; i < numberOfGrades; i++) {
			total += grades[i];
		}
	
		return  total / numberOfGrades;
	}
	
	public String getLetterGrade()
	{
		int average = ((int)Math.round(getAverage()) / 10);
		switch (average)
		{
			case 9:
				return "A";
			case 8:
				return "B";
			case 7:
				return "C";
			case 6:
				return "D";
			default:
				return "F";
			
		}
		
		
	}
	
	
	
	public Double getGrade(int gradeToGet) {
		
		if(gradeToGet < 0 ||  gradeToGet > numberOfGrades )
		{
			System.err.println("Error Grade request out of bounds%n");
			System.err.printf("Grade requested %d out of %d grades%n", gradeToGet, numberOfGrades);
			return -1.0;
			
		}
		
		return grades[gradeToGet];
	}

	
	 private void  resize() {

		    double[] tmp = new double[2*grades.length];
		    
		    System.arraycopy(grades,0,tmp,0,grades.length); 
		    
		    grades = tmp;
	}
	 
	public void addGrade(double grade) {
		
		if(numberOfGrades >= grades.length )
		{
			resize();
		}
		if(grade > 110)
		{
			grade = 110;
			
		}
		if(grade < 0)
		{
			grade = 0;
			
		}
		this.grades[numberOfGrades] = grade;
		numberOfGrades++;
	}

	
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getID() {
		return ID;
	}
	
	public int getNumberOfGrades() {
		return numberOfGrades;
	}
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return getAverage().compareTo(o.getAverage());
	}
	
	
	

}
