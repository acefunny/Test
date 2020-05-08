package cc.funny.qqmusic;

import java.io.Serializable;

public class MusicData implements Serializable
{
	private static final long serialVersionUID = 1L;

	MusicDataInfo data;

	int subcode;

	public MusicDataInfo getData()
	{
		return data;
	}

	public void setData(MusicDataInfo data)
	{
		this.data = data;
	}

	public int getSubcode()
	{
		return subcode;
	}

	public void setSubcode(int subcode)
	{
		this.subcode = subcode;
	}

}
