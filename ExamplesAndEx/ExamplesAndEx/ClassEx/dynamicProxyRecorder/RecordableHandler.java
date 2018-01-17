package dynamicProxyRecorder;
import java.lang.reflect.*;
import java.util.*;

class RecordableHandler implements InvocationHandler, IRecordable
{
	private boolean m_bRecording = false;
	private LinkedList<MethodInfo> m_RecordedMethods = new LinkedList<MethodInfo>();
	private Object m_Target;

	private RecordableHandler(Object target) {
		m_Target = target;
	}

	public void play() throws Exception
	{
		synchronized(m_RecordedMethods)
		{
			Iterator<MethodInfo> iter = m_RecordedMethods.iterator();
			while(iter.hasNext())
				(iter.next()).execute(m_Target);
		}
	}

	public void record()
	{
		m_bRecording = true;
		m_RecordedMethods = new LinkedList<MethodInfo>();
	}

	public void stop()
	{
		m_bRecording = false;
	}

	public static Object createRecordable(Object target)
	{
		Class<?>[] newInterfaces = new Class[target.getClass().getInterfaces().length + 1];
		System.arraycopy(target.getClass().getInterfaces(),  0, newInterfaces,
						 0, newInterfaces.length - 1);
		newInterfaces[newInterfaces.length - 1] = IRecordable.class;

		return Proxy.newProxyInstance(IRecordable.class.getClassLoader(),
						newInterfaces, new RecordableHandler(target));
	}



	public Object invoke(Object proxy, Method m, Object params[])
		throws Exception
	{
		//if method is play, stop, record:
		if (m.getDeclaringClass() == IRecordable.class)
			return m.invoke(this, params);

		if (m_bRecording) //recording --> store method info
		{
			synchronized(m_RecordedMethods)
			{
				m_RecordedMethods.add(new MethodInfo(m, params));
			}
		}
		//Execute target method on subject
		return m.invoke(m_Target, params);

	}



	private static class MethodInfo
	{
		private Method m_Method;
		private Object m_Args[];
		private MethodInfo(Method m, Object args[])
		{
			m_Method = m;
			m_Args = args;
		}
		private void execute(Object target)	throws Exception
		{
			m_Method.invoke(target, m_Args);
		}
	};
};