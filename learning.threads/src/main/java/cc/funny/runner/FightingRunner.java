package cc.funny.runner;

import java.util.concurrent.atomic.LongAdder;

public class FightingRunner implements Runnable {

  private final static LongAdder count = new LongAdder();

  @Override
  public void run() {
    if (count.intValue() == 10) {
      this.doSomething(count.intValue());
    } else {
      count.increment();
    }
  }


  private void doSomething(int i) {
    System.out.println("当前索引：{}" + i);
  }
}
