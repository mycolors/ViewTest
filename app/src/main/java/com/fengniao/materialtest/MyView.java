package com.fengniao.materialtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static java.lang.Math.max;

/**
 * Created by a1 on 2017/1/4.
 */

public class MyView extends View {
    private int defaultSize;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        defaultSize = a.getDimensionPixelSize(R.styleable.MyView_default_size, 100);
        a.recycle();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getSize(defaultSize, widthMeasureSpec);
        int height = getSize(defaultSize, widthMeasureSpec);
        if (width > height) {
            width = height;
        } else {
            height = width;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("mycolors", "view            " + "dispatchTouchEvent");
//        return false;
        return super.dispatchTouchEvent(event);
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                Log.i("mycolors", "view      " + "actionDown");
        }
        Log.i("mycolors", "view     " + "onTouchEvent");
//        return false;
        return super.onTouchEvent(event);
    }

    private int getSize(int defaultSize, int measureSpec) {
        int mySize = defaultSize;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                //如果没有指定大小，就设置为默认大小
                mySize = defaultSize;
                break;
            case MeasureSpec.AT_MOST:
                //如果测量模式是最大值为size
//                //我们将大小取最大值，也可以取其他值
//                if (mySize < size) {
//                    break;
//                } else {
//                    mySize = size;
//                }
//                break;
            case MeasureSpec.EXACTLY:
                //如果是固定的大小就不去改变他
                mySize = size;
                break;
        }
        return mySize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //圆半径
        int padding = max(max(getPaddingBottom(), getPaddingTop()), max(getPaddingLeft(), getPaddingRight()));
        int r = getMeasuredHeight() / 2 - padding;
        //圆心的横坐标
        int centerX = r + getPaddingLeft();
        int centerY = r + getPaddingLeft();
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(centerX, centerY, r, paint);
    }
}
