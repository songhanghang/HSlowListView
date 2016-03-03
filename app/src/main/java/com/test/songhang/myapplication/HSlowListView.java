package com.test.songhang.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
/**
 * Created by songhang on 16/3/3.
 * 横向迟钝ListView, 控制listview的横向滑动灵敏度
 */
public class HSlowListView extends ListView {
    private float downX, downY;
    public HSlowListView(Context context) {
        super(context);
    }

    public HSlowListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HSlowListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = ev.getX();
                downY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float curX = ev.getX();
                float curY = ev.getY();
                //横向滑动距离大于2倍竖向滑动距离时，认为横滑操作，向下传递
                if (Math.abs(curX - downX) > 2 * Math.abs(curY - downY)) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
