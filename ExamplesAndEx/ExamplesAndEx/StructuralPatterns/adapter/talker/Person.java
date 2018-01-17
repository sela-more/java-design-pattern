package adapter.talker;
class Person implements ITalker {
	String m_name;
	
	public Person(String name) {
		m_name=name;
	}
	
	public void talk() {
		System.out.println(m_name + ": hello ! I'm a person");
	}


}