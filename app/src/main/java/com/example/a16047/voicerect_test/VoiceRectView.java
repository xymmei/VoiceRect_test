package com.example.a16047.voicerect_test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by 16047 on 2018/3/7.
 */

public class VoiceRectView extends View {
    int offset;
    int mRectWidth,mRectHeight;
    int mWidth;
    int mRectCount;
    Paint mPaint;
    double mRandom;
    LinearGradient mLinearGradient;
    public VoiceRectView(Context context) {
        super(context);
        init();
    }

    private void init() {

        offset=10;
        mRectWidth=65;
        mWidth=200;
        mRectCount=15;
        mRectHeight=800;
    }

    public VoiceRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VoiceRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint=new Paint();
        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.FILL);
        for(int i=0;i<mRectCount;i++){
            mRandom=Math.random();
            float currentHeight=(float)(mRectHeight*mRandom);
            canvas.drawRect(
                    (float)(mWidth+mRectWidth*i+offset),
                    currentHeight,
                    (float)(mWidth+mRectWidth*(i+1)),
                    mRectHeight,
                    mPaint
                    );
        }
        postInvalidateDelayed(300);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Log.i(TAG, "onSizeChanged: getWidth()="+getWidth());
        Log.i(TAG, "onSizeChanged: getHeight()="+getHeight());
        Log.i(TAG, "onSizeChanged: mRectWidth="+(int)(mWidth*0.6/mRectCount));
      /*  mLinearGradient=new LinearGradient(
                0,
                0,
                mRectWidth,
                0,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP
        );
        mPaint.setShader(mLinearGradient);*/
    }
}
