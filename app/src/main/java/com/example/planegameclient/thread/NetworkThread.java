package com.example.planegameclient.thread;

import com.example.planegameclient.MainActivity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @author: liuming
 * @date: 2022/3/15
 */
public class NetworkThread extends Thread{
    MainActivity mActivity;
    Socket sc;
    DataInputStream din;
    DataOutputStream dout;
    boolean flag = true;

    public NetworkThread(MainActivity activity){
        mActivity = activity;
    }

    @Override
    public void run() {
        try{
            sc = new Socket("192.168.10.10",9999);
            din = new DataInputStream(sc.getInputStream());
            dout = new DataOutputStream(sc.getOutputStream());
            dout.writeUTF("<#CONNECT#>");
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
    }
}
