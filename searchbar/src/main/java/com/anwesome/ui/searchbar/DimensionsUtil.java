package com.anwesome.ui.searchbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;

/**
 * Created by anweshmishra on 29/03/17.
 */
public class DimensionsUtil {
    public static Point getDimensions(Activity activity) {
        DisplayManager displayManager = (DisplayManager)activity.getSystemService(Context.DISPLAY_SERVICE);
        Point point = new Point();
        Display display = displayManager.getDisplay(0);
        display.getRealSize(point);
        return point;
    }
}
