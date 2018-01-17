/*
 * Created on 26/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FinalizationDemo {
	int m_id;
	public FinalizationDemo(int id){
		this.m_id = id;
		System.out.println("In ctor of: " + m_id);
	}
	

	public static void main(String[] args) {
		
		FinalizationDemo [] flist = new FinalizationDemo[100];
		
		for (int i=0; i<flist.length; i++)
				new FinalizationDemo(i);
		//System.gc();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		//super.finalize();
		System.out.println("In FINALIZE of: " + m_id);

	}

}
