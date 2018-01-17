/*
 * Created on 11/01/2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package simpleSupermarketExSolution;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Product {
	private int m_key;
	private String m_name;
	private int m_price;
	
	// keep permission package, not public, so that
	// products are not created by just anyone
	Product(int key,String name, int price){
		m_key = key;
		m_name = name;
		m_price = price;
	}
	public int getKey() {
		return m_key;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return ("Product#: " + m_key + "\t" + m_name + "\t\tPrice: " + m_price );
	}
	public boolean equals(Object arg0) {
		if (arg0 instanceof Product)
			return (m_key == ((Product)arg0).m_key);
		return false; 
	}
	public int hashCode() {
		return m_key;
	}

}
