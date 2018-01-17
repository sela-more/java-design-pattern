package modifiers;
import java.lang.reflect.*;
public class PrintClassData
{
    private String m_sClassName;
    public PrintClassData(String sClassName)
    {
        m_sClassName = sClassName;
        printData();
    }
    private void printData()
    {
        System.out.println("Class name: " + m_sClassName);
        try {
            printClassModifiers(Class.forName(m_sClassName));
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Error, Class " + m_sClassName + " not found");
            System.exit(1);
        }
    }
    
	 private void printClassModifiers(Class c)
		{
			int nModifiers = c.getModifiers();
			if (Modifier.isFinal(nModifiers))
				System.out.println("\tFinal");
			if (Modifier.isPublic(nModifiers))
				System.out.println("\tPublic");
			if (Modifier.isAbstract(nModifiers))
				System.out.println("\tAbstract");
		}
}
