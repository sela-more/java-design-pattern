/*
 * Created on 11/01/2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package simpleSupermarketExSolution;
import java.util.*;
/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CustomerListsCatalogue {
	// singleton
	private CustomerListsCatalogue() {}
	private static CustomerListsCatalogue m_instance = new CustomerListsCatalogue();
	public static CustomerListsCatalogue getInstance() {
		return m_instance;
	}
	// keep all personal customer lists by custID
	private Map<Integer,CustomerList> m_list = new HashMap<Integer,CustomerList>();
	
	public void register(CustomerList list) {
		m_list.put(list.getCustomer(),list);
	}
	public CustomerList getList(Integer custID) throws Exception{
		CustomerList list =  m_list.get(custID);
		if (list != null)
			return (CustomerList) list.clone();
		else
			return null;
	}
	public void replaceList(CustomerList list) {
		m_list.remove(list.getCustomer());
		m_list.put(list.getCustomer(),list);
	}
	public void showCustomers() {
		System.out.println("Customers for which saved lists are available:");
		System.out.println("---------------------------------------");
		Set<Map.Entry<Integer,CustomerList>> theSet = m_list.entrySet();
		Iterator<Map.Entry<Integer,CustomerList>> iter = theSet.iterator();
		while (iter.hasNext()){
			Map.Entry<Integer,CustomerList> theEntry = iter.next();
			System.out.print("CustomerID: " + 
				theEntry.getKey());
			System.out.println(", Customer saved list: ");
			CustomerList cl = theEntry.getValue();
			cl.showList();
		}	
	
	}

}
