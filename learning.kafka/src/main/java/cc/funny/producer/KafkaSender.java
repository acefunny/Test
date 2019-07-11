package cc.funny.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

import javax.annotation.Resource;

import cc.funny.message.BaseMessage;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaSender {

  @Resource
  private KafkaTemplate<String, String> kafkaTemplate;

  //发送消息方法
  public void send() {
    BaseMessage message = BaseMessage.builder().id(1L).msg("hahaha").sendTime(new Date()).build();
    log.info("+++++++++++++++++++++  message = {}", message.toJsonString());
    kafkaTemplate.send("test-topic-1", message.toJsonString());
  }
}
