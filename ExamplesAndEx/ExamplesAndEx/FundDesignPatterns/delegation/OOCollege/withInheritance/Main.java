/*
 * Created on 27/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package delegation.OOCollege.withInheritance;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Main {
	public static void main(String args[])
		{
			Person shraga = new Person("Shraga");
			Lecturer lShraga = new Lecturer(shraga, 2000f);
			Student sShraga = new Student(shraga, 100f);

			System.out.println(lShraga);
			System.out.println(sShraga);
		}

}
