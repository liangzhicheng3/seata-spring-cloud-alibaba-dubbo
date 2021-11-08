package com.liangzhicheng.modules.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class TUser extends Model<TUser> {

  private static final long serialVersionUID = 1L;

  /**
   * 用户id
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /**
   * 名称
   */
  private String name;

}
