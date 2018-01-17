package iterator;
import java.util.*;


class Lists {
	public static void main (String args[]) {
		ArrayList al = new ArrayList();
		// LinkedList al = new LinkedList();
		//HashSet al = new HashSet();
		
		for (int i = 0; i<10000;i++)
			al.add("hi" + i);
			//al.addLast("hi" + i);
		
		long timeStart = 0;
		
		long endTime = 0;
		long duration = 0;
		
		

 
 		System.out.println("Using get(i)");
 		timeStart = System.currentTimeMillis();
		for (int i=0; i<al.size(); i++)
			//System.out.println(al.get(i));
			al.get(i);
		duration = System.currentTimeMillis() -timeStart;
		System.out.println("Time: " + duration);


/*
		System.out.println("Using iterator");
		timeStart = System.currentTimeMillis();
		Iterator itr=al.iterator();
		while(itr.hasNext()) {
			itr.next();
				//String temp = (String)itr.next();
				//System.out.println(temp);
		}
		duration = System.currentTimeMillis() -timeStart;
		System.out.println("Time: " + duration);
*/
	}



}