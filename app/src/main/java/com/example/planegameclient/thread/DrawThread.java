package com.example.planegameclient.thread;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.example.planegameclient.view.GameView;

/**
 * @author: liuming
 * @date: 2022/3/15
 */
public class DrawThread extends Thread{

    private int SLEEP_SPAN = 50;
    private SurfaceHolder mSurfaceHolder;
    private GameView view;
    private boolean flag = true;

    public DrawThread(SurfaceHolder surfaceHolder,GameView view){
        mSurfaceHolder = surfaceHolder;
        this.view = view;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }

    @SuppressLint("WrongCall")
    @Override
    public void run() {
        Canvas c = null;
        while (flag){
            try{
                c = mSurfaceHolder.lockCanvas();
                synchronized (mSurfaceHolder){
                    view.onDraw(c);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(c != null){
                    mSurfaceHolder.unlockCanvasAndPost(c);
                }
            }
            try{
                Thread.sleep(SLEEP_SPAN);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
