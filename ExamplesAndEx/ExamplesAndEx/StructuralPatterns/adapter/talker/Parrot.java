package adapter.talker;
class Parrot implements ITalker {
	String m_name;
	
	public Parrot(String name) {
		m_name=name;
	}
	
	public void talk() {
		System.out.println(m_name + ": kwa ! I'm a parrot");
	}


}