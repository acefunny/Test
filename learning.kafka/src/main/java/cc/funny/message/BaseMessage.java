package cc.funny.message;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BaseMessage {

  private Long id;
  private String msg;
  private Date sendTime;

  public String toJsonString(){
    return JSONObject.toJSONString(this);
  }
}
