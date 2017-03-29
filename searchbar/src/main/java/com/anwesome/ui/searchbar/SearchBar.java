package com.anwesome.ui.searchbar;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * Created by anweshmishra on 29/03/17.
 */
public class SearchBar {
    private Activity activity;
    private SearchTextView searchTextView;
    private RelativeLayout relativeLayout;
    private SearchIcon searchIcon;
    private int barColor = Color.parseColor("#3F51B5");
    public SearchBar(Activity activity) {
        this.activity = activity;
    }
    public void show(DataSource dataSource,OnMatchListener onMatchListener) {
        if(relativeLayout == null) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            relativeLayout = new RelativeLayout(activity);
            Point dimension = DimensionsUtil.getDimensions(activity);
            int w = dimension.x,h = dimension.y;
            relativeLayout.setBackgroundColor(barColor);
            activity.addContentView(relativeLayout,new ViewGroup.LayoutParams(w,h/10));
            searchIcon = new SearchIcon(activity,4*w/5);
            searchTextView = new SearchTextView(activity,dataSource,onMatchListener);
            relativeLayout.addView(searchIcon,new ViewGroup.LayoutParams(w/6,w/6));
            relativeLayout.addView(searchTextView,new ViewGroup.LayoutParams(7*w/10,h/15));
            searchIcon.setRotation(-45);
            searchIcon.setX(2*w/5);
            searchIcon.setY(h/10-w/8);
            searchTextView.setX(w/10);
            searchTextView.setY(h/60);
            searchIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    searchTextView.startShowing();
                }
            });
        }
    }
}
