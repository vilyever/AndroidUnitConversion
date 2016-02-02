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

    /* Public Methods */
    /**
     * 转换px到dp
     * @param pixel 原px
     * @return dp
     */
    public static int pixelToDp(int pixel) {
        DisplayMetrics displayMetrics = VDContextHolder.getContext().getResources()
                .getDisplayMetrics();
        return (int) ((pixel / displayMetrics.density) + 0.5);
    }

    /**
     * 转换dp到px
     * @param dip 原dp
     * @return px
     */
    public static int dpToPixel(int dip) {
        DisplayMetrics displayMetrics = VDContextHolder.getContext().getResources()
                .getDisplayMetrics();
        return (int) ((dip * displayMetrics.density) + 0.5);
    }

    /**
     * 转换px到sp，通常用于字体大小
     * @param pixel 原px
     * @return sp
     */
    public static int pixelToSp(int pixel) {
        DisplayMetrics displayMetrics = VDContextHolder.getContext().getResources()
                .getDisplayMetrics();
        return (int) ((pixel / displayMetrics.scaledDensity) + 0.5);
    }

    /**
     * 转换sp到px
     * @param sp 原sp
     * @return px
     */
    public static int spToPixel(int sp) {
        DisplayMetrics displayMetrics = VDContextHolder.getContext().getResources()
                .getDisplayMetrics();
        return (int) ((sp * displayMetrics.scaledDensity) + 0.5);
    }
}