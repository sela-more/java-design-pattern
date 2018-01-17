package cache.imageCacheLRUVersion;
class ImageCreationException extends Exception
{
	ImageCreationException(String sURL)
	{
		super(sURL);
	}

	public String toString()
	{
		return "Cannot load image from " + getMessage();
	}
};