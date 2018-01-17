
package visitorSolution;


public class Boss extends Employee {
	private int m_bonus;
	public Boss(String name, int vacation, int salary) {
		super(name,vacation,salary);
	}

	
	public int getBonus() {
		return m_bonus;
	}
	
	public void setBonus(int m_bonus) {
		this.m_bonus = m_bonus;
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
