package com.example.richie.myfragtofrag;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by Richie on 18-04-2015.
 */
public class ScreenUtility {

    private Activity avt;
    private float dpwidth;
    private float dpheight;

    public ScreenUtility(Activity avt) {
        this.avt = avt;
        Display dp = avt.getWindowManager().getDefaultDisplay();
        DisplayMetrics metric = new DisplayMetrics();
        dp.getMetrics(metric);

        float density = avt.getResources().getDisplayMetrics().density;
        dpwidth = metric.widthPixels/density;
        dpheight = metric.heightPixels/density;

    }

    public float getDpwidth(){
        return dpwidth;
    }
    public float getDpheight(){
        return dpheight;
    }



}

