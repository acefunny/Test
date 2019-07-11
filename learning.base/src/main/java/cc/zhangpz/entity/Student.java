package cc.zhangpz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

  @ToString.Include
  private long id;
  @ToString.Include
  private String name;
  @ToString.Include
  private int gender;
  @ToString.Include
  private long birthday;

  private String idCard;
}
