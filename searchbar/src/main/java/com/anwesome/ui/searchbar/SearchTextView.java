package com.anwesome.ui.searchbar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.widget.EditText;

/**
 * Created by anweshmishra on 29/03/17.
 */
public class SearchTextView extends EditText{
    private boolean shouldAnimate = true;
    private SearchBarAnimator scaleAnimator = new SearchBarAnimator(0,1);
    public SearchTextView(Context context) {
        super(context);
        setScaleX(0);
        initAnimator();
    }
    public void initAnimator() {
        scaleAnimator.setUpdateAnimateAdapter(new AnimatorAdapter(){
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SearchTextView.this.setScaleX((float)valueAnimator.getAnimatedValue());
                shouldAnimate = false;
            }
        });
        AnimatorAdapter endAnimator = new AnimatorAdapter(){
            public void onAnimationEnd(Animator animator) {
                shouldAnimate = true;
            }
        };
        scaleAnimator.setEndAnimateAdapter(endAnimator);
        scaleAnimator.setReverseEndAnimateAdapter(endAnimator);
    }
    public void startShowing() {
        if(shouldAnimate) {
            scaleAnimator.start();
        }
    }
}
