package com.google.lenono.customLinearLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.google.lenono.customview.R;

/**
 * Created by lenono on 2016-06-29.
 */
public class CustomLayout extends LinearLayout {


    public CustomLayout(Context context) {
        super(context);
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        //得到布局
        LayoutInflater.from(context).inflate(R.layout.custom_layout,this,true);
    }

    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}

