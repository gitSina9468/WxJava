package me.chanjar.weixin.open.bean.ma.auth;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 微信认证数据明细
 * @author: Mr.Song
 * @create: 2023-12-30 16:34
 **/
@Data
public class WxMaAuthDataInfo implements Serializable {

  private static final long serialVersionUID = 8881103449144288927L;
  /**
   * 企业为1，个体工商户 为12，个人是15 必填
   */
  @SerializedName("customer_type")
  private Integer customerType;

  /**
   * 认证任务id，打回重审调用reauth时为必 必填
   */
  @SerializedName("taskid")
  private String taskId;

  /**
   * 联系人信息 必填
   */
  @SerializedName("contact_info")
  private ContactInfo contactInfo;

  /**
   * 发票信息，如果是服务商代缴模式，不需要改参数
   */
  @SerializedName("invoice_info")
  private InvoiceInfo invoiceInfo;

  /**
   * 主体资质材料 media_id 支持jpg,jpeg .bmp.gif .png格式，仅支持一张图片 非个人类型必填。
   */
  private String qualification;
  /**
   * 主体资质其他证明材料 media_id 支持jpg,jpeg .bmp.gif .png格式，最多上传10张图片 不必填
   */
  @SerializedName("qualification_other")
  private List<String> qualificationOther;
  /**
   * 小程序账号名称 必填
   */
  @SerializedName("account_name")
  private String accountName;
  /**
   * 小程序账号名称命名类型 1：基于自选词汇命名 2：基于商标命名 必填
   */
  @SerializedName("account_name_type")
  private Integer accountNameType;
  /**
   * 名称命中关键词-补充材料 media_id 支持jpg,jpeg .bmp.gif .png格式，支持上传多张图片 不必填
   */
  @SerializedName("account_supplemental")
  private String accountSupplemental;
  /**
   * 支付方式 1：消耗服务商预购包 2：小程序开发者自行支付 必填
   */
  @SerializedName("pay_type")
  private Integer payType;
  /**
   * 认证类型为个人类型时可以选择要认证的身份，从/wxa/sec/authidentitytree 里获取，填叶节点的name 不必填
   */
  @SerializedName("auth_identification")
  private String authIdentification;
  /**
   * 身份证明材料 media_id （1）基于不同认证身份上传不同的材料；
   * （2）认证类型=1时选填，支持上传10张图片（3）支持jpg,jpeg .bmp.gif .png格式 填了auth_identification则必填。
   */
  @SerializedName("auth_ident_material")
  private List<String> authIdentMaterial;
  /**
   * 第三方联系电话 必填
   */
  @SerializedName("third_party_phone")
  private String thirdPartyPhone;
  /**
   * 选择服务商代缴模式时必填。服务市场appid，该服务市场账号主体必须与服务商账号主体一致
   */
  @SerializedName("serviceAppid")
  private String service_appid;

  @Data
  public static class ContactInfo{
    /**
     * 认证联系人姓名 必填
     */
    private String name;

    /**
     * 认证联系人邮箱 必填
     */
    private String email;
  }

  @Data
  public static class InvoiceInfo{
    /**
     * 发票类型 1: 不开发票 2: 电子发票 3: 增值税专票 必填
     */
    @SerializedName("invoice_type")
    private Integer invoiceType;

    /**
     * 发票类型=2时必填 电子发票开票信息 不必填
     */
    private String electronic;

    /**
     *发票类型=3时必填 增值税专票开票信息 不必填
     */
    private Object vat;

    /**
     * 发票抬头，需要和认证主体名称一样 不必填
     */
    @SerializedName("invoice_title")
    private String invoiceTitle;

  }
}
