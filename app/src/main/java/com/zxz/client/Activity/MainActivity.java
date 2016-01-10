package com.zxz.client.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zxz.client.syncclient.R;
import com.zxz.client.impls.SendImpl;
import com.zxz.client.interfaces.ISender;

/**
 * Created by 学智 on 2016-01-02.
 */
public class MainActivity extends Activity {

    private static String TAG = "MainActivity";

    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mainactivity);
        mEditText = (EditText)findViewById(R.id.edittext);
        mButton = (Button)findViewById(R.id.button);
        final ISender sender = new SendImpl();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ButtonsActivity.class);
                startActivity(intent);
//                sender.send(mEditText.getText().toString());
            }
        });
    }
}
