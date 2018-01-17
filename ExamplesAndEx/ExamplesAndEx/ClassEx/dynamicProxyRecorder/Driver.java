/*
 * Created on 27/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dynamicProxyRecorder;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Driver { 
	
		public static void main(String args[])	 throws Exception
		{
			  IService ServiceProxy  = (IService)
					RecordableHandler.createRecordable(new MyService());

			  if (!(ServiceProxy instanceof IRecordable))
			  {
				  System.err.print("Error");
				  System.exit(1);
			  }
			  ((IRecordable)ServiceProxy).record();
			  ServiceProxy.m1("this is a string");
			  ServiceProxy.m2("this is a string", 2);
			  System.out.println("Replay");
			  ((IRecordable)ServiceProxy).play();
		
	};

}
