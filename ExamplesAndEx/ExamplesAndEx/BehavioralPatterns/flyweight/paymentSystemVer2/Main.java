package flyweight.paymentSystemVer2;
import java.io.*;

class Main
{
	public static void main(String args[])
	{
		CreditCardSystem ccs = new CreditCardSystem();
		BillingSystem bs = new BillingSystem();
		UserSession session = new UserSession(ccs, bs);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			while (!session.isDone())
			{	
				System.out.println(session.getMessage());
				session.setParam(br.readLine());
			}	
		}
		catch (IOException e)
		{
			System.out.println("User hanged up!");
		}
		

		System.out.println("Session Done");	
	}
};