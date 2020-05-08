package cc.funny.qqmusic;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SingsDataSelector {

  public static void main(String[] args) {
    SingsDataSelector.singsData();
  }

  public static volatile boolean isFinish = false;

  public static void singsData() {
    // 模拟数据库读取的信息，需要分页读取
    String data = "周杰伦-Z,林俊杰-L,李荣浩-L,潘玮柏-P";
    ConcurrentHashMap<Integer, SingsDataThread> threadMap = new ConcurrentHashMap<Integer, SingsDataThread>();
    ExecutorService pools = new ThreadPoolExecutor(6, 12, 1000L,
        TimeUnit.SECONDS, new LinkedBlockingQueue());

    String[] datas = data.split(",");
    for (String singer : datas) {
      String singerName = singer.split("-")[0];
      String firstName = singer.split("-")[1];
      SingsDataThread thread = threadMap.get(letterToNumber(firstName));
      if (thread == null) {
        thread = new SingsDataThread();
        thread.setName(firstName);// 测试数据正确性
        pools.execute(thread);
        threadMap.put(letterToNumber(firstName), thread);
      }
      thread.addSingers(singerName);
    }
    // shutdown操作要在数据库读取完所有歌手信息后执行，否则线程会完成退出后报执行异常
    pools.shutdown();
    // 不加结束标签，会有一种情况，相同前缀的歌手相距较远，线程处理完当前数据后，发现poll里没有数据直接线程结束
    // 完成标识最好放在pools.shutdown()方法后，避免出现线程未开始但是由于设置了finish的原因提前关闭的问题
    SingsDataSelector.isFinish = true;
    System.out.println("所有线程执行完成");
  }

  public static int letterToNumber(String letter) {
    int length = letter.length();
    int num = 0;
    int number = 0;
    for (int i = 0; i < length; i++) {
      char ch = letter.charAt(length - i - 1);
      num = (int) (ch - 'A' + 1);
      num *= Math.pow(26, i);
      number += num;
    }
    return number;
  }
}
