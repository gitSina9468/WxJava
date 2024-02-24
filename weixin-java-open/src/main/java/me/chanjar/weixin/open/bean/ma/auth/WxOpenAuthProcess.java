package me.chanjar.weixin.open.bean.ma.auth;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.chanjar.weixin.open.bean.result.WxOpenResult;

/**
 * @description: 微信认证进度
 * @author: Mr.Song
 * @create: 2023-12-30 16:47
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class WxOpenAuthProcess extends WxOpenResult {

  /**
   * 0: 初始状态 1: 任务超时, 24小时内有效 2: 用户授权拒绝
   * 3: 用户授权同意 4: 发起人脸流程 5: 人脸认证失败
   * 6: 人脸认证ok 7: 人脸认证后，已经提交手机号码下发验证码
   * 8: 手机验证失败 9: 手机验证成功 11: 创建认证审核单失败
   * 12: 创建认证审核审核单成功 14: 验证失败 15: 等待支付
   */
  @SerializedName("task_status")
  private Integer taskStatus;
  /**
   * 小程序管理员授权链接
   */
  @SerializedName("auth_url")
  private String authUrl;
  /**
   * 审核单状态，创建认证审核审核单成功后该值有效。
   * 0：审核单不存在 1：待支付 2：审核中 3：打回重填 4：认证通过 5：认证最终失败（不能再修改）
   */
  @SerializedName("apply_status ")
  private Integer applyStatus;

  /**
   * 小程序后台展示的认证订单号
   */
  @SerializedName("orderid")
  private Long orderId;
  /**
   * 小程序appid
   */
  @SerializedName("appid")
  private String appId;
  /**
   * 当审核单被打回重填(apply_status=3)时有效
   */
  @SerializedName("refill_reason")
  private String refillReason;
  /**
   * 审核最终失败的原因(apply_status=5)时有效
   */
  @SerializedName("fail_reason")
  private String failReason;
}
