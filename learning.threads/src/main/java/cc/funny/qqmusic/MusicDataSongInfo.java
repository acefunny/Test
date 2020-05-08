package cc.funny.qqmusic;

import java.io.Serializable;

public class MusicDataSongInfo implements Serializable
{
	private static final long serialVersionUID = 1L;

	int albumid;

	String albummid;

	String albumname;

	MusicDataSinger[] singer;

	int songid;

	String songmid;

	String songname;

	String strMediaMid;

	String vid;

	public int getAlbumid()
	{
		return albumid;
	}

	public void setAlbumid(int albumid)
	{
		this.albumid = albumid;
	}

	public String getAlbummid()
	{
		return albummid;
	}

	public void setAlbummid(String albummid)
	{
		this.albummid = albummid;
	}

	public String getAlbumname()
	{
		return albumname;
	}

	public void setAlbumname(String albumname)
	{
		this.albumname = albumname;
	}

	public MusicDataSinger[] getSinger()
	{
		return singer;
	}

	public void setSinger(MusicDataSinger[] singer)
	{
		this.singer = singer;
	}

	public int getSongid()
	{
		return songid;
	}

	public void setSongid(int songid)
	{
		this.songid = songid;
	}

	public String getSongmid()
	{
		return songmid;
	}

	public void setSongmid(String songmid)
	{
		this.songmid = songmid;
	}

	public String getSongname()
	{
		return songname;
	}

	public void setSongname(String songname)
	{
		this.songname = songname;
	}

	public String getStrMediaMid()
	{
		return strMediaMid;
	}

	public void setStrMediaMid(String strMediaMid)
	{
		this.strMediaMid = strMediaMid;
	}

	public String getVid()
	{
		return vid;
	}

	public void setVid(String vid)
	{
		this.vid = vid;
	}

}
