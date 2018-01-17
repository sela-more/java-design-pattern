public class Person {
	String m_name;
	
	public Person() {
		m_name="person()";
	}
	
	public Person(String s, int a) {
		m_name="person(s,i)";
	}


	public Person(String s, Integer a) {
		m_name="person(s,I)";
	}
	
	public Person(String s, String s2, String s3) {
		m_name="person(s,s,s)";
	}


	public String toString() {
		return m_name;
	}

}