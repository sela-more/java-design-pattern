package ctor;
import java.lang.reflect.*;

class Ctor
{
  public static void main(String args[])
  {
    try
    {
      Class<?> c = Class.forName("ctor.Person");

 	  Person p = (Person)c.newInstance();
 	  System.out.println(p);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
