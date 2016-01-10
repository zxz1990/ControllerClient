package com.zxz.client.impls;

import com.zxz.client.Activity.ButtonsActivity;
import com.zxz.client.INet;
import com.zxz.client.Utils.DoRequest;
import com.zxz.client.bean.KeyVo;
import com.zxz.client.interfaces.IButtonsEvent;

import java.lang.ref.WeakReference;

/**
 * Created by 学智 on 2016-01-10.
 */
public class ButtonsEventImpl implements IButtonsEvent, INet {

    private WeakReference<ButtonsActivity> weakRef;

    public ButtonsEventImpl(ButtonsActivity activity) {
        weakRef = new WeakReference<>(activity);
    }

    @Override
    public void onResponse(String result) {

    }

    @Override
    public void send(boolean press, int keycode) {
        KeyVo keyVo = new KeyVo();
        keyVo.setPress(press);
        keyVo.setKeyCode(keycode);
        DoRequest.sendButtonsEventRequest(keyVo, this);
    }
}
