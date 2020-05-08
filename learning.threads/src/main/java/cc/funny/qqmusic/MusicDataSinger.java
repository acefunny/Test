package cc.funny.qqmusic;

import java.io.Serializable;

public class MusicDataSinger implements Serializable
{
	private static final long serialVersionUID = 1L;

	int id;
	
	String mid;
	
	String name;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getMid()
	{
		return mid;
	}

	public void setMid(String mid)
	{
		this.mid = mid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
