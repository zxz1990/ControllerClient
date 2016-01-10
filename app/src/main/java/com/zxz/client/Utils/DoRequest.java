package com.zxz.client.Utils;

import com.alibaba.fastjson.JSON;
import com.zxz.client.INet;
import com.zxz.client.bean.KeyVo;
import com.zxz.client.bean.ServerRequestVo;
import com.zxz.client.impls.SendImpl;
import com.zxz.client.interfaces.ISender;

/**
 * Created by 学智 on 2016-01-10.
 */
public class DoRequest {

    public static void sendButtonsEventRequest(KeyVo keyVo, INet iNet) {
        ISender sender = new SendImpl();
        ServerRequestVo request = new ServerRequestVo();
        request.setType(Consts.TYPE_KEY);
        request.setParams(JSON.toJSONString(keyVo));
        sender.send(JSON.toJSONString(request), "");
    }
}
