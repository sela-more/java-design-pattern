
package visitorSolution;


public class salaryVisitor implements Visitor {
	int m_salary;
	public salaryVisitor(int vacationDays) {
		m_salary = vacationDays;
	}

	public void visit(Employee emp) {
		emp.setSalary(emp.getSalary()+m_salary);

	}

	
	public void visit(Boss boss) {
		//we are nicer to bosses: we give them double the increase!
		boss.setSalary(boss.getSalary()+m_salary*2);

	}
}
