package isw.builder.dto;

public class Department {
	
	private String department;
	
	public Department() {
	}
	
	public Department(String department) {
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
    public String toString() {
        return "Department{" + "name=" + department + '}';
    }
}
