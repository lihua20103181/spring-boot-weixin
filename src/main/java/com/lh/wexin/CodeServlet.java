package com.lh.wexin;

import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CodeServlet  {
	
	public static String appid = "wx1947dabf1dea27d2";
	public static String secret = "4227c8fbded93d9a272fbc2873a1437c";
	
	public void sendMsg(String openid) {
		
		AccessToken2 token = WeChatUtils.getAccessToken(appid, secret);
		String template_id="https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token="+token.getToken();
		// 发送模版消息
		String URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
		String url = URL.replace("ACCESS_TOKEN", token.getToken());
		/*JSONObject jsonObject = JSONObject.fromObject(WeChatUtils.sendGet(template_id));
		String templateId = jsonObject.getString("template_id");*/
		JSONObject jsobj1 = new JSONObject();
		JSONObject jsobj2 = new JSONObject();
		/*JSONObject jsobj3 = new JSONObject();
		JSONObject jsobj4 = new JSONObject();*/
		JSONObject jsobj5 = new JSONObject();
		JSONObject jsobj6 = new JSONObject();

		//模版二
		
		jsobj1.put("touser", openid);
		jsobj1.put("template_id", "gh_ea5a6c9aebe6");

		/*jsobj3.put("value", "礼品领取成功");
		jsobj3.put("color", "#173177");
		jsobj2.put("first", jsobj3);

		jsobj4.put("value", "人民币一个亿");
		jsobj4.put("color", "#173177");
		jsobj2.put("keyword1", jsobj4);*/
		
		jsobj6.put("value", "您好！您已支付成功！");
		jsobj6.put("color", "#173177");
		jsobj2.put("remark", jsobj6);
		
		jsobj5.put("value", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		jsobj5.put("color", "#173177");
		jsobj2.put("keyword2", jsobj5);

		jsobj1.put("data", jsobj2);
		System.out.println(jsobj1);

		WeChatUtils.PostSendMsg(jsobj1, url);
	}

}