package me.chanjar.weixin.open.api;

import com.google.gson.JsonObject;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.open.bean.ma.auth.WxMaAuthDataInfo;
import me.chanjar.weixin.open.bean.ma.auth.WxOpenAuthProcess;
import me.chanjar.weixin.open.bean.ma.auth.WxOpenMaAuthResult;

/**
 * @description: 小程序微信认证
 * @author: Mr.Song
 * @create: 2023-12-30 16:30
 **/
public interface WxOpenMaAuthService {


  /**
   * 小程序认证 post
   */
  String API_MINIAPP_WXAAUTH = "https://api.weixin.qq.com/wxa/sec/wxaauth";
  /**
   * 小程序认证进度查询 post
   */
  String API_MINIAPP_QUERY_AUTH = "https://api.weixin.qq.com/wxa/sec/queryauth";
  /**
   * 小程序认证上传补充材料 post
   */
  String API_MINIAPP_AUTH_UPLOADAUTHMATERIAL = "https://api.weixin.qq.com/wxa/sec/uploadauthmaterial";
  /**
   * 小程序认证重新提审 post
   */
  String API_MINIAPP_WXA_REAUTH = "https://api.weixin.qq.com/wxa/sec/reauth";
  /**
   * 查询个人认证身份选项列表 get
   */
  String API_MINIAPP_WXA_AUTHIDENTITYTREE = "https://api.weixin.qq.com/wxa/sec/authidentitytree";


  /**
   * 小程序认证
   *
   * @param authDataInfo
   * @return wx open ma auth result
   * @throws WxErrorException the wx error exception
   */
  WxOpenMaAuthResult secWxaAuth(WxMaAuthDataInfo authDataInfo) throws WxErrorException;

  /**
   * 小程序认证进度查询
   *
   * @param taskId
   * @return wx open ma auth result
   * @throws WxErrorException the wx error exception
   */
  WxOpenAuthProcess secwxaapiQueryauth(String taskId) throws WxErrorException;

  /**
   * 小程序认证上传补充材料
   *
   * @param authDataInfo
   * @return wx open ma auth result
   * @throws WxErrorException the wx error exception
   */
  WxOpenMaAuthResult secwxaapiUploadauthmaterial(WxMaAuthDataInfo authDataInfo) throws WxErrorException;

  /**
   * 小程序认证重新提审
   *
   * @param authDataInfo
   * @return wx open ma auth result
   * @throws WxErrorException the wx error exception
   */
  WxOpenMaAuthResult secwxaapiReauth(WxMaAuthDataInfo authDataInfo) throws WxErrorException;

  /**
   * 查询个人认证身份选项列表
   *
   * @param
   * @return wx open ma auth result
   * @throws WxErrorException the wx error exception
   */
  String secwxaapiAuthidentitytree() throws WxErrorException;

}
