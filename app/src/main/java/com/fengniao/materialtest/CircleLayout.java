package com.fengniao.materialtest;

import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by a1 on 2017/1/16.
 */

public class CircleLayout extends ViewGroup {

    public CircleLayout(Context context) {
        super(context);
    }

    public CircleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int childCount = getChildCount();
//        if (childCount == 0) {
//            setMeasuredDimension(0, 0);
//        } else {
//            if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
//                setMeasuredDimension(getMaxchildWidth(), getTotleHeight());
//            } else if (widthMode == MeasureSpec.AT_MOST) {
//                setMeasuredDimension(getMeasuredWidth(), heightSize);
//            } else if (heightMode == MeasureSpec.AT_MOST) {
//                setMeasuredDimension(widthSize, getTotleHeight());
//            }
//        }
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


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount() - 1;
        int radius = getMeasuredHeight() / 2 > getMeasuredWidth() ? getMeasuredWidth() : getMeasuredHeight() / 2;
        View centerView = getChildAt(0);
        centerView.layout(getPaddingLeft(), getMeasuredHeight() / 2 - centerView.getMeasuredHeight() / 2
                , centerView.getMeasuredWidth() + getPaddingLeft(), getMeasuredHeight() / 2 + centerView.getMeasuredHeight() / 2);
        for (int i = 0; i < childCount; i++) {
            getChildAt(i + 1).layout((int) (getPaddingLeft() + radius * Math.sin(i / (childCount - 1) * Math.PI) - getChildAt(i + 1).getMeasuredWidth() / 2)
                    , (int) (getMeasuredHeight() / 2 - radius * Math.cos(1 / (childCount - 1) * Math.PI) - getChildAt(i + 1).getMeasuredHeight() / 2)
                    , (int) (getPaddingLeft() + radius * Math.sin(i / (childCount - 1) * Math.PI) + getChildAt(i + 1).getMeasuredWidth() / 2)
                    , (int) (getMeasuredHeight() / 2 - radius * Math.cos(1 / (childCount - 1) * Math.PI) + getChildAt(i + 1).getMeasuredHeight() / 2));
        }
    }
}
