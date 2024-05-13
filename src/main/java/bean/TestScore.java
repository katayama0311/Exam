package bean;

public class TestScore implements java.io.Serializable{
	private int entYear;
	private int classNum;
	private int studentNo;
	private String studentName;
	private int point;
	
	public int getEntYear() {
		return entYear;
	}
	
	public int getClassNum() {
		return classNum;
	}
	
	public int getStudentNo() {
		return studentNo;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setEntYear(int entYear) {
		this.entYear=entYear;
	}

	public void setClassNum(int classNum) {
		this.classNum=classNum;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo=studentNo;
	}
	
	public void setStudentName(String studentName) {
		this.studentName=studentName;
	}

	public void setPoint(int point) {
		this.point=point;
	}

}