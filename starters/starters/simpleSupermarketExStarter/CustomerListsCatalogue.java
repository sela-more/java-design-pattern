/*
 * Created on 11/01/2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package simpleSupermarketExStarter;
import java.util.*;

public class CustomerListsCatalogue {
	// singleton
	// Student?
	
	
	// keep all personal customer lists by custID
	private Map m_list = new HashMap();
	
	public void register(CustomerList list) {
		// Student?
	}
	public CustomerList getList(Integer custID) throws Exception{
		// Student?
			return null;
	}
	public void replaceList(CustomerList list) {
		// Student?
	}
	public void showCustomers() {
		System.out.println("Customers for which saved lists are available:");
		System.out.println("---------------------------------------");
		Set theSet = m_list.entrySet();
		// A map may be converted to a set of Map.Entry
		// Each entry has getKey and getValue methods
		
	
	}

}
