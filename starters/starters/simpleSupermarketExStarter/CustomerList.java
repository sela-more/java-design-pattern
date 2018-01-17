/*
 * Created on 11/01/2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package simpleSupermarketExStarter;
import java.util.*;

import simpleSupermarketExSolution.Product;

public class CustomerList  { // Student?
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
		// Student?
		return 0;
	}
	public void  setProductQuantity (Product key, int quant) {
		// Student?

	}
	public void showList() {
		
		// A map may be converted to a set of Map.Entry
		// Each entry has getKey and getValue methods
		System.out.println("Current products in your personal list:");
		System.out.println("---------------------------------------");
		et<Map.Entry<Product, Integer>> theSet = m_prodList.entrySet();
		Iterator<Map.Entry<Product, Integer>> iter = theSet.iterator();
		// Student?
	 }
	

	//	Student? There is another method (IMPORTANT) missing!
}
