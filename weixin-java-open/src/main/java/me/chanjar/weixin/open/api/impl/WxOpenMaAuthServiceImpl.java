package me.chanjar.weixin.open.api.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.open.api.WxOpenMaAuthService;
import me.chanjar.weixin.open.bean.ma.auth.WxMaAuthDataInfo;
import me.chanjar.weixin.open.bean.ma.auth.WxOpenAuthProcess;
import me.chanjar.weixin.open.bean.ma.auth.WxOpenMaAuthResult;
import me.chanjar.weixin.open.util.json.WxOpenGsonBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 小程序认证实现
 * @author: Mr.Song
 * @create: 2023-12-30 16:38
 **/
public class WxOpenMaAuthServiceImpl implements WxOpenMaAuthService {

  private final WxMaService wxMaService;

  public WxOpenMaAuthServiceImpl(WxMaService wxMaService) {
    this.wxMaService = wxMaService;
  }

  @Override
  public WxOpenMaAuthResult secWxaAuth(WxMaAuthDataInfo authDataInfo) throws WxErrorException {
    Map<String, Object> params = new HashMap<>(1);
    params.put("auth_data", authDataInfo);
    String json = wxMaService.post(API_MINIAPP_WXAAUTH, params);
    return WxOpenGsonBuilder.create().fromJson(json, WxOpenMaAuthResult.class);
  }

  @Override
  public WxOpenAuthProcess secwxaapiQueryauth(String taskId) throws WxErrorException {
    JsonObject params = new JsonObject();
    params.addProperty("taskid", taskId);
    String json = wxMaService.post(API_MINIAPP_QUERY_AUTH, params);
    return WxOpenGsonBuilder.create().fromJson(json, WxOpenAuthProcess.class);
  }

  @Override
  public WxOpenMaAuthResult secwxaapiUploadauthmaterial(WxMaAuthDataInfo authDataInfo) throws WxErrorException {

    return null;
  }

  @Override
  public WxOpenMaAuthResult secwxaapiReauth(WxMaAuthDataInfo authDataInfo) throws WxErrorException {
    Map<String, Object> params = new HashMap<>(1);
    params.put("auth_data", authDataInfo);
    String json = wxMaService.post(API_MINIAPP_WXA_REAUTH, params);
    return WxOpenGsonBuilder.create().fromJson(json, WxOpenMaAuthResult.class);
  }

  @Override
  public String secwxaapiAuthidentitytree() throws WxErrorException {
    String json = wxMaService.get(API_MINIAPP_WXA_AUTHIDENTITYTREE,null);
    return json;
  }


}
