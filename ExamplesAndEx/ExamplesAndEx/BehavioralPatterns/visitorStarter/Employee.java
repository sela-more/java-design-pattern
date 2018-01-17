
package visitorStarter;


public class Employee {
	private String m_name;
	private int m_vacationDays;
	private int m_salary;
	public Employee(String name, int vacation, int salary) {
		m_name = name;
		this.m_salary = salary;
		this.m_vacationDays = vacation;
	}
	public void setSalary(int newSalary){
		m_salary = newSalary;
	}
	public int getSalary(){
		return m_salary;
	}
	public void setVacationDays(int newDays){
		m_vacationDays=newDays;
	}
	public int getVacation() {
		return m_vacationDays;
	}

	public String toString() {
		return ("Name: " + m_name + ", Salary: "+ m_salary + ", Vacation: "+ m_vacationDays);
	}
	
	// Student?? 
}
