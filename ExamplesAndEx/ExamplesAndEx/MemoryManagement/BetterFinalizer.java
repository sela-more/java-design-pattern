import java.io.Closeable;
import java.io.IOException;


public class BetterFinalizer implements Closeable { // closeable interface added in 1.7
	int m_id;
	public BetterFinalizer(int id){
		this.m_id = id;
		System.out.println("In ctor of: " + m_id);
	}
	

	public static void main(String[] args) {
		
		BetterFinalizer [] flist = new BetterFinalizer[100];
		
		
		
		for (int i=0; i<flist.length; i++) {
			//new BetterFinalizer(i);
			try (BetterFinalizer v = new BetterFinalizer(i)) { // will call the close automatically
				                                               // in any case, good or bad.
			}
			catch (Exception e){
			}
			// or
			Object v2 = new BetterFinalizer(i); // got v2 from some other place, we
			                                    // don't know what it is
			if (v2 instanceof Closeable){
				try {
					((Closeable)v2).close();
				}
				catch (IOException e) {
				}
			}
				
		}
		
		//System.gc();
	}
	

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("In Close of: " + m_id);
		
	}

}
