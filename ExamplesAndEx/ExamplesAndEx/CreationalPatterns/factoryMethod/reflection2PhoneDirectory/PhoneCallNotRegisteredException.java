package factoryMethod.reflection2PhoneDirectory;
class PhoneCallNotRegisteredException extends Exception
{
	public PhoneCallNotRegisteredException(String sPhoneNumber)
	{
		super("Phone Call for " + sPhoneNumber + " was not registered");
	}
};