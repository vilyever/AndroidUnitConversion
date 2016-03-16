package com.vilyever.unitconversion;

import android.util.DisplayMetrics;

import com.vilyever.resource.Resource;

/**
 * DimenConverter
 * AndroidUnitConversion <com.vilyever.vdunitconversion>
 * Created by vilyever on 2015/9/15.
 * Feature:
 */
public class DimenConverter {
    private final DimenConverter self = this;

    /* Public Methods */
    /**
     * 转换px到dp
     * @param pixel 原px
     * @return dp
     */
    public static int pixelToDp(int pixel) {
        DisplayMetrics displayMetrics = Resource.getDisplayMetrics();
        return (int) ((pixel / displayMetrics.density) + 0.5);
    }

    /**
     * 转换dp到px
     * @param dip 原dp
     * @return px
     */
    public static int dpToPixel(int dip) {
        DisplayMetrics displayMetrics = Resource.getDisplayMetrics();
        return (int) ((dip * displayMetrics.density) + 0.5);
    }

    /**
     * 转换px到sp，通常用于字体大小
     * @param pixel 原px
     * @return sp
     */
    public static int pixelToSp(int pixel) {
        DisplayMetrics displayMetrics = Resource.getDisplayMetrics();
        return (int) ((pixel / displayMetrics.scaledDensity) + 0.5);
    }

    /**
     * 转换sp到px
     * @param sp 原sp
     * @return px
     */
    public static int spToPixel(int sp) {
        DisplayMetrics displayMetrics = Resource.getDisplayMetrics();
        return (int) ((sp * displayMetrics.scaledDensity) + 0.5);
    }
}