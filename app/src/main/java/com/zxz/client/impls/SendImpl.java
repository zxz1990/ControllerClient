package com.zxz.client.impls;

import android.util.Log;

import com.zxz.client.ThreadPool;
import com.zxz.client.interfaces.ISender;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by 学智 on 2016-01-03.
 */
public class SendImpl implements ISender {

    private static String TAG = "SendImpl";

    private Socket mSocket;

    public SendImpl() {
    }

    private void connect() {
        if(mSocket != null && !mSocket.isClosed() && mSocket.isConnected()) {
            return;
        }
        try {
            mSocket = new Socket("192.168.1.119", 6666);
            Log.d(TAG, "new socket success");
        } catch (Exception e) {
            Log.d(TAG, "new socket fail");
            e.printStackTrace();
        }
        /*ThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mSocket = new Socket("192.168.1.119", 6666);
                    Log.d(TAG, "new socket success");
                } catch (Exception e) {
                    Log.d(TAG, "new socket fail");
                    e.printStackTrace();
                }
            }
        });*/
    }

    @Override
    public void send(final String msg, String result) {
        ThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                connect();
                if(mSocket == null) {
                    Log.d(TAG, "mSocket is null!");
                    return;
                }
                Log.d(TAG, "socket: isClose="+mSocket.isClosed() +",isConnected="+mSocket.isConnected());
                try {
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(mSocket.getOutputStream(), "UTF-8"));
//                    writer.println("{\"type\":\"key\",\"params\":"+msg+"}");
                    writer.println(msg);
                    writer.flush();
//                    writer.close();
//                    mSocket.close();
                    Log.d(TAG, "send success");
                } catch (IOException e) {
                    Log.d(TAG, "send fail");
                    e.printStackTrace();
                }
            }
        });
    }
}
