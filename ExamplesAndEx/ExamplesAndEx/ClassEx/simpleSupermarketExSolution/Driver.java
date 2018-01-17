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
public class Driver {
	

	public static void main(String[] args) {
		int customerID = 11;
		
		// create a customer list
		CustomerList cl = new CustomerList(customerID);
		// add some new products
		cl.addProduct(new Product(1,"Prod1",7),2);
		cl.addProduct(new Product(2,"Prod2",10),4);
		cl.addProduct(new Product(3,"Prod3",2),2);
		cl.addProduct(new Product(4,"Prod4",14),8);
		cl.addProduct(new Product(5,"Prod5",9),2);	
	
		
		// add the list to the catalogue
		CustomerListsCatalogue catlogue = CustomerListsCatalogue.getInstance();
		catlogue.register(cl);
		catlogue.showCustomers();
		
		// print the original list
		System.out.println("Showing original list:");
		cl.showList();
		
		// now get a working copy cl2 from the catalogue
		CustomerList cl2= null;
		try {
		
			cl2 = catlogue.getList(cl.getCustomer());
			//			modify cl2
			cl2.addProduct(new Product(88,"New Product",80),12);
			// change the quantity of an existing product
			cl2.setProductQuantity((new Product(1,"Prod1",7)),200);
			//			show the updated list
			System.out.println("Modified list cl2: ");
			cl2.showList(); 
			System.out.println("Origianl list unchanged: ");
			CustomerList cl3 = catlogue.getList(cl.getCustomer());
			cl3.showList();
			
			
			
	
		}
		catch (Exception e){
		}
		
			
		
		
		
	
	
	}
}
