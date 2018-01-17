package proxy.loginTraceProxy;
// THIS IS NOT COMPLETE or COMPILED CODE: 
// just an idea of things to do with proxy
interface ILogin {
	public void loginToSystem(String name);

}

class Login implements ILogin {
	public void loginToSystem(String userName) {
		// Login....
		// Access DB, add a record......
	}
}

class LoginProxy implements ILogin {
		ILogin m_loginSystem;
		LoginProxy() {
			m_loginSystem = new Login();
		}

		public void loginToSystem(String userName) {
			// Write this event to log file/send by email etc...
			//WriteToEmail();
			m_loginSystem.loginToSystem(userName);
		}
}


class Main {
	static ILogin m_loginSystem = new LoginProxy();

	public static void main (String args[]) {
		Main mainSystem = new Main();
		Main.m_loginSystem.loginToSystem("shraga");
	}


}
