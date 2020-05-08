package cc.funny.qqmusic;

import java.io.Serializable;

public class MusicDataSong implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	MusicDataSongInfo[] list;

	public MusicDataSongInfo[] getList()
	{
		return list;
	}

	public void setList(MusicDataSongInfo[] list)
	{
		this.list = list;
	}
}
