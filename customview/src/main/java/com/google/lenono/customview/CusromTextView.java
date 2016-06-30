package com.google.lenono.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by lenono on 2016-06-29.
 */
public class CusromTextView extends TextView {
    private String value;

    public CusromTextView(Context context) {
        super(context);
    }

    public CusromTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i("aaa", "使用xml布局");
        value = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        Log.i("aaa", "value=" + value);
    }

    public CusromTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
      //  super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setFakeBoldText(true);
        canvas.drawText(value, 0, getTextSize(), p);
    }

    public CusromTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
