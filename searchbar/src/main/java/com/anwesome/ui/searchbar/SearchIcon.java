package com.anwesome.ui.searchbar;

import android.animation.Animator;
import android.animation.ValueAnimator;
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
    public boolean opened = false,animating = false;
    private SearchBarAnimator translateAnimator,rotateAnimator;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public SearchIcon(Context context,int w) {
        super(context);
        initAnimator(w);
    }
    public void initAnimator(int w) {
        translateAnimator = new SearchBarAnimator(getX(),w);
        rotateAnimator = new SearchBarAnimator(-45,45);
        translateAnimator.setUpdateAnimateAdapter(new AnimatorAdapter(){
            public void onAnimationUpdate(ValueAnimator animator) {
                SearchIcon.this.setX((float)animator.getAnimatedValue());
                animating = true;
            }
        });
        rotateAnimator.setUpdateAnimateAdapter(new AnimatorAdapter(){
            public void onAnimationUpdate(ValueAnimator animator) {
                SearchIcon.this.setRotation((float)animator.getAnimatedValue());
                animating = true;
            }
        });
        AnimatorAdapter translateEndAnimateAdapter = new AnimatorAdapter(){
            public void onAnimationEnd(Animator animator) {
                opened = !opened;
                animating = false;
                rotateAnimator.start();
            }
        };
        AnimatorAdapter rotateEndAnimateAdapter = new AnimatorAdapter(){
            public void onAnimationEnd(Animator animator) {
                animating = false;
            }
        };
        translateAnimator.setEndAnimateAdapter(translateEndAnimateAdapter);
        translateAnimator.setReverseEndAnimateAdapter(translateEndAnimateAdapter);
        rotateAnimator.setEndAnimateAdapter(rotateEndAnimateAdapter);
        translateAnimator.setReverseEndAnimateAdapter(rotateEndAnimateAdapter);
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
            if(onClickListener!=null) {
                onClickListener.onClick(this);
            }
            translateAnimator.start();
        }
        return true;
    }

}
