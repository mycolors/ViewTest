package com.fengniao.materialtest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by a1 on 2017/1/4.
 */

public class MyViewGroup extends ViewGroup {
    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int widthMod = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMod = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int childCount = getChildCount();
        if (childCount == 0) {
            //如果没有子view当前viewgroup没有存在的意义，不必占空间
            setMeasuredDimension(0, 0);
        } else {
            //如果宽高都是包裹内容
            if (widthMod == MeasureSpec.AT_MOST && heightMod == MeasureSpec.AT_MOST) {
                //高度为所有子view高度相加
                int height = getTotleHeight();
                //宽度为子view中最大的宽度
                int width = getMaxchildWidth();
                setMeasuredDimension(width, height);
            } else if (widthMod == MeasureSpec.AT_MOST) {
                //如果只有宽度为包裹内容，高度就是viewgroup测量出来的内容,宽度为子view最大宽度

                setMeasuredDimension(getMaxchildWidth(), heightSize);
            } else if (heightMod == MeasureSpec.AT_MOST) {
                //如果只有高度为包裹内容，高度是所有子view的高度和，宽度为测量出来的宽度
                setMeasuredDimension(widthSize, getTotleHeight());
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        //记录当前的高度位置
        int curHeight = t;
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            int height = childView.getMeasuredHeight();
            int width = childView.getMeasuredWidth();
            childView.layout(l, curHeight, l + width, curHeight + height);
            curHeight += height;
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("mycolors", "actionDown");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("mycolors", "actionMove");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("mycolors", "actionup");
                break;
        }
        Log.i("mycolors", "viewgroup     " + "dispatchTouchEvent");
        return true;
//        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("mycolors", "viewgroup     " + "onInterceptTouchEvent");
//        return true;
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        Log.i("mycolors", "viewgroup     " + "setOnTouchListener");
        super.setOnTouchListener(l);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("mycolors", "viewgroup     " + "onTouchEvent");
//        return false;
        return super.onTouchEvent(event);
    }

    /**
     * 获取子View中宽度最大的值
     */
    private int getMaxchildWidth() {
        int childCount = getChildCount();
        int maxWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getMeasuredWidth() > maxWidth) {
                maxWidth = childView.getMeasuredWidth();
            }
        }
        return maxWidth;
    }


    /**
     * 将所有子View高度相加
     */
    private int getTotleHeight() {
        int childCount = getChildCount();
        int height = 0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            height = height + childView.getMeasuredHeight();
        }
        return height;
    }


}
