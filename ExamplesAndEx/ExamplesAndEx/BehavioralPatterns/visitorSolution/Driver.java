
package visitorSolution;


public class Driver {

	public static void main(String[] args) {
		Department dep = new Department();
		dep.addEmployee(new Employee("a",30,10000));
		dep.addEmployee(new Boss("b",20,20000));
		dep.addEmployee(new Employee("c",40,30000));
		
		System.out.println("Initial department status: ");
		dep.display();
		//dep.addToSalary(20);
		dep.accept(new salaryVisitor(20));
		
		System.out.println("Status after 20 Shekel increase in salary: ");
		dep.display();
		
		//dep.addToVacation(3);
		dep.accept(new vacationVisitor(3));
		System.out.println("Status after adding 3 vacation days: ");
		dep.display();
	}
}
