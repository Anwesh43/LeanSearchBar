package com.anwesome.ui.searchbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 29/03/17.
 */
public class SearchIcon extends View {
    private OnClickListener onClickListener;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public SearchIcon(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth(),h = canvas.getHeight();
        canvas.drawColor(Color.parseColor("#00FFFFFF"));
        paint.setColor(Color.parseColor("#EEEEEE"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(canvas.getWidth()/20);
        canvas.drawLine(w/2,h,w/2,h/2,paint);
        canvas.drawCircle(w/2,h/2-h/4,h/4,paint);
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {

        }
        return true;
    }

}
