class Main {

	public static void main (String args[]) throws Exception{
		Person p = new Person();
		Class personClass = p.getClass();
		System.out.println(personClass.getName());


		Class personClass2 = Person.class;
		//Class intClass = int.class;
		Class personClass3 = Class.forName("Person");

		Object newone = personClass3.newInstance();
		Person pNew = (Person)newone;
		System.out.println(pNew);
	}



}