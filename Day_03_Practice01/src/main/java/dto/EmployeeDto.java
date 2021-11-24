package dto;

public class EmployeeDto {
	private int emp_id;
	private String emp_name;
	private String dept_title;
	private String email;
	
	public EmployeeDto() {}
	
	public EmployeeDto(int emp_id, String emp_name, String dept_title, String email) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.dept_title = dept_title;
		this.email = email;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getDept_title() {
		return dept_title;
	}
	public void setDept_title(String dept_title) {
		this.dept_title = dept_title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
