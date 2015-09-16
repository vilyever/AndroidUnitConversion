package com.vilyever.unitconversion;

import android.util.DisplayMetrics;

import com.vilyever.contextholder.VDContextHolder;

/**
 * VDDimenConversion
 * AndroidUnitConversion <com.vilyever.vdunitconversion>
 * Created by vilyever on 2015/9/15.
 * Feature:
 */
public class VDDimenConversion {
    private final VDDimenConversion self = this;

    
    /* #Constructors */    
    
    /* #Overrides */    
    
    /* #Accessors */     
     
    /* #Delegates */     
     
    /* #Private Methods */

    /* #Public Methods */
    public static int pixelToDp(int pixel) {
        DisplayMetrics displayMetrics = VDContextHolder.getContext().getResources()
                .getDisplayMetrics();
        return (int) ((pixel / displayMetrics.density) + 0.5);
    }

    public static int dpToPixel(int dip) {
        DisplayMetrics displayMetrics = VDContextHolder.getContext().getResources()
                .getDisplayMetrics();
        return (int) ((dip * displayMetrics.density) + 0.5);
    }

    public static int pixelToSp(int pixel) {
        DisplayMetrics displayMetrics = VDContextHolder.getContext().getResources()
                .getDisplayMetrics();
        return (int) ((pixel / displayMetrics.scaledDensity) + 0.5);
    }

    public static int spToPixel(int sp) {
        DisplayMetrics displayMetrics = VDContextHolder.getContext().getResources()
                .getDisplayMetrics();
        return (int) ((sp * displayMetrics.scaledDensity) + 0.5);
    }

    /* #Classes */

    /* #Interfaces */     
     
    /* #Annotations @interface */    
    
    /* #Enums */
}