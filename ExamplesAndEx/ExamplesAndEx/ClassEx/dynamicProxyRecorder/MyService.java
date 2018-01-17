package dynamicProxyRecorder;
class MyService implements IService
{
	public void m1(String s)
	{
		System.out.println("in m1, s = " + s);
	}
	public void m2(String s, int i)
	{
		System.out.println("in m2, s = " + s + " i = " + i);
	}
};