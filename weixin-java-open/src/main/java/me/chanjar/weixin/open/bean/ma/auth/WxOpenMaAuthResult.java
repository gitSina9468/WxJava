package me.chanjar.weixin.open.bean.ma.auth;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.chanjar.weixin.open.bean.result.WxOpenResult;
import me.chanjar.weixin.open.util.json.WxOpenGsonBuilder;

/**
 * @description: 认证返回信息
 * @author: Mr.Song
 * @create: 2023-12-30 16:36
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class WxOpenMaAuthResult extends WxOpenResult {

  private static final long serialVersionUID = -613936397557067111L;
  /**
   * 认证任务id
   */
  @SerializedName("taskid")
  private String taskId;
  /**
   * 小程序管理员授权链接
   */
  @SerializedName("auth_url")
  private String authUrl;

  @Override
  public String toString() {
    return WxOpenGsonBuilder.create().toJson(this);
  }
}
