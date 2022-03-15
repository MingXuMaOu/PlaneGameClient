package com.example.planegameclient.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.planegameclient.MainActivity;
import com.example.planegameclient.thread.DrawThread;

/**
 * @author: liuming
 * @date: 2022/3/15
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainActivity mActivity;
    private DrawThread mDrawThread;

    public GameView(Context context){
        super(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mActivity = (MainActivity) context;
        getHolder().addCallback(this);

        mDrawThread = new DrawThread(getHolder(),this);
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
        canvas.drawBitmap(mActivity.planeRed, 0, 0, null);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        mDrawThread.setFlag(true);
        if(!mDrawThread.isAlive()){
            try{
                mDrawThread.start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}
