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
public class CustomerList implements Cloneable {
	private Integer m_custID;
	private HashMap<Product,Integer> m_prodList = new HashMap<Product,Integer>();
	
	public CustomerList(int id) {
		m_custID = new Integer(id);
	}
	public CustomerList(Integer id) {
			m_custID = id;
	}
	public Integer getCustomer() {
		return m_custID;
	}
	public void addProduct(Product key, int quantity) {
		m_prodList.put(key,new Integer(quantity));
	}
	public int getProductQuantity (Product key) {
		Object quant = m_prodList.get(key);
		if (quant != null)
			return ((Integer) quant).intValue();
		else
			return 0;
	}
	public void  setProductQuantity (Product key, int quant) {
		// could be done more efficiently with iterators,
		// kept here for simplicity and time
		m_prodList.remove(key);
		m_prodList.put(key,new Integer(quant));

	}
	public void showList() {
		System.out.println("Current products in your personal list:");
		System.out.println("---------------------------------------");
		Set<Map.Entry<Product, Integer>> theSet = m_prodList.entrySet();
		Iterator<Map.Entry<Product, Integer>> iter = theSet.iterator();
		while (iter.hasNext()){
			Map.Entry<Product, Integer> theEntry = iter.next();
			System.out.print("Product: " + theEntry.getKey());
			System.out.println(" Quantity: " + theEntry.getValue());
		}	
	
	 }
	

	@SuppressWarnings("unchecked")
	public Object clone() throws CloneNotSupportedException {
		// we want to replicate the list, but
		// not the products themselves, as they
		// are taken from a pool anyway
		CustomerList mylist = (CustomerList) super.clone();
		try {
		
			mylist.m_prodList = (HashMap<Product,Integer>) m_prodList.clone();
		}
		catch (Exception e) {
			System.out.println("Clone problem");
		}
			
		return mylist;
	}

}
