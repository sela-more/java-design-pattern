/*
 * Created on 26/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package fields;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Person {

	 String m_name;
	 int m_age;
	
		Person() {
			m_name="The person deafult name";
			m_age = 20; // our default
		}
	
		public Person(String s, int age) {
			m_name=s + " int Version";
			m_age = age;
		}


		public Person(String s, Integer a) {
			m_name=s + " Integer Version";
			m_age = a.intValue();
		}
	
		public Person(String s, String s2, String s3) {
			m_name= s + " Three arguments version";
			m_age = 20;
		}


		public String toString() {
			return m_name;
		}
}
