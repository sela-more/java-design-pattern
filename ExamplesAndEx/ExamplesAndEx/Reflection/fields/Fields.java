package fields;
import java.lang.reflect.*;
class Fields
{
  public static void main(String args[])
  {
    try
    {
    	// creating 3 person types, in three ctor versions
      Class<?> c = Class.forName("fields.Person"); 
 	  Person p = (Person)c.newInstance();
 	  Constructor<?> c1 = c.getConstructor(new Class []{String.class, int.class});
 	  Person p2 = (Person) c1.newInstance(new Object[]{"A new Name", new Integer(15)});
	  Constructor<?> c2 = c.getConstructor(new Class []{String.class, Integer.class});
	  Person p3 = (Person) c2.newInstance(new Object[]{"A new Name", new Integer(15)});
 	
 	  
	  //Person p2 = new Person("A new Name",15);
	  //Person p3 = new Person("A new Name",new Integer(15));
	  
 	
 	  System.out.println(p);
 	  System.out.println(p2);
	  System.out.println(p3);
 	  
 	  // getting the name field and its value
      Field nameField = c.getDeclaredField("m_name");
      String name1 = (String)nameField.get(p);
	  String name2 = (String)nameField.get(p2);
    
    	// getting the age field and its value, using two diferent methods.
	  Field ageFeild = c.getDeclaredField("m_age");
      int age1 = ageFeild.getInt(p);
      
      System.out.println("first person name =" + name1);
	  System.out.println("Second person name =" + name2);
	  System.out.println("first person age= " + age1);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}