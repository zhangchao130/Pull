package com.google.lenono.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.google.lenono.customview.R;

/**
 * Created by lenono on 2016-06-30.
 */
public class CustomView extends View {
    String txt_value;
    Drawable image_value;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.customview_attrs);
        txt_value = typedArray.getString(R.styleable.customview_attrs_txt);
        image_value = typedArray.getDrawable(R.styleable.customview_attrs_image);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setFakeBoldText(true);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) image_value;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.drawText(txt_value, bitmap.getWidth(), (bitmap.getHeight() + paint.getTextSize()) / 2, paint);
    }
}
