package com.google.lenono.com.google.lenono.tuya;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lenono on 2016-06-30.
 */
public class TuYaView extends View {
    private Paint paint;//画笔
    private Canvas canvas;//画板
    private Bitmap bitmap;//纸
    private Path path;//路径
    private float mx, my;

    public TuYaView(Context context, int screenWidth, int screenHeight) {
        super(context);
        //把显示屏的大小给bitmap 作为纸，
        bitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        //把纸放在画板上
        canvas = new Canvas(bitmap);
        //拿到笔，并对笔进行设置
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

    }

    public TuYaView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TuYaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("aaa", "onTouchEvent");
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.i("aaa", "down");
                // 触摸时 path的起点
                path = new Path();
                path.moveTo(x, y);
                mx = x;
                my = y;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("aaa", "move");
                //移动时的相对位置的位移
                float dx = Math.abs(x - mx);
                float dy = Math.abs(y - my);
                //当位移大于4时，用笔把路径画出来，
                if (dx > 4 || dy > 4) {
                    path.lineTo(x, y);
                    canvas.drawPath(path, paint);
                }
                mx = x;
                my = y;
                break;
            case MotionEvent.ACTION_UP:
                Log.i("aaa","up");
                break;
        }
     invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
