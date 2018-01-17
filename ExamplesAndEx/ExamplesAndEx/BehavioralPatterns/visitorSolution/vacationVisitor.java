
package visitorSolution;

public class vacationVisitor implements Visitor {
	int m_vacation;
	public vacationVisitor(int vacationDays) {
		m_vacation = vacationDays;
	}

	public void visit(Employee emp) {
		emp.setVacationDays(emp.getVacation()+m_vacation);

	}

	
	public void visit(Boss boss) {
		// we are nicer to bosses: we give them double the increase of days!
		boss.setVacationDays(boss.getVacation()+m_vacation*2);


	}
}
