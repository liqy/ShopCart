package com.bwie.shopcart.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.bwie.shopcart.R;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/10 15:38
 */

public class MyView extends View{

    Paint paint=new Paint();
    private int centerX, centerY;
    float r=10;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray ty=getContext().obtainStyledAttributes(attrs, R.styleable.MyViewAttr);
        r=ty.getFloat(R.styleable.MyViewAttr_liqyR,10);
        ty.recycle();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w/2;
        centerY = h/2;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 根据触摸位置更新控制点，并提示重绘
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);

        paint.setColor(Color.RED);
        canvas.drawCircle(100,100,100,paint);

        paint.setColor(Color.BLUE);
        canvas.drawCircle(100,100,r,paint);

        canvas.translate(centerX, centerY);  // 移动坐标系到屏幕中心(宽高数据在onSizeChanged中获取)

        Path path = new Path();                     // 创建Path

        path.lineTo(200, 200);                      // lineTo
        path.lineTo(200,0);

        canvas.drawPath(path, paint);              // 绘制Path
    }
}
