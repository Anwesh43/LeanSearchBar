package com.anwesome.ui.searchbar;


import android.animation.ValueAnimator;

/**
 * Created by anweshmishra on 29/03/17.
 */
public class SearchBarAnimator {
    private ValueAnimator animator,reverseAnimator;
    private boolean reverse = false;
    public SearchBarAnimator(float from,float to) {
        animator = ValueAnimator.ofFloat(from,to);
        reverseAnimator = ValueAnimator.ofFloat(to,from);
        animator.setDuration(1000);
        reverseAnimator.setDuration(1000);
    }
    public void setUpdateAnimateAdapter(AnimatorAdapter animateAdapter) {
        reverseAnimator.addUpdateListener(animateAdapter);
        animator.addUpdateListener(animateAdapter);
    }
    public void setEndAnimateAdapter(AnimatorAdapter animateAdapter) {
        animator.addListener(animateAdapter);
    }
    public void setReverseEndAnimateAdapter(AnimatorAdapter animatorAdapter) {
        reverseAnimator.addListener(animatorAdapter);
    }
    public void start() {
        if(reverse) {
            reverseAnimator.start();
        }
        else {
            animator.start();
        }
        reverse = !reverse;
    }

}
