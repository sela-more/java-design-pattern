package decorator.videoFilter;
class VideoData
{
	private String m_sColorMode;
	private String m_sDimensions;

	public VideoData(String sColorMode, String sDimensions)
	{
		m_sColorMode = sColorMode;
		m_sDimensions = sDimensions;
	}

	public void setColorMode(String sColorMode)
	{
		m_sColorMode = sColorMode;
	}
	
	public void setDimensions(String sDimensions)
	{
		m_sDimensions = sDimensions;
	}

	public String toString()
	{
		return "Video data. Color Mode: " + m_sColorMode + " Dimensions = " + m_sDimensions;
	}
};