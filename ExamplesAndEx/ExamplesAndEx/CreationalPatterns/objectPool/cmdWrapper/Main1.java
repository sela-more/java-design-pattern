package objectPool.cmdWrapper;
/*
 * Created on 23/02/2004
 * Examples for Java Design Patterns course
 * (c) Sela-YouNiversity
 */

/**
 * @author didi
 */
public class Main1 {
	public static void main(String args[]) throws CmdException
	{
		PooledCmd c = new PooledCmd();

		System.out.println(c.dir("c:\\MyTemp\\"));
		c.close();

		PooledCmd c1 = new PooledCmd();
		System.out.println(c1.dir("c:\\MyTemp\\"));
		c1.close();
	}
}
