package adapter.talker;
class Dog {
	String m_name;
	
	public Dog(String name) {
		m_name=name;
	}
	
	public void bark() {
		System.out.println(m_name + ": how how ! I'm a dog");
	}

}