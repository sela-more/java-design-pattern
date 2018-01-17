

package visitorSolution;
import java.util.*;

public class Department {
	private ArrayList<Employee> ar = new ArrayList<Employee>();
	
	public void addEmployee(Employee emp) {
		ar.add(emp);
	}
	public void display() {
		for (int i=0; i< ar.size(); i++)
			System.out.println(ar.get(i));
		
	}
	public void addToSalary(int increment) {
		for (int i=0; i< ar.size(); i++) {
			Employee emp = (Employee) ar.get(i);
			emp.setSalary(emp.getSalary() + increment);
		}
		
	}
	public void addToVacation(int increment) {
		for (int i=0; i< ar.size(); i++) {
			Employee emp = (Employee) ar.get(i);
			emp.setVacationDays(emp.getVacation() + increment);
		}
		
	}
	
	public void accept(Visitor visitor) {
		for (int i=0; i< ar.size(); i++){
			Employee emp =  ar.get(i);
			emp.accept(visitor);
		}
		
	}

}
