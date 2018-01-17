package objectPool.cmdWrapper;
/*
 * Created on 24/02/2004
 * Examples for Java Design Patterns course
 * (c) Sela-YouNiversity
 */

/**
 * @author didi
 */
public class Main2 {
	public static void main(String args[]) throws CmdException
	{
		ICmd c1 = new PooledCmd();
		System.out.println(c1.setActiveDrive('C'));
		System.err.println("Before Second PooledCmd Instantiation");
		//ICmd c2 = new PooledCmd();
		System.err.println("After Second PooledCmd Instantiation");		
		System.out.println(c1.cd("c:\\MyTemp\\"));
		System.out.println(c1.dir());
	}
}
