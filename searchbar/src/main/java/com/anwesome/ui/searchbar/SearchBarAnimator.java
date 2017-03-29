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
        animator.addListener(animateAdapter);
    }
    public void setEndAnimateAdapter(AnimatorAdapter animateAdapter) {
        reverseAnimator.addListener(animateAdapter);
    }
    public void setUpdateAnimator(AnimatorAdapter animatorAdapter) {
        reverseAnimator.addUpdateListener(animatorAdapter);
        animator.addUpdateListener(animatorAdapter);
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
