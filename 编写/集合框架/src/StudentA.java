

public class StudentA  implements Comparable<StudentA>{
	private String name;
	private String gender;
	private int ID;
	
	public StudentA()  {
		// TODO Auto-generated constructor stub
	}

	public StudentA(String name, String gender, int iD) {
		super();
		this.name = name;
		this.gender = gender;
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	//比较规则 比较学号
	public int compareTo(StudentA o) {
		
		return this.ID-o.ID;
	}
	
	
	
}
