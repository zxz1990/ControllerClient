package com.zxz.client.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zxz.client.impls.ButtonsEventImpl;
import com.zxz.client.interfaces.IButtonsEvent;
import com.zxz.client.syncclient.R;

/**
 * Created by 学智 on 2016-01-10.
 */
public class ButtonsActivity extends Activity {

    private Button mButtonUp;
    private Button mButtonDown;
    private Button mButtonLeft;
    private Button mButtonRight;

    private IButtonsEvent mLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_buttons);

        mLogic = new ButtonsEventImpl(this);

        mButtonUp = (Button)findViewById(R.id.button_up);
        mButtonDown = (Button)findViewById(R.id.button_down);
        mButtonLeft = (Button)findViewById(R.id.button_left);
        mButtonRight = (Button)findViewById(R.id.button_right);

        mButtonUp.setOnTouchListener(new MyOnTouchListener());
        mButtonDown.setOnTouchListener(new MyOnTouchListener());
        mButtonLeft.setOnTouchListener(new MyOnTouchListener());
        mButtonRight.setOnTouchListener(new MyOnTouchListener());

    }

    private class MyOnTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            boolean press = true;
            int keycode = 0;

            switch (v.getId()) {
                case R.id.button_up:
                    keycode = 0x26;
                    break;
                case R.id.button_down:
                    keycode = 0x28;
                    break;
                case R.id.button_left:
                    keycode = 0x25;
                    break;
                case R.id.button_right:
                    keycode = 0x27;
                    break;
            }
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    press = true;
                    break;
                case MotionEvent.ACTION_UP:
                    press = false;
                    break;
            }
            mLogic.send(press, keycode);
            return true;
        }
    }

    public void showResult(String res) {
        Toast.makeText(this, res, Toast.LENGTH_LONG);
    }

}
