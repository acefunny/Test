package cc.funny.qqmusic;

import java.io.Serializable;

public class MusicDataInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	MusicDataSong song;

	public MusicDataSong getSong()
	{
		return song;
	}

	public void setSong(MusicDataSong song)
	{
		this.song = song;
	}
}
