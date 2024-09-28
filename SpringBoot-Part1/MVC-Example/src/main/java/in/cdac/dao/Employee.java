package in.cdac.dao;

public class Employee {
	private int empID;
	private String empName;
	private String empEmail;
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empEmail=" + empEmail + "]";
	}
	
	
}
