package cc.funny.qqmusic;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.ConcurrentLinkedDeque;

import cc.funny.http.OkHttpCli;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingsDataThread extends Thread {

  private ConcurrentLinkedDeque<String> singerNames;

  public SingsDataThread() {
    singerNames = new ConcurrentLinkedDeque<>();
  }

  public void addSingers(String name) {
    singerNames.add(name);
  }

  @Override
  public void run() {
    while (!SingsDataSelector.isFinish) {
      while (!singerNames.isEmpty()) {
        String singerName = singerNames.poll();
        System.out.println(Thread.currentThread().getName() + " ----- " + singerName);
        String singerUrl = SingsDataThread.searchByKey(1, 10, singerName);
        System.out.println("歌手图片地址 ———— " + singerUrl);
//         TODO update 歌手表，更新歌手头像
      }
    }
    System.out.println(Thread.currentThread().getName() + "结束");
  }

  private static String searchByKey(int page, int pageNum, String key) {
    String singerUrl = null;
    try {
      String newUrl = "https://c.y.qq.com/soso/fcgi-bin/client_search_cp?p=" + page + "&n=" + pageNum + "&w=" + key + "&format=json";
      OkHttpCli cli = new OkHttpCli();
      String response = cli.doGet(newUrl);
      MusicData data = JSON.parseObject(response, MusicData.class);
      // 获取失败返回 -10002
      int subcode = data.getSubcode();
      if (subcode == 0)// 获取失败返回 -10002
      {
        MusicDataSongInfo[] songs = data.getData().getSong().getList();
        for (MusicDataSongInfo songInfo : songs) {
          // 歌手图片全路径 ——
          // "https://y.gtimg.cn/music/photo_new/T001R500x500M000"
          // + songInfo.getSinger()[0].getMid() +
          // ".jpg?max_age=2592000";
          if (singerUrl == null)
            singerUrl = songInfo.getSinger()[0].getMid();
          // 有songmid为空的情况，证明该歌不存在
          if (songInfo.getSongmid() != null && !songInfo.getSongmid().equals("")) {
            String songname = songInfo.getSongname();
            // 专辑图片全路径 ——
            // "https://y.gtimg.cn/music/photo_new/T002R500x500M000"
            // + songInfo.getAlbummid() + ".jpg?max_age=2592000"
            String albummid = songInfo.getAlbummid();
            String albumname = songInfo.getAlbumname();
            // 歌曲MV全路径 —— "https://y.qq.com/n/yqq/mv/v/" +
            // songInfo.getVid() + ".html"
            String mvid = songInfo.getVid();
            // TODO insert 歌曲表（根据业务制定分表规则）
            System.out.println("歌曲mid = " + songInfo.getSongmid() + " 歌曲名称 = " + songname + " 专辑mid = " + albummid + " 专辑名称 = " + albumname + " MVID = " + mvid);
            // 入库成功后继续下一页操作
          }
        }
        SingsDataThread.searchByKey(page + 1, pageNum, key);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return singerUrl;
  }

}
